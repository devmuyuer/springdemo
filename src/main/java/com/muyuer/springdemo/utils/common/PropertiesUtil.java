package com.muyuer.springdemo.utils.common;

import com.muyuer.springdemo.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Properties工具
 * @author MuYuer 182443947@qq.com
 * @date 2018-12-25 21:59
 */
public class PropertiesUtil {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesUtil.class);

    /**
     * PROP
     */
    private static final Properties PROP = new Properties();

    /**
     * 读取配置文件
     * @param fileName
     * @return void
     */
    public static void readProperties(String fileName){
        InputStream in = null;
        try {
            in = PropertiesUtil.class.getResourceAsStream("/" + fileName);
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            PROP.load(bf);
        } catch (IOException e){
            LOGGER.error("PropertiesUtil工具类读取配置文件出现IOException异常:" + e.getMessage());
            throw new CustomException("PropertiesUtil工具类读取配置文件出现IOException异常:" + e.getMessage());
        } finally {
            try{
                if(in != null){
                    in.close();
                }
            }catch (IOException e){
                LOGGER.error("PropertiesUtil工具类读取配置文件出现IOException异常:" + e.getMessage());
                throw new CustomException("PropertiesUtil工具类读取配置文件出现IOException异常:" + e.getMessage());
            }
        }
    }

    /**
     * 根据key读取对应的value
     * @param key
     * @return java.lang.String
     */
    public static String getProperty(String key){
        return PROP.getProperty(key);
    }
}
