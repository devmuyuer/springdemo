package com.muyuer.springdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.muyuer.springdemo.entity.SysUser;
import com.muyuer.springdemo.enums.REnum;
import com.muyuer.springdemo.service.SysUserService;
import com.muyuer.springdemo.service.TokenService;
import com.muyuer.springdemo.utils.Assert;
import com.muyuer.springdemo.utils.JWTUtil;
import com.muyuer.springdemo.utils.RUtil;
import com.muyuer.springdemo.utils.ShiroUtil;
import com.muyuer.springdemo.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author muyuer 182443947@qq.com
 * @date 2018-12-17 21:59
 */
@RestController
@RequestMapping("/anno")
@Slf4j
public class AnnoController {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public R login(@RequestBody Map<String,String> map){
        String userName = map.get("account");
        String password = map.get("password");
        Assert.isBlank(userName,"账号不能为空");
        Assert.isBlank(password,"密码不能为空");

        JSONObject jsonObject=new JSONObject();
        try{
            SysUser userForBase = sysUserService.findByAccount(userName);
            String tokenStr = JWTUtil.sign(userName, password);
            jsonObject.put("token", tokenStr);
            jsonObject.put("user", userForBase);
            return RUtil.success(jsonObject);
        }catch (UnknownAccountException e) {
           return RUtil.error(REnum.USERNAME_OR_PASSWORD_ERROR.getCode(),REnum.USERNAME_OR_PASSWORD_ERROR.getMessage());
        }catch (IncorrectCredentialsException e) {
           return RUtil.error(REnum.USERNAME_OR_PASSWORD_ERROR.getCode(),REnum.USERNAME_OR_PASSWORD_ERROR.getMessage());
        }catch (DisabledAccountException e) {
           return RUtil.error(REnum.ACCOUNT_DISABLE.getCode(),REnum.ACCOUNT_DISABLE.getMessage());
        }catch (AuthenticationException e) {
           return RUtil.error(REnum.AUTH_ERROR.getCode(),REnum.AUTH_ERROR.getMessage());
        }

    }

    /**
     * 退出
     * @return
     */
    @GetMapping("/logout")
    public R logout(){
        ShiroUtil.logout();
        return RUtil.success();
    }

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/notLogin")
    public R notLogin(){
       return RUtil.error(REnum.NOT_LOGIN.getCode(),REnum.NOT_LOGIN.getMessage());
    }
}
