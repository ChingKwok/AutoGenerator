package com.chingkwok.service;

import com.chingkwok.bean.entity.User;

import java.util.List;

/**
 * Created by guojingye on 2019/7/17
 */
public interface UserService {
    List<User> searchUserByUserName(String username);

    int insert(User user);

    int update(User user);

    int delete(long userId);
}
