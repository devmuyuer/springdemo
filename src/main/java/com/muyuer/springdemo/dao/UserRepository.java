package com.muyuer.springdemo.dao;

import com.muyuer.springdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author muyuer 182443947@qq.com
 * @date 2018-12-02 09:50
 */
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery = true)
    User findByUsername(String userName);

    @Query(value = "SELECT * FROM user WHERE Id = ?1", nativeQuery = true)
    User findUserById(String userName);
}