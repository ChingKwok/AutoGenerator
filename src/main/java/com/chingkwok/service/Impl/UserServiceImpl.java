package com.chingkwok.service.Impl;

import com.chingkwok.bean.entity.User;
import com.chingkwok.bean.entity.UserExample;
import com.chingkwok.mapper.UserMapper;
import com.chingkwok.service.UserService;
import com.chingkwok.component.SnowflakeIdWorker;
import com.common.service.Impl.BaseServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guojingye on 2019/7/17
 */
@Service
public class UserServiceImpl extends BaseServerImpl<User> implements UserService  {

    @Autowired
    UserMapper userMapper;

    @Autowired
    SnowflakeIdWorker snowflakeIdWorker;

    @Override
    public List<User> searchUserByUserName(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return userMapper.selectByExample(userExample);
    }


    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(long userId) {
        return 0;
    }

}
