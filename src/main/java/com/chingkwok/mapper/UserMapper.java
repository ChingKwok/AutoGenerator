package com.chingkwok.mapper;

import com.chingkwok.bean.entity.User;
import com.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}