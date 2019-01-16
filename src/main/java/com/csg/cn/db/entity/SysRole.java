package com.csg.cn.db.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "t_sys_role")
public class SysRole {
    @Id
    private String id;

    /**
     * 角色名
     */
    @Column(name = "c_role")
    private String role;

    /**
     * 角色描述
     */
    @Column(name = "c_description")
    private String description;

    /**
     * 启用状态 1 启用 0 停用
     */
    @Column(name = "c_flag")
    private Byte flag;


    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    @Transient
    private List<SysPermission> permissions;



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
     * 获取角色名
     *
     * @return c_role - 角色名
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置角色名
     *
     * @param role 角色名
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 获取角色描述
     *
     * @return c_description - 角色描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置角色描述
     *
     * @param description 角色描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取启用状态 1 启用 0 停用
     *
     * @return c_flag - 启用状态 1 启用 0 停用
     */
    public Byte getFlag() {
        return flag;
    }

    /**
     * 设置启用状态 1 启用 0 停用
     *
     * @param flag 启用状态 1 启用 0 停用
     */
    public void setFlag(Byte flag) {
        this.flag = flag;
    }
}