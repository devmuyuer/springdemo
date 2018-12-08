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
@Service
public class AllUserService {
    @Autowired
    private AllUserRepository allUserRepository;

    //添加用户
    public AllUserEntity addUser(String userAccount, String userName)  {
        boolean flag;
        AllUserEntity user = new AllUserEntity();
        if (userAccount == null) {
            return null;
        } else {
            //判存在
            if (allUserRepository.getByAccount(userAccount) != null) {
                return null;
            } else {
                Long userId = SnowflakeIdHelper.getId();
                user.setUserId(userId);
                user.setUserName(userName);
                user.setUserAccount(userAccount);
                user.setPassword("123");
                allUserRepository.save(user);
                return user;
            }
        }
    }
}
