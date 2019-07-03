package com.csg.cn.db.entity;

import javax.persistence.*;

@Table(name = "t_common")
public class Common {
    @Id
    private String id;

    private String type;

    @Column(name = "typeName")
    private String typename;

    @Column(name = "valueId")
    private String valueid;

    @Column(name = "valueName")
    private String valuename;

    private String isChecked;

    public String getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(String isChecked) {
        this.isChecked = isChecked;
    }

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
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return typeName
     */
    public String getTypename() {
        return typename;
    }

    /**
     * @param typename
     */
    public void setTypename(String typename) {
        this.typename = typename;
    }

    /**
     * @return valueId
     */
    public String getValueid() {
        return valueid;
    }

    /**
     * @param valueid
     */
    public void setValueid(String valueid) {
        this.valueid = valueid;
    }

    /**
     * @return valueName
     */
    public String getValuename() {
        return valuename;
    }

    /**
     * @param valuename
     */
    public void setValuename(String valuename) {
        this.valuename = valuename;
    }
}