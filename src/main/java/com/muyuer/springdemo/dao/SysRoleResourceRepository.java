package com.muyuer.springdemo.dao;

import com.muyuer.springdemo.entity.SysRoleResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author muyuer 182443947@qq.com
 * @date 2018-12-17 09:59
 */
public interface SysRoleResourceRepository extends JpaRepository<SysRoleResource,Integer> {

    List<SysRoleResource> findByRoleId(Integer roleId);

    List<SysRoleResource> findByRoleId(List<Integer> roleIds);

    void deleteByRoleId(Integer id);
}
