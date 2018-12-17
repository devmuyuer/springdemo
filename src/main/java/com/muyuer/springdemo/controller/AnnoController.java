package com.muyuer.springdemo.controller;

import com.muyuer.springdemo.enums.REnum;
import com.muyuer.springdemo.utils.Assert;
import com.muyuer.springdemo.utils.RUtil;
import com.muyuer.springdemo.utils.ShiroUtil;
import com.muyuer.springdemo.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
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

    @PostMapping("/login")
    public R login(@RequestBody Map<String,String> map){

        Assert.isBlank(map.get("account"),"账号不能为空");
        Assert.isBlank(map.get("password"),"密码不能为空");


        try{
            Subject subject = ShiroUtil.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(map.get("account"),map.get("password"));
            subject.login(token);
        }catch (UnknownAccountException e) {
           return RUtil.error(REnum.USERNAME_OR_PASSWORD_ERROR.getCode(),REnum.USERNAME_OR_PASSWORD_ERROR.getMessage());
        }catch (IncorrectCredentialsException e) {
           return RUtil.error(REnum.USERNAME_OR_PASSWORD_ERROR.getCode(),REnum.USERNAME_OR_PASSWORD_ERROR.getMessage());
        }catch (DisabledAccountException e) {
           return RUtil.error(REnum.ACCOUNT_DISABLE.getCode(),REnum.ACCOUNT_DISABLE.getMessage());
        }catch (AuthenticationException e) {
           return RUtil.error(REnum.AUTH_ERROR.getCode(),REnum.AUTH_ERROR.getMessage());
        }

        return RUtil.success();
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
