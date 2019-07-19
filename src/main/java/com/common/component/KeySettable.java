package com.common.component;

/**
 * Created by guojingye on 2019/7/18
 */
@FunctionalInterface
public interface KeySettable<T> {
    void setPrimaryKey(T entity, long key);
}
