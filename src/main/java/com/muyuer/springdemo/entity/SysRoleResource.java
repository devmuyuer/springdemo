package com.muyuer.springdemo.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 角色资源关系
 * @author muyuer 182443947@qq.com
 * @date 2018-12-17 09:59
 */
@Data
@Entity
public class SysRoleResource {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 资源id
     */
    private Integer resourceId;
}
