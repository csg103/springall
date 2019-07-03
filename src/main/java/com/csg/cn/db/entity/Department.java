package com.csg.cn.db.entity;

import javax.persistence.*;

@Table(name = "t_department")
public class Department {
    @Id
    @Column(name = "departmentId")
    private String departmentid;

    @Column(name = "departmentName")
    private String departmentname;

    /**
     * @return departmentId
     */
    public String getDepartmentid() {
        return departmentid;
    }

    /**
     * @param departmentid
     */
    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    /**
     * @return departmentName
     */
    public String getDepartmentname() {
        return departmentname;
    }

    /**
     * @param departmentname
     */
    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }
}