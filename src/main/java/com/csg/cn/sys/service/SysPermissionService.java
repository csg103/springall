package com.csg.cn.sys.service;


import com.csg.cn.db.entity.PermissionWithSubCount;
import com.csg.cn.db.entity.SysPermission;

import java.util.List;
import java.util.Set;

/**
 * @author
 * @description
 * @date
 **/
public interface SysPermissionService {

    List<SysPermission> getPermissionsByPid(String pid);

    void insert(SysPermission sysPermission);

    SysPermission selectById(String id);

    void update(SysPermission sysPermission);

    long countSubPermission(String id);

    void deletePermission(String id);

    /**
     * 查询角色的权限
     * @param roleId
     * @return
     */
    Set<String> rolesPermission(String roleId);

    /**
     * 查询子权限数量
     * @param pid
     * @return
     */
    long countSubPermissionByPid(String pid);

    /**
     * 根据pid查询权限及对应子权限个数
     * @param pid
     * @return
     */
    List<PermissionWithSubCount> selectPermissionWithSubCount(String pid);

    /**
     * 获取用户对应权限菜单
     * @param ctx
     * @param userId
     * @return
     */
    String menuTree(String ctx, String userId);
}
