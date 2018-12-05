package com.muyuer.springdemo.utils;

import java.util.HashSet;

/**
 * Twitter_Snowflake 生成ID
 * @author muyuer 182443947@qq.com
 * @version 1.0
 * @date 2018-12-05 17:58
 */
public class SnowflakeIdHelper {
    private static SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(1, 0);
    private static volatile SnowflakeIdHelper instance;
    private SnowflakeIdHelper() {}
    public static SnowflakeIdHelper getInstance() {
        if (instance == null) {
            synchronized (SnowflakeIdHelper.class) {
                if (instance == null) {
                    instance = new SnowflakeIdHelper();
                }
            }
        }
        return instance;
    }
    public static Long getId()  {
        return snowflakeIdWorker.nextId();
    }
}

