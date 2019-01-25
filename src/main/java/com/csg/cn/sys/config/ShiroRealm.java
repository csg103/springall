package com.csg.cn.sys.config;

import com.csg.cn.db.entity.SysAuth;
import com.csg.cn.db.entity.SysRole;
import com.csg.cn.db.entity.SysUser;
import com.csg.cn.db.vo.SysCompanySimple;
import com.csg.cn.sys.service.SysAuthService;
import com.csg.cn.sys.service.SysCompanyService;
import com.csg.cn.sys.service.SysRoleService;
import com.csg.cn.sys.service.SysUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yangzy on 2018/10/31.
 */
public class ShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(AuthorizingRealm.class);

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysAuthService sysAuthService;
    @Autowired
    private SysCompanyService sysCompanyService;

    /***
     * 配置权限 注入权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        logger.info("************************ configuration permissions *****************************");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();

        try{
            List<SysRole> sysRoles = sysUser.getSysRoles();
            for(SysRole sysRole : sysRoles){
                authorizationInfo.addRole(sysRole.getRoleName());
                for(SysAuth sysAuth : sysRole.getSysAuths()){
                    authorizationInfo.addStringPermission(sysAuth.getAuthPermission());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(ExceptionUtils.getStackTrace(e));
        }

        return authorizationInfo;
    }

    /**
     * 获取用户信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        logger.info("************************ getting user information *****************************");

        String username = (String) authenticationToken.getPrincipal();
        SysUser sysUser = sysUserService.selectOneByUsername(username);
        if(null == sysUser){
            logger.info("************************ user does not exist *****************************");
            return null;
        }

        List<SysRole> sysRoles = sysRoleService.selectListByUserId(sysUser.getId());
        sysUser.setSysRoles(sysRoles);

        List<SysCompanySimple> sysCompanySimples = sysCompanyService.userCompanies(sysUser.getId());
        if(CollectionUtils.isNotEmpty(sysCompanySimples)){
            sysUser.setCurrentCompanyId(sysCompanySimples.get(0).getCompanyId());
            sysUser.setCurrentCompanyName(sysCompanySimples.get(0).getCompanyName());
            sysUser.setSysCompanySimples(sysCompanySimples);
        }

        for(SysRole sysRole : sysRoles){
            List<SysAuth> sysAuths = sysAuthService.selectListByRoleId(sysRole.getId());
            sysRole.setSysAuths(sysAuths);
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                sysUser,
                sysUser.getPassword(),
                ByteSource.Util.bytes(sysUser.getSalt()),
                getName()
        );

        return authenticationInfo;
    }

}
