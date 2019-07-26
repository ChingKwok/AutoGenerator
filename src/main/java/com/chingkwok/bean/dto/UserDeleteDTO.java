package com.chingkwok.bean.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserDeleteDTO implements Serializable {
private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "", required = true)
    private Long userId;
}