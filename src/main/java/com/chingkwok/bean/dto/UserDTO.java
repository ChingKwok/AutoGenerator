package com.chingkwok.bean.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
public class UserDTO implements Serializable {
private static final long serialVersionUID = 1L;

    /**
    *   
    */
    private Long userId;

    /**
    *   
    */
    private String nickname;

    /**
    *   
    */
    private String username;

    /**
    *   
    */
    private String password;

    /**
    *   
    */
    private String mobile;

    /**
    *   
    */
    private String salt;

    /**
    *   
    */
    private String email;


}