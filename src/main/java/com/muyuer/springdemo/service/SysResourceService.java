package com.muyuer.springdemo.service;

import java.util.Set;

/**
 * author: 小宇宙
 * date: 2018/4/5
 */
public interface SysResourceService {

    Set<String> selectUserPerms(Integer userId);

}
