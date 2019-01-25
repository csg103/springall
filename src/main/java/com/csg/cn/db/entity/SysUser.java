package com.csg.cn.db.entity;

import com.csg.cn.db.vo.SysCompanySimple;

import javax.persistence.*;
import java.util.List;

@Table(name = "t_sys_user")
public class SysUser {
    /**
     * 用户id
     */
    @Id
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 用户密码
     */
    private String password;

    private String phone;

    /**
     * 加密
     */
    private String salt;

    /**
     * 状态
0：正常
     */
    @Column(name = "user_status")
    private String userStatus;

    /**
     * 部门id
     */
    @Column(name = "dept_id")
    private String deptId;

    @Transient
    private List<SysRole> sysRoles;

    @Transient
    private String currentCompanyId;

    @Transient
    private String currentCompanyName;

    @Transient
    private List<SysCompanySimple> sysCompanySimples;

    /**
     * 获取用户id
     *
     * @return id - 用户id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置用户id
     *
     * @param id 用户id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取真实姓名
     *
     * @return name - 真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置真实姓名
     *
     * @param name 真实姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户密码
     *
     * @return password - 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     *
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取加密
     *
     * @return salt - 加密
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置加密
     *
     * @param salt 加密
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取状态
0：正常
     *
     * @return user_status - 状态
0：正常
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * 设置状态
0：正常
     *
     * @param userStatus 状态
0：正常
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 获取部门id
     *
     * @return dept_id - 部门id
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * 设置部门id
     *
     * @param deptId 部门id
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public List<SysRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(List<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    public String getCurrentCompanyId() {
        return currentCompanyId;
    }

    public void setCurrentCompanyId(String currentCompanyId) {
        this.currentCompanyId = currentCompanyId;
    }

    public String getCurrentCompanyName() {
        return currentCompanyName;
    }

    public void setCurrentCompanyName(String currentCompanyName) {
        this.currentCompanyName = currentCompanyName;
    }

    public List<SysCompanySimple> getSysCompanySimples() {
        return sysCompanySimples;
    }

    public void setSysCompanySimples(List<SysCompanySimple> sysCompanySimples) {
        this.sysCompanySimples = sysCompanySimples;
    }
}