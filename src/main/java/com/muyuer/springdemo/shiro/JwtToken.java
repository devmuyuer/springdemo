package com.muyuer.springdemo.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * JwtToken
 * @author MuYuer 182443947@qq.com
 * @date 2018-12-25 21:59
 */
public class JwtToken implements AuthenticationToken {
    /**
     * Token
     */
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
