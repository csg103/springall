package com.csg.cn.db.entity;

import javax.persistence.*;

@Table(name = "t_sys_permission")
public class SysPermission {
    @Id
    private String id;

    @Column(name = "c_name")
    private String name;

    @Column(name = "c_url")
    private String url;

    @Column(name = "c_permission")
    private String permission;

    @Column(name = "c_pid")
    private String pid;

    private String UserId;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    /**
     * 是否为菜单权限 1 是 0 否
     */
    @Column(name = "c_is_menu")
    private Integer isMenu;




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
     * @return c_name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return c_url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return c_permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     * @param permission
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * @return c_pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * 获取是否为菜单权限 1 是 0 否
     *
     * @return c_is_menu - 是否为菜单权限 1 是 0 否
     */
    public Integer getIsMenu() {
        return isMenu;
    }

    /**
     * 设置是否为菜单权限 1 是 0 否
     *
     * @param isMenu 是否为菜单权限 1 是 0 否
     */
    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }
}