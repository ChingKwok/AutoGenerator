package com.common.service.Impl;

import com.chingkwok.bean.entity.User;
import com.chingkwok.component.SnowflakeIdWorker;
import com.common.component.KeySettable;
import com.common.entity.SearchBean;
import com.common.mapper.BaseMapper;
import com.common.service.BaseService;
import com.common.entity.BaseEntity;
import com.common.utils.PagedResult;
import org.apache.shiro.SecurityUtils;
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
        if (record != null) {
            initInsertExtendData(record);
            return this.mapper.insert(record);
        } else {
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
    public PagedResult<T> selectPageResult(Map<String, Object> var1) {
        return null;
    }

    @Override
    public PagedResult<T> selectPageResult(SearchBean var1) {
        return null;
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


    private void initInsertExtendData(T record) {
        User principal = (User) SecurityUtils.getSubject().getPrincipal();
        record.setCreationTime(new Date());
        record.setCreatorUserId(principal.getUserId().toString());
        record.setCreatorUserName(principal.getUsername());
        record.setIsDeleted(false);
        initUpdateExtendData(record);
    }

    private void initUpdateExtendData(T record) {
        User principal = (User) SecurityUtils.getSubject().getPrincipal();
        record.setLastModificationTime(new Date());
        record.setLastModifierUserId(principal.getUserId().toString());
    }

    private void initDeleteExtendData(T record) {
        User principal = (User) SecurityUtils.getSubject().getPrincipal();
        record.setDeleterUserId(principal.getUserId().toString());
        record.setDeletionTime(new Date());
    }

}
