package com.muyuer.springdemo.dao;

import com.muyuer.springdemo.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author muyuer 182443947@qq.com
 * @date 2018-12-17 09:59
 */
public interface SysUserRoleRepository extends JpaRepository<SysUserRole,Integer>{

    List<SysUserRole> findByUserId(Integer id);

    void deleteByUserId(Integer id);
}
