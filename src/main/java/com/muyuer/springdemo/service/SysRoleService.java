package com.muyuer.springdemo.service;

import com.muyuer.springdemo.from.SysRoleFrom;
import com.muyuer.springdemo.vo.R;
import org.springframework.data.domain.Pageable;

/**
 * author: 小宇宙
 * date: 2018/4/5
 */
public interface SysRoleService {

    R saveRole(SysRoleFrom sysRoleFrom);

    R selectRoleList(String name, Pageable pageable);

    R selectRoleDetail(Integer id);

    R updateRole(SysRoleFrom sysRoleFrom);

    R deleteRole(Integer id);
}
