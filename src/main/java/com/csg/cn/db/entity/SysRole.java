package com.csg.cn.db.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "t_sys_role")
public class SysRole {
    @Id
    private String id;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色描述
     */
    @Column(name = "role_description")
    private String roleDescription;

    /**
     * 状态
0：未启用
1：启用
     */
    @Column(name = "role_status")
    private String roleStatus;

    @Transient
    private List<SysAuth> sysAuths;

    @Transient
    private String lastRoleName;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色描述
     *
     * @return role_description - 角色描述
     */
    public String getRoleDescription() {
        return roleDescription;
    }

    /**
     * 设置角色描述
     *
     * @param roleDescription 角色描述
     */
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    /**
     * 获取状态
0：未启用
1：启用
     *
     * @return role_status - 状态
0：未启用
1：启用
     */
    public String getRoleStatus() {
        return roleStatus;
    }

    /**
     * 设置状态
0：未启用
1：启用
     *
     * @param roleStatus 状态
0：未启用
1：启用
     */
    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    public List<SysAuth> getSysAuths() {
        return sysAuths;
    }

    public void setSysAuths(List<SysAuth> sysAuths) {
        this.sysAuths = sysAuths;
    }

    public String getLastRoleName() {
        return lastRoleName;
    }

    public void setLastRoleName(String lastRoleName) {
        this.lastRoleName = lastRoleName;
    }
}