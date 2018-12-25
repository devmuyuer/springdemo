package com.muyuer.springdemo.utils;


import com.muyuer.springdemo.vo.R;

/**
 * 对象模型工具类
 * @author muyuer 182443947@qq.com
 * @date 2018-12-18 17:58
 */
public class RUtil {

    public static R success(Object object){
        R r = new R();
        r.setCode(0);
        r.setMsg("ok");
        r.setData(object);
        return r;
    }

    public static R success(){
        return success(null);
    }

    public static R error(Integer code, String msg){
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }
}
