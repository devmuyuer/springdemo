package com.muyuer.springdemo.dao;

import com.muyuer.springdemo.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author muyuer 182443947@qq.com
 * @date 2018-12-17 09:59
 */
public interface SysUserRepository extends JpaRepository<SysUser,Integer> {

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    SysUser findByAccount(String account);

    Page<SysUser> findAll(Specification<SysUser> sysRoleSpecification, Pageable pageable);
}
