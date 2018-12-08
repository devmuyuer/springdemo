package com.muyuer.springdemo.dao;

import com.muyuer.springdemo.entity.AllUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author muyuer 182443947@qq.com
 * @version 1.0
 * @date 2018-12-06 06:03
 */
public interface AllUserRepository extends JpaRepository<AllUserEntity, Long> {

    @Query(value = "SELECT * FROM all_user WHERE user_account = ?1", nativeQuery = true)
    AllUserEntity getByAccount(String userAccount);
}
