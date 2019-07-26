package com.common.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库表实体
 */
@Data
public class Table {
    /**
     * 表名
     */
    private String tableName;

    /**
     * 缩写
     */
    private String alias;

    /**
     * 字段列表
     */
    private List<Column> columns;

    /**
     * 备注
     */
    private String tableComment;

    /**
     * 实体类名
     */
    private String entityName;

    /**
     * 字段集
     */
    private List<String> columnSet;
}
