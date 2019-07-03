package com.csg.cn.db.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_appendix")
public class Appendix {
    @Id
    @Column(name = "appendixId")
    private String appendixid;

    @Column(name = "appendName")
    private String appendname;

    @Column(name = "appendType")
    private String appendtype;
@Transient
    private String appendtypename;

    @Column(name = "appendixAddress")
    private String appendixaddress;

    @Column(name = "operName")
    private String opername;

    @Column(name = "operTime")
    private Date opertime;

    private String remake1;

    private String remake2;


    public String getAppendtypename() {
        return appendtypename;
    }

    public void setAppendtypename(String appendtypename) {
        this.appendtypename = appendtypename;
    }

    /**
     * @return appendixId
     */
    public String getAppendixid() {
        return appendixid;
    }

    /**
     * @param appendixid
     */
    public void setAppendixid(String appendixid) {
        this.appendixid = appendixid;
    }

    /**
     * @return appendName
     */
    public String getAppendname() {
        return appendname;
    }

    /**
     * @param appendname
     */
    public void setAppendname(String appendname) {
        this.appendname = appendname;
    }

    /**
     * @return appendType
     */
    public String getAppendtype() {
        return appendtype;
    }

    /**
     * @param appendtype
     */
    public void setAppendtype(String appendtype) {
        this.appendtype = appendtype;
    }

    /**
     * @return appendixAddress
     */
    public String getAppendixaddress() {
        return appendixaddress;
    }

    /**
     * @param appendixaddress
     */
    public void setAppendixaddress(String appendixaddress) {
        this.appendixaddress = appendixaddress;
    }

    /**
     * @return operName
     */
    public String getOpername() {
        return opername;
    }

    /**
     * @param opername
     */
    public void setOpername(String opername) {
        this.opername = opername;
    }

    /**
     * @return operTime
     */
    public Date getOpertime() {
        return opertime;
    }

    /**
     * @param opertime
     */
    public void setOpertime(Date opertime) {
        this.opertime = opertime;
    }

    /**
     * @return remake1
     */
    public String getRemake1() {
        return remake1;
    }

    /**
     * @param remake1
     */
    public void setRemake1(String remake1) {
        this.remake1 = remake1;
    }

    /**
     * @return remake2
     */
    public String getRemake2() {
        return remake2;
    }

    /**
     * @param remake2
     */
    public void setRemake2(String remake2) {
        this.remake2 = remake2;
    }
}