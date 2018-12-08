package com.muyuer.springdemo.core;

import com.muyuer.springdemo.enums.REnum;
import com.muyuer.springdemo.exception.SystemException;
import com.muyuer.springdemo.utils.SnowflakeIdHelper;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;
import java.io.Serializable;

/**
 * 自定义ID生成器
 * @author muyuer 182443947@qq.com
 * @version 1.0
 * @date 2018-12-08 15:42
 */
public class CustomIDGenerator extends IdentityGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws MappingException {
        Object id =  SnowflakeIdHelper.getId();
        if (id != null) {
            return (Serializable) id;
        }
        else{
            throw new SystemException(REnum.PARAM_ERROR.getCode(),"主键生成失败");
        }
    }
}
