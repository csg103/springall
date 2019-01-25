package com.csg.cn.db.entity;

import javax.persistence.*;

@Table(name = "t_sys_auth")
public class SysAuth {
    @Id
    private String id;

    /**
     * 权限名称
     */
    @Column(name = "auth_name")
    private String authName;

    /**
     * 资源路径
     */
    @Column(name = "auth_url")
    private String authUrl;

    /**
     * 权限字符串
     */
    @Column(name = "auth_permission")
    private String authPermission;

    /**
     * 权限类型
0：菜单
1：按钮
     */
    @Column(name = "auth_type")
    private String authType;

    /**
     * 权限状态
0：未启用
1：启用
     */
    @Column(name = "auth_status")
    private String authStatus;

    /**
     * 权限描述
     */
    @Column(name = "auth_description")
    private String authDescription;

    @Column(name = "auth_parent_id")
    private String authParentId;

    @Column(name = "auth_order")
    private Integer authOrder;

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
     * 获取权限名称
     *
     * @return auth_name - 权限名称
     */
    public String getAuthName() {
        return authName;
    }

    /**
     * 设置权限名称
     *
     * @param authName 权限名称
     */
    public void setAuthName(String authName) {
        this.authName = authName;
    }

    /**
     * 获取资源路径
     *
     * @return auth_url - 资源路径
     */
    public String getAuthUrl() {
        return authUrl;
    }

    /**
     * 设置资源路径
     *
     * @param authUrl 资源路径
     */
    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    /**
     * 获取权限字符串
     *
     * @return auth_permission - 权限字符串
     */
    public String getAuthPermission() {
        return authPermission;
    }

    /**
     * 设置权限字符串
     *
     * @param authPermission 权限字符串
     */
    public void setAuthPermission(String authPermission) {
        this.authPermission = authPermission;
    }

    /**
     * 获取权限类型
0：菜单
1：按钮
     *
     * @return auth_type - 权限类型
0：菜单
1：按钮
     */
    public String getAuthType() {
        return authType;
    }

    /**
     * 设置权限类型
0：菜单
1：按钮
     *
     * @param authType 权限类型
0：菜单
1：按钮
     */
    public void setAuthType(String authType) {
        this.authType = authType;
    }

    /**
     * 获取权限状态
0：未启用
1：启用
     *
     * @return auth_status - 权限状态
0：未启用
1：启用
     */
    public String getAuthStatus() {
        return authStatus;
    }

    /**
     * 设置权限状态
0：未启用
1：启用
     *
     * @param authStatus 权限状态
0：未启用
1：启用
     */
    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    /**
     * 获取权限描述
     *
     * @return auth_description - 权限描述
     */
    public String getAuthDescription() {
        return authDescription;
    }

    /**
     * 设置权限描述
     *
     * @param authDescription 权限描述
     */
    public void setAuthDescription(String authDescription) {
        this.authDescription = authDescription;
    }

    /**
     * @return auth_parent_id
     */
    public String getAuthParentId() {
        return authParentId;
    }

    /**
     * @param authParentId
     */
    public void setAuthParentId(String authParentId) {
        this.authParentId = authParentId;
    }

    /**
     * @return auth_order
     */
    public Integer getAuthOrder() {
        return authOrder;
    }

    /**
     * @param authOrder
     */
    public void setAuthOrder(Integer authOrder) {
        this.authOrder = authOrder;
    }
}