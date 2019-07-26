package com.chingkwok.bean.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.Data;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;


@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserVO implements Serializable {
private static final long serialVersionUID = 1L;

    /**
    *   
    */
    @ApiModelProperty(value = "")
    private Long userId;

    /**
    *   
    */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "")
    private String nickname;

    /**
    *   
    */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "")
    private String username;

    /**
    *   
    */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "")
    private String password;

    /**
    *   
    */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "")
    private String mobile;

    /**
    *   
    */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "")
    private String salt;

    /**
    *   
    */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "")
    private String email;

    /**
    *   
    */
    @ApiModelProperty(value = "")
    private Long lastModifierUserId;

    /**
    *   
    */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "")
    private Date lastModificationTime;

    /**
    *   
    */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "")
    private String creatorUserName;

    /**
    *   
    */
    @ApiModelProperty(value = "")
    private Long creatorUserId;

    /**
    *   
    */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "")
    private Date creationTime;

    /**
    *   
    */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "")
    private Date deletionTime;

    /**
    *   
    */
    @ApiModelProperty(value = "")
    private Byte isDeleted;

    /**
    *   
    */
    @ApiModelProperty(value = "")
    private Long deleterUserId;


}