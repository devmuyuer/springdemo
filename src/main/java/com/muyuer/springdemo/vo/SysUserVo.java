package com.muyuer.springdemo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.muyuer.springdemo.entity.SysRole;
import lombok.Data;

import java.util.List;

/**
 * @author muyuer 182443947@qq.com
 * @date 2018-12-17 17:24
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysUserVo {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否禁用 0：否；1：是
     */
    private String forbidden;

    /**
     * 用户角色
     */
    private List<SysRole> sysRoles;
}
