package com.csg.cn.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user_admin")
public class UserAdmin {
    @Id
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "c_username")
    private String username;

    /**
     * 姓名
     */
    @Column(name = "c_name")
    private String name;

    /**
     * 公司id，跟公司表t_company_admin中的id关联。
     */
    @Column(name = "n_company_id")
    private Integer companyId;

    /**
     * 部门表，跟t_user_admin_dept表的id关联
     */
    @Column(name = "n_dept_id")
    private Integer deptId;

    /**
     * 电子邮件
     */
    @Column(name = "c_email")
    private String email;

    /**
     * 座机
     */
    @Column(name = "c_phone")
    private String phone;

    /**
     * 手机
     */
    @Column(name = "c_mobile_phone")
    private String mobilePhone;

    /**
     * 角色id，跟角色表t_role_admin中的id关联。
     */
    @Column(name = "n_role_id")
    private Integer roleId;

    /**
     * 密码
     */
    @Column(name = "c_pwd")
    private String pwd;

    /**
     * 状态，0：删除，1：禁用，2：正常
     */
    @Column(name = "n_status")
    private Integer status;

    /**
     * 描述、介绍
     */
    @Column(name = "c_desc")
    private String desc;

    /**
     * 注册来源，null或0：本地系统，1：imp
     */
    @Column(name = "n_reg_source")
    private Integer regSource;

    /**
     * 上次登陆日期
     */
    @Column(name = "d_last_login")
    private Date lastLogin;

    /**
     * 上次登陆ip
     */
    @Column(name = "c_last_ip")
    private String lastIp;

    /**
     * 创建人用户名
     */
    @Column(name = "c_creator")
    private String creator;

    @Column(name = "d_update")
    private Date update;

    /**
     * 创建日期
     */
    @Column(name = "d_create")
    private Date create;

    /**
     * 扩展字段
     */
    @Column(name = "c_extra")
    private String extra;

    /**
     * 用户geo hash
     */
    @Column(name = "c_geo_hash")
    private String geoHash;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return c_username - 用户名
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
     * 获取姓名
     *
     * @return c_name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取公司id，跟公司表t_company_admin中的id关联。
     *
     * @return n_company_id - 公司id，跟公司表t_company_admin中的id关联。
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司id，跟公司表t_company_admin中的id关联。
     *
     * @param companyId 公司id，跟公司表t_company_admin中的id关联。
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取部门表，跟t_user_admin_dept表的id关联
     *
     * @return n_dept_id - 部门表，跟t_user_admin_dept表的id关联
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 设置部门表，跟t_user_admin_dept表的id关联
     *
     * @param deptId 部门表，跟t_user_admin_dept表的id关联
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取电子邮件
     *
     * @return c_email - 电子邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮件
     *
     * @param email 电子邮件
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取座机
     *
     * @return c_phone - 座机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置座机
     *
     * @param phone 座机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取手机
     *
     * @return c_mobile_phone - 手机
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置手机
     *
     * @param mobilePhone 手机
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * 获取角色id，跟角色表t_role_admin中的id关联。
     *
     * @return n_role_id - 角色id，跟角色表t_role_admin中的id关联。
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id，跟角色表t_role_admin中的id关联。
     *
     * @param roleId 角色id，跟角色表t_role_admin中的id关联。
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取密码
     *
     * @return c_pwd - 密码
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置密码
     *
     * @param pwd 密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取状态，0：删除，1：禁用，2：正常
     *
     * @return n_status - 状态，0：删除，1：禁用，2：正常
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态，0：删除，1：禁用，2：正常
     *
     * @param status 状态，0：删除，1：禁用，2：正常
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取描述、介绍
     *
     * @return c_desc - 描述、介绍
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置描述、介绍
     *
     * @param desc 描述、介绍
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取注册来源，null或0：本地系统，1：imp
     *
     * @return n_reg_source - 注册来源，null或0：本地系统，1：imp
     */
    public Integer getRegSource() {
        return regSource;
    }

    /**
     * 设置注册来源，null或0：本地系统，1：imp
     *
     * @param regSource 注册来源，null或0：本地系统，1：imp
     */
    public void setRegSource(Integer regSource) {
        this.regSource = regSource;
    }

    /**
     * 获取上次登陆日期
     *
     * @return d_last_login - 上次登陆日期
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * 设置上次登陆日期
     *
     * @param lastLogin 上次登陆日期
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * 获取上次登陆ip
     *
     * @return c_last_ip - 上次登陆ip
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * 设置上次登陆ip
     *
     * @param lastIp 上次登陆ip
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    /**
     * 获取创建人用户名
     *
     * @return c_creator - 创建人用户名
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人用户名
     *
     * @param creator 创建人用户名
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return d_update
     */
    public Date getUpdate() {
        return update;
    }

    /**
     * @param update
     */
    public void setUpdate(Date update) {
        this.update = update;
    }

    /**
     * 获取创建日期
     *
     * @return d_create - 创建日期
     */
    public Date getCreate() {
        return create;
    }

    /**
     * 设置创建日期
     *
     * @param create 创建日期
     */
    public void setCreate(Date create) {
        this.create = create;
    }

    /**
     * 获取扩展字段
     *
     * @return c_extra - 扩展字段
     */
    public String getExtra() {
        return extra;
    }

    /**
     * 设置扩展字段
     *
     * @param extra 扩展字段
     */
    public void setExtra(String extra) {
        this.extra = extra;
    }

    /**
     * 获取用户geo hash
     *
     * @return c_geo_hash - 用户geo hash
     */
    public String getGeoHash() {
        return geoHash;
    }

    /**
     * 设置用户geo hash
     *
     * @param geoHash 用户geo hash
     */
    public void setGeoHash(String geoHash) {
        this.geoHash = geoHash;
    }
}