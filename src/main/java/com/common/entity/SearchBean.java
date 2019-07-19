package com.common.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by guojingye on 2019/7/18
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SearchBean {
    @ApiModelProperty(
            example = "string,排序字段名"
    )
    private String sortName;
    @ApiModelProperty(
            example = "string,排序顺序(asc|desc)"
    )
    private String sortOrder;
    @ApiModelProperty(
            example = "int,第几页"
    )
    private Integer pageIndex;
    @ApiModelProperty(
            example = "int,每页数量"
    )
    private Integer pageSize;
    @ApiModelProperty(
            example = "boolean,是否搜索全部"
    )
    private Boolean searchAll;

    public SearchBean() {
    }
}
