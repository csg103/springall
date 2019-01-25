package com.csg.cn.db.entity;

import javax.persistence.*;

@Table(name = "t_sys_company")
public class SysCompany {
    @Id
    private String id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_phone")
    private String companyPhone;

    @Column(name = "company_description")
    private String companyDescription;

    @Column(name = "company_status")
    private String companyStatus;

    @Column(name = "company_parent_id")
    private String companyParentId;

    @Transient
    private String lastCompanyName;

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
     * @return company_name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return company_phone
     */
    public String getCompanyPhone() {
        return companyPhone;
    }

    /**
     * @param companyPhone
     */
    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    /**
     * @return company_description
     */
    public String getCompanyDescription() {
        return companyDescription;
    }

    /**
     * @param companyDescription
     */
    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    /**
     * @return company_status
     */
    public String getCompanyStatus() {
        return companyStatus;
    }

    /**
     * @param companyStatus
     */
    public void setCompanyStatus(String companyStatus) {
        this.companyStatus = companyStatus;
    }

    /**
     * @return company_parent_id
     */
    public String getCompanyParentId() {
        return companyParentId;
    }

    /**
     * @param companyParentId
     */
    public void setCompanyParentId(String companyParentId) {
        this.companyParentId = companyParentId;
    }

    public String getLastCompanyName() {
        return lastCompanyName;
    }

    public void setLastCompanyName(String lastCompanyName) {
        this.lastCompanyName = lastCompanyName;
    }
}