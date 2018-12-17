package com.muyuer.springdemo.dao;

import com.muyuer.springdemo.entity.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author muyuer 182443947@qq.com
 * @date 2018-12-17 09:59
 */
public interface SysRoleRepository extends JpaRepository<SysRole,Integer> {

    Page<SysRole> findAll(Specification<SysRole> sysRoleSpecification, Pageable pageable);
}
