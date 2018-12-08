package com.muyuer.springdemo.dao;

import com.muyuer.springdemo.entity.AllUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author muyuer 182443947@qq.com
 * @version 1.0
 * @date 2018-12-06 06:03
 */
public interface AllUserRepository extends JpaRepository<AllUserEntity, Long> {

}
