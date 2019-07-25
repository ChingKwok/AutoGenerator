package com.common.service.Impl;

import com.chingkwok.bean.entity.User;
import com.chingkwok.component.SnowflakeIdWorker;
import com.chingkwok.utils.ConvertUtils;
import com.chingkwok.utils.PagedResult;
import com.chingkwok.utils.ParseUtils;
import com.chingkwok.utils.interfaceFun.PagedResultHandler;
import com.common.component.KeySettable;
import com.common.entity.SearchBean;
import com.common.mapper.BaseMapper;
import com.common.service.BaseService;
import com.common.entity.BaseEntity;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by guojingye on 2019/7/18
 */
public abstract class BaseServerImpl<T extends BaseEntity> implements BaseService<T> {

    @Autowired
    BaseMapper<T> mapper;

    @Autowired
    SnowflakeIdWorker snowflakeIdWorker;

    public int insert(T record) {
        try {
            if (record != null) {
                initInsertExtendData(record);
                return this.mapper.insert(record);
            } else {
                return -1;
            }
        } catch (UnavailableSecurityManagerException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int insert(T record, KeySettable<T> keySettable) {
        Long key = snowflakeIdWorker.nextId();
        if (key != null) {
            keySettable.setPrimaryKey(record, key);
            return this.insert(record);
        } else {
            return -1;
        }
    }

    @Override
    public int insertSelective(T record, KeySettable<T> keySettable) {
        Long generateKey = snowflakeIdWorker.nextId();
        if (generateKey != null) {
            keySettable.setPrimaryKey(record, generateKey);
            return this.insertSelective(record);
        } else {
            return -1;
        }
    }

    @Override
    public int insertSelective(T record) {
        if (record != null) {
            this.initInsertExtendData(record);
            return this.mapper.insertSelective(record);
        } else {
            return -1;
        }
    }

    @Override
    public int delete(T record) {
        this.initDeleteExtendData(record);
        return this.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Object id) {
        T record = this.selectByPrimaryKey(id);
        if (record != null) {
            return this.delete(record);
        } else {
            return -1;
        }
    }

    @Override
    public int updateByPrimaryKey(T record) {
        this.initUpdateExtendData(record);
        return this.mapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        this.initUpdateExtendData(record);
        return this.mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public T selectByPrimaryKey(Object id) {
        T record = this.mapper.selectByPrimaryKey(id);
        return record != null && !record.getIsDeleted() ? record : null;
    }

    @Override
    public List<T> selectAll() {
        return this.mapper.selectAll();
    }

    @Override
    public List<T> selectAll(Map<String, Object> map) {
        return this.mapper.selectByMap(map);
    }

    @Override
    public PagedResult<T> selectPageResult(Map<String, Object> map) {
        return selectPageResult(map, () -> mapper.selectByMap(map));
    }

    @Override
    public PagedResult<T> selectPageResult(SearchBean searchBean) {
        if (searchBean.getSearchAll() != null && searchBean.getSearchAll()) {
            return selectAllPageResult(() -> this.mapper.selectByMap(ConvertUtils.convertMap(searchBean))
            );
        } else {
            return selectPageResult(ConvertUtils.convertMap(searchBean));
        }

    }

    protected <E> PagedResult<E> selectPageResult(Map<String, Object> map, PagedResultHandler<E> handler) {
        PageHelper.startPage(getPageIndex(map), getPageSize(map));
        List<E> tList = handler.handle();
        return new PagedResult<>(tList, new PageInfo<>(tList).getTotal());
    }

    protected <E> PagedResult<E> selectAllPageResult(PagedResultHandler<E> handler) {
        List<E> tList = handler.handle();
        return new PagedResult<>(tList, (new PageInfo<>(tList)).getTotal());
    }

    protected int getPageIndex(Map<String, Object> map) {
        return ParseUtils.parseInt(map.get("pageIndex"), 1);
    }

    protected int getPageSize(Map<String, Object> map) {
        return ParseUtils.parseInt(map.get("pageSize"), 20);
    }

    @Override
    public void initBaseEntity(T var1) {

    }

    @Override
    public boolean isOwner(T var1) {
        return false;
    }

    @Override
    public void checkOwner(T var1) {

    }

    @Override
    public int insertList(List<T> var1) {
        return 0;
    }

    @Override
    public int insertListSelective(List<T> var1) {
        return 0;
    }

    @Override
    public int updateList(List<T> var1) {
        return 0;
    }

    @Override
    public int deleteList(List<T> var1) {
        return 0;
    }

    @Override
    public T selectOneByMap(Map<String, Object> var1) {
        return null;
    }

    private User getLoginUser() throws UnavailableSecurityManagerException {
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    private void initInsertExtendData(T record) {
        User principal = getLoginUser();
        record.setCreationTime(new Date());
        record.setCreatorUserId(principal.getUserId().toString());
        record.setCreatorUserName(principal.getUsername());
        record.setIsDeleted(false);
        initUpdateExtendData(record);
    }

    private void initUpdateExtendData(T record) {
        User principal = getLoginUser();
        record.setLastModificationTime(new Date());
        record.setLastModifierUserId(principal.getUserId().toString());
    }

    private void initDeleteExtendData(T record) {
        User principal = getLoginUser();
        record.setDeleterUserId(principal.getUserId().toString());
        record.setDeletionTime(new Date());
    }

}
