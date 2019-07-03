package com.csg.cn.db.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_party")
public class Party {
    @Id
    @Column(name = "partyId")
    private String partyid;

    @Column(name = "partyName")
    private String partyname;

    @Column(name = "partyTime")
    private Date partytime;
    @Transient
    private String partytimeStr;

    public String getPartytimeStr() {
        return partytimeStr;
    }

    public void setPartytimeStr(String partytimeStr) {
        this.partytimeStr = partytimeStr;
    }

    @Column(name = "partyAdress")
    private String partyadress;

    @Column(name = "partyPlayers")
    private String partyplayers;

    private String oper;

    @Column(name = "operTime")
    private Date opertime;

    private String type;
    @Transient
    private String typeName;

    private String remake1;

    private String remake2;

    @Column(name = "partyDescribe")
    private String partydescribe;


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * @return partyId
     */
    public String getPartyid() {
        return partyid;
    }

    /**
     * @param partyid
     */
    public void setPartyid(String partyid) {
        this.partyid = partyid;
    }

    /**
     * @return partyName
     */
    public String getPartyname() {
        return partyname;
    }

    /**
     * @param partyname
     */
    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }

    /**
     * @return partyTime
     */
    public Date getPartytime() {
        return partytime;
    }

    /**
     * @param partytime
     */
    public void setPartytime(Date partytime) {
        this.partytime = partytime;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.partytimeStr=sdf.format(partytime);
    }

    /**
     * @return partyAdress
     */
    public String getPartyadress() {
        return partyadress;
    }

    /**
     * @param partyadress
     */
    public void setPartyadress(String partyadress) {
        this.partyadress = partyadress;
    }

    /**
     * @return partyPlayers
     */
    public String getPartyplayers() {
        return partyplayers;
    }

    /**
     * @param partyplayers
     */
    public void setPartyplayers(String partyplayers) {
        this.partyplayers = partyplayers;
    }

    /**
     * @return oper
     */
    public String getOper() {
        return oper;
    }

    /**
     * @param oper
     */
    public void setOper(String oper) {
        this.oper = oper;
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

    /**
     * @return partyDescribe
     */
    public String getPartydescribe() {
        return partydescribe;
    }

    /**
     * @param partydescribe
     */
    public void setPartydescribe(String partydescribe) {
        this.partydescribe = partydescribe;
    }
}