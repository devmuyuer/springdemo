package com.muyuer.springdemo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.muyuer.springdemo.entity.SysUser;
import org.springframework.stereotype.Service;

/**
 * @author muyuer 182443947@qq.com
 * @date 2018-12-02 09:59
 */
@Service("TokenService")
public class TokenService {
    public String getToken(SysUser user) {
        String token = "";
        // 将 user id 保存到 token 里面
        token= JWT.create().withAudience(String.valueOf(user.getId()))
                // 以 password 作为 token 的密钥
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
