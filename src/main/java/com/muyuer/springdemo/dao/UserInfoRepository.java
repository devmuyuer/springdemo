package com.muyuer.springdemo.dao;

/**
 * @author muyuer 182443947@qq.com
 * @date 2018-11-30 14:18
 */
import com.muyuer.springdemo.entity.UserInfo;
import com.muyuer.springdemo.entity.ViewInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    @Query(value = "SELECT new com.muyuer.springdemo.entity.ViewInfo(u, a) FROM UserInfo u, Address a WHERE u.addressId = a.addressId")
    public List<ViewInfo> findViewInfo();

}