package com.muyuer.springdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.muyuer.springdemo.core.Constant;
import com.muyuer.springdemo.entity.SysUser;
import com.muyuer.springdemo.enums.REnum;
import com.muyuer.springdemo.exception.CustomUnauthorizedException;
import com.muyuer.springdemo.service.SysUserService;
import com.muyuer.springdemo.service.TokenService;
import com.muyuer.springdemo.shiro.jwt.JwtUtil;
import com.muyuer.springdemo.utils.*;
import com.muyuer.springdemo.utils.common.StringUtil;
import com.muyuer.springdemo.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author muyuer 182443947@qq.com
 * @date 2018-12-17 21:59
 */
@RestController
@RequestMapping("/anno")
@Slf4j
public class AnnoController {

    /**
     * RefreshToken过期时间
     */
    @Value("${refreshTokenExpireTime}")
    private String refreshTokenExpireTime;

    @Autowired
    SysUserService sysUserService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public R login(@RequestBody Map<String,String> map, HttpServletResponse httpServletResponse) {
        String userName = map.get("account");
        String password = map.get("password");

        if (StringUtil.isBlank(userName)) {
            return RUtil.error(-1, "账号不能为空");
        }
        if (StringUtil.isBlank(userName)) {
            return RUtil.error(-1, "密码不能为空");
        }

        SysUser sysUser = sysUserService.findByAccount(userName);
        if (sysUser == null) {
            throw new CustomUnauthorizedException("该帐号不存在(The account does not exist.)");
        }

        // 密码进行AES解密
        String key = AesCipherUtil.deCrypto(sysUser.getPassword());
        // 因为密码加密是以帐号+密码的形式进行加密的，所以解密后的对比是帐号+密码
        if (key.equals(sysUser.getAccount() + password)) {
            // 清除可能存在的Shiro权限信息缓存
            if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE + sysUser.getAccount())) {
                JedisUtil.delKey(Constant.PREFIX_SHIRO_CACHE + sysUser.getAccount());
            }
            // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
            String currentTimeMillis = String.valueOf(System.currentTimeMillis());
            JedisUtil.setObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + sysUser.getAccount(), currentTimeMillis, Integer.parseInt(refreshTokenExpireTime));
            // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
            String token = JwtUtil.sign(sysUser.getAccount(), currentTimeMillis);
            httpServletResponse.setHeader("Authorization", token);
            httpServletResponse.setHeader("Access-Control-Expose-Headers", "Authorization");

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("token", token);
            jsonObject.put("user", sysUser);
            return RUtil.success(jsonObject);
            //return new ResponseBean(HttpStatus.OK.value(), "登录成功(Login Success.)", null);
        } else {
            throw new CustomUnauthorizedException("帐号或密码错误(Account or Password Error.)");
        }
    }

    /**
     * 退出
     * @return
     */
    @GetMapping("/logout")
    public R logout(){
        // ShiroUtil.logout();
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
