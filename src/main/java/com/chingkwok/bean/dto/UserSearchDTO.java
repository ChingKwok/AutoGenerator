package com.chingkwok.bean.dto;

import com.common.entity.SearchBean;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserSearchDTO extends SearchBean {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "", required = true)
    private String likeNickname;

    @ApiModelProperty(value = "", required = true)
    private String likeUsername;

    @ApiModelProperty(value = "", required = true)
    private String likePassword;

    @ApiModelProperty(value = "", required = true)
    private String likeMobile;

    @ApiModelProperty(value = "", required = true)
    private String likeSalt;

    @ApiModelProperty(value = "", required = true)
    private String likeEmail;

    @ApiModelProperty(value = "", required = true)
    private Date gtLastModificationTime;

    @ApiModelProperty(value = "", required = true)
    private Date ltLastModificationTime;

    @ApiModelProperty(value = "", required = true)
    private String likeCreatorUserName;

    @ApiModelProperty(value = "", required = true)
    private Date gtCreationTime;

    @ApiModelProperty(value = "", required = true)
    private Date ltCreationTime;

    @ApiModelProperty(value = "", required = true)
    private Date gtDeletionTime;

    @ApiModelProperty(value = "", required = true)
    private Date ltDeletionTime;

    @ApiModelProperty(value = "", required = true)
    private Boolean eqIsDeleted;
}