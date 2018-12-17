package com.muyuer.springdemo.service;

import com.muyuer.springdemo.entity.SysUser;
import com.muyuer.springdemo.from.SysUserFrom;
import com.muyuer.springdemo.vo.R;
import org.springframework.data.domain.Pageable;


/**
 * author: 小宇宙
 * date: 2018/4/5
 */
public interface SysUserService {

    SysUser findByAccount(String account);

    R saveUser(SysUserFrom sysUserFrom);

    R selectUserList(String name, Pageable pageable);

    R selectUserDetail(Integer id);

    R updateUser(SysUserFrom sysUserFrom);

    R delectUser(Integer id);
}
