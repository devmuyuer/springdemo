package com.muyuer.springdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.muyuer.springdemo.core.UserLoginToken;
import com.muyuer.springdemo.dao.UserRepository;
import com.muyuer.springdemo.entity.User;
import com.muyuer.springdemo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author muyuer 182443947@qq.com
 * @date 2018-12-02 10:00
 */
@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenService tokenService;
    //登录
    @PostMapping("/login")
    public Object login(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase=userRepository.findByUsername(user.getUsername());
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
//                String token = tokenService.getToken(userForBase);
//                jsonObject.put("token", token);
//                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
