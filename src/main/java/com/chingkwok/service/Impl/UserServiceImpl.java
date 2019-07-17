package com.chingkwok.service.Impl;

import com.chingkwok.bean.entity.User;
import com.chingkwok.bean.entity.UserExample;
import com.chingkwok.mapper.UserMapper;
import com.chingkwok.service.UserService;
import com.common.utils.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by guojingye on 2019/7/17
 */
@Service
public class UserServiceImpl implements UserService  {

    @Autowired
    UserMapper userMapper;

    SnowflakeIdWorker snowflakeIdWorker;

    @Override
    public List<User> searchUserByUserName(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public int insert(User user) {
        user.setCreationTime(new Date());
        user.setDeleterUserId("");
        user.setDeletionTime(new Date(0));
        user.setIsDeleted(false);
        user.setCreatorUserId("");
        user.setLastModificationTime(new Date());
        user.setLastModifierUserId("");
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(long userId) {
        return 0;
    }

    public Long generateKey() {
        return Long.valueOf(this.getSnowflakeIdWorker().nextId());
    }

    public SnowflakeIdWorker getSnowflakeIdWorker() {
        if (this.snowflakeIdWorker == null) {
            this.snowflakeIdWorker = new SnowflakeIdWorker(1000,100);
        }
        return snowflakeIdWorker;
    }

}
