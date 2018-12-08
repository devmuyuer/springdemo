package com.muyuer.springdemo.service;

import com.muyuer.springdemo.dao.AllUserRepository;
import com.muyuer.springdemo.entity.AllUserEntity;
import com.muyuer.springdemo.utils.SnowflakeIdHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author muyuer 182443947@qq.com
 * @version 1.0
 * @date 2018-12-06 05:20
 */
public interface AllUserService {

    AllUserEntity getByAccount(String userAccount);

    AllUserEntity addUser(String userAccount, String userName);
}
