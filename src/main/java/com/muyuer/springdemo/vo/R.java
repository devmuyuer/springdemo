package com.muyuer.springdemo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Http返回的对象模型
 * @author muyuer 182443947@qq.com
 * @date 2018-12-17 17:24
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体数据
     */
    private T data;
}
