package com.csg.cn.db.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_party_record")
public class PartyRecord {
    @Id
    @Column(name = "recordId")
    private String recordid;

    @Column(name = "recordName")
    private String recordname;

    @Column(name = "partyMemberId")
    private String partymemberid;

    @Column(name = "partyId")
    private String partyid;

    @Column(name = "picUrl")
    private String picurl;
    @Transient
    private String AllUrl;


    @Transient
    private String partyName;

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getAllUrl() {
        return AllUrl;
    }

    public void setAllUrl(String allUrl) {
        AllUrl = allUrl;
    }

    @Column(name = "PicIp")
    private String picip;

    @Column(name = "uploadTime")
    private Date uploadtime;

    private String remake1;

    private String remake2;

    /**
     * @return recordId
     */
    public String getRecordid() {
        return recordid;
    }

    /**
     * @param recordid
     */
    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    /**
     * @return recordName
     */
    public String getRecordname() {
        return recordname;
    }

    /**
     * @param recordname
     */
    public void setRecordname(String recordname) {
        this.recordname = recordname;
    }

    /**
     * @return partyMemberId
     */
    public String getPartymemberid() {
        return partymemberid;
    }

    /**
     * @param partymemberid
     */
    public void setPartymemberid(String partymemberid) {
        this.partymemberid = partymemberid;
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
     * @return picUrl
     */
    public String getPicurl() {
        return picurl;
    }

    /**
     * @param picurl
     */
    public void setPicurl(String picurl) {

        this.picurl = picurl;

    }

    /**
     * @return PicIp
     */
    public String getPicip() {
        return picip;
    }

    /**
     * @param picip
     */
    public void setPicip(String picip) {
        this.picip = picip;
    }

    /**
     * @return uploadTime
     */
    public Date getUploadtime() {
        return uploadtime;
    }

    /**
     * @param uploadtime
     */
    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
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