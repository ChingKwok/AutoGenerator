package com.common.mapper;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by guojingye on 2019/7/18
 */
public interface BaseMapper<T> extends Mapper<T> {
    List<T> selectByMap(Map<String, Object> var1);

    T selectOneByMap(Map<String, Object> var1);

    @InsertProvider(
            type = BaseMapperProvider.class,
            method = "dynamicSQL"
    )
    int insertList(List<T> var1);

//    @InsertProvider(
//            type = BaseMapperProvider.class,
//            method = "dynamicSQL"
//    )
//    int insertListSelective(List<T> var1);
//
    @UpdateProvider(
            type = BaseMapperProvider.class,
            method = "dynamicSQL"
    )
    int updateList(List<T> var1);
//
//    @UpdateProvider(
//            type = BaseMapperProvider.class,
//            method = "dynamicSQL"
//    )
//    int updateListNecessary(List<T> var1);
//
//    @UpdateProvider(
//            type = BaseMapperProvider.class,
//            method = "dynamicSQL"
//    )
//    int updateSelectionByPrimaryKey(@Param("record") T var1, @Param("primaryIdList") List<Long> var2);
//
//    @DeleteProvider(
//            type = BaseMapperProvider.class,
//            method = "dynamicSQL"
//    )
//    int deleteList(List<T> var1);
}
