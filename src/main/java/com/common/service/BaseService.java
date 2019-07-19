package com.common.service;

import com.chingkwok.component.SnowflakeIdWorker;
import com.common.component.KeySettable;
import com.common.entity.BaseEntity;
import com.common.entity.SearchBean;
import com.common.utils.PagedResult;

import java.util.List;
import java.util.Map;

/**
 * Created by guojingye on 2019/7/18
 */
public interface BaseService<T extends BaseEntity> {
    int insert(T var1);

    int insert(T var1, KeySettable<T> var2);

    int insertSelective(T var1, KeySettable<T> var2);

    int insertSelective(T var1);

    int delete(T var1);

    int deleteByPrimaryKey(Object var1);

    int updateByPrimaryKey(T var1);

    int updateByPrimaryKeySelective(T var1);

    T selectByPrimaryKey(Object var1);

    List<T> selectAll();

    List<T> selectAll(Map<String, Object> var1);

    PagedResult<T> selectPageResult(Map<String, Object> var1);

    PagedResult<T> selectPageResult(SearchBean var1);

    void initBaseEntity(T var1);

    boolean isOwner(T var1);

    void checkOwner(T var1);

    int insertList(List<T> var1);

    int insertListSelective(List<T> var1);

    int updateList(List<T> var1);

    int deleteList(List<T> var1);

    T selectOneByMap(Map<String, Object> var1);
}
