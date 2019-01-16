package com.csg.cn.db.entity;

import javax.persistence.*;

@Table(name = "t_sys_role_permission")
public class SysRolePermission {
    @Id
    private String id;

    @Column(name = "c_role_id")
    private String roleId;

    @Column(name = "c_permission_id")
    private String permissionId;

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
     * @return c_role_id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * @return c_permission_id
     */
    public String getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId
     */
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}