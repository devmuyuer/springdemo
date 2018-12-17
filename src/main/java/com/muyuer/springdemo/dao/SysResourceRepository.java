package com.muyuer.springdemo.dao;

import com.muyuer.springdemo.entity.SysResource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author muyuer 182443947@qq.com
 * @date 2018-12-17 09:59
 */
public interface SysResourceRepository extends JpaRepository<SysResource,Integer> {
}
