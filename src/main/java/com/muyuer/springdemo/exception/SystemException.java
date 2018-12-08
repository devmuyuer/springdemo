package com.muyuer.springdemo.exception;

import com.muyuer.springdemo.enums.REnum;

/**
 * @author muyuer 182443947@qq.com
 * @version 1.0
 * @date 2018-12-08 20:06
 */
public class SystemException extends RuntimeException{

    private Integer code;

    public SystemException(REnum rEnum) {
        super(rEnum.getMessage());

        this.code = rEnum.getCode();
    }

    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(String message) {
        super(message);
    }
}
