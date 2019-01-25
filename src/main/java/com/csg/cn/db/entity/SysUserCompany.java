package com.csg.cn.db.entity;

import javax.persistence.*;

@Table(name = "t_sys_user_company")
public class SysUserCompany {
    @Id
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "company_id")
    private String companyId;

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
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return company_id
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}