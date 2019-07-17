package com.chingkwok.bean.entity;

import com.common.entity.BaseEntity;
import lombok.Data;

@Data
public class User extends BaseEntity {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

}