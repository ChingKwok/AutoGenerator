package com.chingkwok.exception;

import com.chingkwok.exception.eum.AutoGeneratorExceptionEnum;

/**
 * Created by guojingye on 2019/7/17
 */
public class AutoGeneratorException extends RuntimeException {

    private int code;

    private String info;

    private AutoGeneratorException(){

    }

    public AutoGeneratorException(AutoGeneratorExceptionEnum exceptionEnum){
        this.code = exceptionEnum.getCode();
        this.info = exceptionEnum.getInfo();
    }
}
