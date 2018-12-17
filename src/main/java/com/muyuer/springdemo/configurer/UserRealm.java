package com.muyuer.springdemo.configurer;

import com.muyuer.springdemo.entity.SysUser;
import com.muyuer.springdemo.enums.ForbiddenEnum;
import com.muyuer.springdemo.enums.REnum;
import com.muyuer.springdemo.service.SysResourceService;
import com.muyuer.springdemo.service.SysUserService;
import com.muyuer.springdemo.utils.ShiroUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 认证与授权规则
 * @author muyuer 182443947@qq.com
 * @date 2018-12-03 10:37
 */
@Slf4j
@Component
public class UserRealm extends AuthorizingRealm{

    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysResourceService sysResourceService;

    /**
     * 用户授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(sysResourceService.selectUserPerms(ShiroUtil.getUserId()));
        return simpleAuthorizationInfo;
    }

    /**
     * 用户认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;

        SysUser sysUser = sysUserService.findByAccount(token.getUsername());
        if(sysUser == null){
            log.error(REnum.UNkNOWN_ACCOUNT.getMessage()+"SysUser = {}"+sysUser);
            throw new UnknownAccountException();
        }
        if(ForbiddenEnum.DISABLE.getCode().toString().equals(sysUser.getForbidden())){
            log.error(REnum.UNkNOWN_ACCOUNT.getMessage()+"SysUser = {}"+sysUser);
            throw new DisabledAccountException();
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(sysUser,sysUser.getPassword(),getName());
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(sysUser.getSalt()));
        return simpleAuthenticationInfo;
    }

    /**
     * 密码验证服务
     * @param credentialsMatcher
     */
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher md5HashedCredentialsMatcher = new HashedCredentialsMatcher();
        md5HashedCredentialsMatcher.setHashAlgorithmName(ShiroUtil.hashAlgorithmName);
        md5HashedCredentialsMatcher.setHashIterations(ShiroUtil.hashIterations);
        md5HashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        super.setCredentialsMatcher(md5HashedCredentialsMatcher);
    }
}
