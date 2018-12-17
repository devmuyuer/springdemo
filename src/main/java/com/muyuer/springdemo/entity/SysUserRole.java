package com.muyuer.springdemo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 用户角色关系
 * @author muyuer 182443947@qq.com
 * @date 2018-12-17 09:59
 */
@Data
@Entity
public class SysUserRole {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue
    private Integer id;


    /**
     * 用户Id
     */
    private Integer userId;


    /**
     * 角色Id
     */
    private Integer roleId;
}
