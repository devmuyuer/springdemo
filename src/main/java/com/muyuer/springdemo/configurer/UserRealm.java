//package com.muyuer.springdemo.configurer;
//
//import com.muyuer.springdemo.entity.SysUser;
//import com.muyuer.springdemo.enums.ForbiddenEnum;
//import com.muyuer.springdemo.enums.REnum;
//import com.muyuer.springdemo.from.SysUserFrom;
//import com.muyuer.springdemo.service.SysResourceService;
//import com.muyuer.springdemo.service.SysUserService;
//import com.muyuer.springdemo.shiro.JwtToken;
//import com.muyuer.springdemo.utils.JwtUtil;
//import com.muyuer.springdemo.utils.ShiroUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authc.credential.CredentialsMatcher;
//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * 认证与授权规则
// * @author muyuer 182443947@qq.com
// * @date 2018-12-03 10:37
// */
//@Slf4j
//@Component
//public class UserRealm extends AuthorizingRealm{
//
//    @Autowired
//    SysUserService sysUserService;
//
//    @Autowired
//    SysResourceService sysResourceService;
//
//    /**
//     * 大坑！，必须重写此方法，不然Shiro会报错
//     */
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof JwtToken;
//    }
//    /**
//     * 用户授权
//     * @param principalCollection
//     * @return
//     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
////        String username = JwtUtil.getUsername(principalCollection.toString());
////        SysUser user = sysUserService.findByAccount(username);
////        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
////        return simpleAuthorizationInfo;
//
////        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
////        simpleAuthorizationInfo.setStringPermissions(sysResourceService.selectUserPerms(ShiroUtil.getUserId()));
////        return simpleAuthorizationInfo;
//
//        String username = JwtUtil.getUsername(principalCollection.toString());
//        SysUser user = sysUserService.findByAccount(username);
//
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//
//        simpleAuthorizationInfo.setStringPermissions(sysResourceService.selectUserPerms(user.getId()));
//        return simpleAuthorizationInfo;
//
////        SysUserVo userFrom =  (SysUserVo)sysUserService.selectUserDetail(user.getId()).getData();
////        simpleAuthorizationInfo.addRole(userFrom.);
////
////       // Set<String> permission = new HashSet<>(Arrays.asList(user.getPermission().split(",")));
////        List<String> permission = new List<String>();
////        //Set<String> permission = userFrom.getSysRoles();
////        simpleAuthorizationInfo.addStringPermissions(permission);
////        return simpleAuthorizationInfo;
//    }
//
//    /**
//     * 用户认证
//     * @param authenticationToken
//     * @return
//     * @throws AuthenticationException
//     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
//        // 解密获得username，用于和数据库进行对比
//        String username = JwtUtil.getUsername(token.getUsername());
//        if (username == null) {
//            throw new AuthenticationException("token无效");
//        }
////        SysUser userBean = sysUserService.findByAccount(username);
////        if (userBean == null) {
////            throw new AuthenticationException("用户不存在!");
////        }
////        if (!JwtUtil.verify(token, username, userBean.getPassword())) {
////            throw new AuthenticationException("用户名或密码错误");
////        }
////        return new SimpleAuthenticationInfo(token, token, "my_realm");
//
//
////        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
////
////        SysUser sysUser = sysUserService.findByAccount(token.getUsername());
//        SysUser sysUser = sysUserService.findByAccount(username);
//        if(sysUser == null){
//            log.error(REnum.UNkNOWN_ACCOUNT.getMessage()+"SysUser = {}"+ sysUser);
//            throw new UnknownAccountException();
//        }
//        if(ForbiddenEnum.DISABLE.getCode().toString().equals(sysUser.getForbidden())){
//            log.error(REnum.UNkNOWN_ACCOUNT.getMessage()+"SysUser = {}"+sysUser);
//            throw new DisabledAccountException();
//        }
//        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(sysUser,sysUser.getPassword(),getName());
//        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(sysUser.getSalt()));
//        return simpleAuthenticationInfo;
//    }
//
//    /**
//     * 密码验证服务
//     * @param credentialsMatcher
//     */
//    @Override
//    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
//        HashedCredentialsMatcher md5HashedCredentialsMatcher = new HashedCredentialsMatcher();
//        md5HashedCredentialsMatcher.setHashAlgorithmName(ShiroUtil.hashAlgorithmName);
//        md5HashedCredentialsMatcher.setHashIterations(ShiroUtil.hashIterations);
//        md5HashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
//        super.setCredentialsMatcher(md5HashedCredentialsMatcher);
//    }
//}
