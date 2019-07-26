package com.common.entity;

import lombok.Data;

/**
 * 字段类
 */
@Data
public class Column {
    /**
     * 字段名
     */
    private String name;

    /**
     * 字段类型
     */
    private String typeName;

    /**
     * 字段类型代码
     */
    private Integer typeCode;

    /**
     * 字段备注
     */
    private String comment;

    /**
     * 字段实体类型名
     */
    private String property;

    /**
     * 是否主键
     */
    private Boolean isPrimary;

    /**
     * 是否基本字段
     */
    private Boolean isBase;

    /**
     * Java类型名
     */
    private String javaType;
}
