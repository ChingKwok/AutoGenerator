package com.chingkwok.exception.eum;

import lombok.Getter;

/**
 * Created by guojingye on 2019/7/17
 */
@Getter
public enum AutoGeneratorExceptionEnum {
    DATASOURCE_NOT_EXIST(900, "数据源不存在"),
    DATABASE_DENY(901, "数据库用户名&密码错误"),
    DATABASE_TABLE_NOT_EXIST(902, "数据库表不存在"),
    DATABASE_COLUMN_NOT_EXIST(903, "表为空"),
    CREATE_FILE_FAILURE(401, "创建模板目标文件失败"),
    LOGIN_AUTHENTICATION_INFO_ERROR(800, "用户登录信息错误"),
    LOGIN_NOT_EXIST(801, "用户不存在"),
    USERNAME_REPEAT_ERROR(802, "用户名重复"),

    RECORD_NOT_EXISTS(701, "记录不存在"),
    UPDATE_FAILURE(702, "更新记录失败"),
    DELETE_FAILURE(703, "删除记录失败"),
    ADD_FAILURE(704, "添加记录失败");
    private int code;
    private String info;


    AutoGeneratorExceptionEnum(int code, String info) {
        this.code = code;
        this.info = info;
    }
}
