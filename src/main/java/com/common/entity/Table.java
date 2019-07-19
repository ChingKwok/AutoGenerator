package com.common.entity;

import lombok.Data;

import java.util.List;

/**
 * Created by guojingye on 2019/7/18
 */
@Data
public class Table {
    private String tableName;
    private List<Column> columns;
    private String tableComment;
}
