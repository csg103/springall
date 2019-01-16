package com.csg.cn.sys.config;


import com.csg.cn.db.dao.SysUserMapper;
import com.csg.cn.db.entity.SysPermission;
import com.csg.cn.db.entity.SysRole;
import com.csg.cn.db.entity.SysUser;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * @author
 * @description
 * @date
 **/
public class ShiroRealm extends AuthorizingRealm {

    private final static Logger logger = Logger.getLogger(ShiroRealm.class);

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();
        for (SysRole role : sysUser.getRoles()){
            authorizationInfo.addRole(role.getRole());
            for (SysPermission permission : role.getPermissions()){
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();

        SysUser sysUser = sysUserMapper.selectUserByUsername(username).get(0);

        if (sysUser == null){
            logger.info("瞎b填啥呢");
            return null;
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                sysUser,
                sysUser.getPassword(),
                ByteSource.Util.bytes(sysUser.getSalt()),
                getName()
        );
        return simpleAuthenticationInfo;
    }
}
