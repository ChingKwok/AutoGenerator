package com.chingkwok.service;

import com.chingkwok.bean.entity.User;
import com.common.service.BaseService;

import java.util.List;

/**
 * Created by guojingye on 2019/7/17
 */
public interface UserService extends BaseService<User> {
    List<User> searchUserByUserName(String username);

    int update(User user);

    int delete(long userId);
}
