package com.muyuer.springdemo.controller;

import com.muyuer.springdemo.enums.REnum;
import com.muyuer.springdemo.exception.SystemException;
import com.muyuer.springdemo.from.SysUserFrom;
import com.muyuer.springdemo.service.SysUserService;
import com.muyuer.springdemo.utils.Assert;
import com.muyuer.springdemo.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author muyuer 182443947@qq.com
 * @date 2018-12-17 21:59
 */
@RestController
@RequestMapping("/sys")
@Slf4j
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    /**
     * 新增用户
     * @param sysUserFrom
     * @param bindingResult
     * @return
     */
    //@RequiresPermissions("sys:user:insert")
    @PostMapping("/saveUser")
    public R saveUser(@Valid @RequestBody SysUserFrom sysUserFrom,
                      BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【新增用户】参数不正确:sysUserFrom={}"+ sysUserFrom);
            throw new SystemException(REnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        return sysUserService.saveUser(sysUserFrom);
    }


    /**
     * 查询用户列表
     * @param page
     * @param size
     * @param name
     * @return
     */
    //@RequiresPermissions("sys:user:list")
    @GetMapping("/selectUserList")
    public R selectUserList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "size", defaultValue = "10") Integer size,
                            @RequestParam(value = "name",defaultValue = "") String name){

        PageRequest pageRequest = PageRequest.of(page,size);
        return sysUserService.selectUserList(name,pageRequest);
    }

    /**
     * 查询用户详情
     * @param id
     * @return
     */
    @RequiresPermissions("sys:user:detail")
    @GetMapping("/selectUserDetail")
    public R selectUserDetail(@RequestParam(value = "id",required = false) Integer id){

        Assert.isNull(id,"id不能为空");
        return sysUserService.selectUserDetail(id);
    }

    /**
     * 更新用户
     * @param sysUserFrom
     * @param bindingResult
     * @return
     */
    @RequiresPermissions("sys:user:update")
    @PutMapping("/updateUser")
    public R updateUser(@Valid @RequestBody SysUserFrom sysUserFrom,
                        BindingResult bindingResult){

        Assert.isNull(sysUserFrom.getId(),"id不能为空");

        if(bindingResult.hasErrors()){
            log.error("【更新用户】参数不正确:sysRoleFrom={}"+ sysUserFrom);
            throw new SystemException(REnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        return sysUserService.updateUser(sysUserFrom);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequiresPermissions("sys:user:delete")
    @DeleteMapping("/deleteUser/{id}")
    public R deleteUser(@PathVariable Integer id){
        return sysUserService.delectUser(id);
    }
}
