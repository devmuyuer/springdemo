package com.muyuer.springdemo.service;

import org.springframework.stereotype.Service;

/**
 * @author muyuer 182443947@qq.com
 * @date 2018-12-03 11:07
 */
public interface RedisService {
    /**
     * set存数据
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, String value);

    /**
     * get获取数据
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置有效天数
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * 移除数据
     * @param key
     * @return
     */
    boolean remove(String key);
}
