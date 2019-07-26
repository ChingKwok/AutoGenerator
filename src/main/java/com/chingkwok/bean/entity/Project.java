package com.chingkwok.bean.entity;

import com.common.entity.BaseEntity;
import lombok.Data;

/**
 * 项目实体类
 */
@Data
public class Project extends BaseEntity {
    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 项目名
     */
    private String projectName;

    /**
     * 项目编码
     */
    private String projectCode;

    /**
     * 包名
     */
    private String packageName;

    /**
     * 数据库名
     */
    private String datasourceName;

    /**
     * 数据库ip
     */
    private String ipAddress;

    /**
     * 数据库用户名
     */
    private String username;

    /**
     * 数据库密码
     */
    private String password;

    /**
     * 数据库端口
     */
    private String port;


}