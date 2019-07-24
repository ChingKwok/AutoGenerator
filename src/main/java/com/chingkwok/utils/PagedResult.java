package com.chingkwok.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

/**
 * Created by guojingye on 2019/7/24
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PagedResult<T> {
    private long totalCount;
    private List<T> rows;

    public PagedResult(List<T> rows,long totalCount){
        this.rows = rows;
        this.totalCount = totalCount;
    }
}
