package com.chingkwok.bean.entity;

import com.common.entity.BaseEntity;
import lombok.Data;

@Data
public class Project extends BaseEntity {
    private Long projectId;

    private String projectName;

    private String projectCode;

    private String packageName;

    private String datasourceName;

    private String ipAddress;

    private String username;

    private String password;

    private String port;


}