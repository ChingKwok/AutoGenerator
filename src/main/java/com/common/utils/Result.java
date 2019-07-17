package com.common.utils;

import com.common.utils.eum.ResultEnum;
import lombok.Data;

/**
 * Created by guojingye on 2019/7/17
 */
@Data
public class Result {
    private Object object;

    private int code;

    private String info;

    private Result(){

    }

    public Result(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.info = resultEnum.getInfo();
    }

    public Result(ResultEnum resultEnum,String info){
        this.code = resultEnum.getCode();
        this.info = info;
    }
}
