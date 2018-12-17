package com.muyuer.springdemo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.muyuer.springdemo.entity.SysResource;
import lombok.Data;

import java.util.List;

/**
 * @author muyuer 182443947@qq.com
 * @date 2018-12-17 17:24
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysRoleVo {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色等级
     */
    private Integer grade;

    /**
     * 备注
     */
    private String remark;

    /**
     * 拥有资源
     */
    private List<SysResource> sysResources;
}
