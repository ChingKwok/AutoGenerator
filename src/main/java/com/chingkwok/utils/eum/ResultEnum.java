package com.chingkwok.utils.eum;

import lombok.Getter;

/**
 * Created by guojingye on 2019/7/17
 */
@Getter
public enum ResultEnum {
    SUCCESS(200,"返回结果成功"),
    FAILURE(201,"调用失败")
    ;
    private int code;
    private String info;

    ResultEnum(int code,String info){
        this.code = code;
        this.info = info;
    }
}
