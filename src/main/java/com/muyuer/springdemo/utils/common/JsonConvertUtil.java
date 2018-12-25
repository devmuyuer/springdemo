package com.muyuer.springdemo.utils.common;

import com.alibaba.fastjson.JSONObject;

/**
 * Json和Object的互相转换，转List必须Json最外层加[]，转Object，Json最外层不要加[]
 * @author MuYuer 182443947@qq.com
 * @date 2018-12-25 21:59
 */
public class JsonConvertUtil {
    /**
     * JSON 转 Object
     */
    public static <T> T jsonToObject(String pojo, Class<T> clazz) {
        return JSONObject.parseObject(pojo, clazz);
    }

    /**
     * Object 转 JSON
     */
    public static <T> String objectToJson(T t){
        return JSONObject.toJSONString(t);
    }
}
