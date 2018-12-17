package com.muyuer.springdemo.service.impl;

import com.muyuer.springdemo.dao.SysResourceRepository;
import com.muyuer.springdemo.dao.SysRoleResourceRepository;
import com.muyuer.springdemo.dao.SysUserRoleRepository;
import com.muyuer.springdemo.entity.SysResource;
import com.muyuer.springdemo.entity.SysRoleResource;
import com.muyuer.springdemo.entity.SysUserRole;
import com.muyuer.springdemo.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @version 1.0
 * @date 2018-12-17 20:06
 */
@Service
@Slf4j
@Transactional
public class SysResourceServiceImpl implements SysResourceService {

    @Autowired
    SysResourceRepository sysResourceRepository;

    @Autowired
    SysUserRoleRepository sysUserRoleRepository;

    @Autowired
    SysRoleResourceRepository sysRoleResourceRepository;

    /**
     * 查询用户权限表示符
     * @return
     */
    @Override
    public Set<String> selectUserPerms(Integer userId) {

        /*获取角色Id*/
        List<Integer> roleIds = new ArrayList<>();
        List<SysUserRole> sysUserRoles = sysUserRoleRepository.findByUserId(userId);
        sysUserRoles.forEach(o->{
            roleIds.add(o.getRoleId());
        });

        /*获取资源Id*/
        List<SysRoleResource> sysRoleResources = sysRoleResourceRepository.findByRoleId(roleIds);
        List<Integer> resourceIds = new ArrayList<>();
        sysRoleResources.forEach(o->{
            resourceIds.add(o.getResourceId());
        });

        /*获取权限标识符*/
        Set<String> prems = new HashSet<>();
        List<SysResource> sysResources = sysResourceRepository.findAllById(resourceIds);
        sysResources.forEach(o->{
            if(StringUtils.isNoneBlank(o.getPerms())){
                prems.add(o.getPerms());
            }
        });
        return prems;
    }
}
