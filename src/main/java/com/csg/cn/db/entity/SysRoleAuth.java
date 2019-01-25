package com.csg.cn.db.entity;

import javax.persistence.*;

@Table(name = "t_sys_role_auth")
public class SysRoleAuth {
    @Id
    private String id;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "auth_id")
    private String authId;

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
     * @return role_id
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
     * @return auth_id
     */
    public String getAuthId() {
        return authId;
    }

    /**
     * @param authId
     */
    public void setAuthId(String authId) {
        this.authId = authId;
    }
}