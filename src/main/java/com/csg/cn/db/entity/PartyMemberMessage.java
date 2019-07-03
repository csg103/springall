package com.csg.cn.db.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_partymember_message")
public class PartyMemberMessage {
    @Id
    @Column(name = "parytMemberId")
    private String parytmemberid;

    @Column(name = "departmentId")
    private String departmentid;


    private String name;

    private String sex;

    private Date birthday;

    @Column(name = "ethnicGroup")
    private String ethnicgroup;

    @Column(name = "birthPlace")
    private String birthplace;

    @Column(name = "Marry")
    private String marry;

    private String education;

    private String school;

    @Column(name = "joinPartyTime")
    private Date joinpartytime;

    @Column(name = "realJoinPartyTime")
    private Date realjoinpartytime;

    @Column(name = "partyMemberJob")
    private String partymemberjob;

    @Column(name = "workTime")
    private Date worktime;

    @Column(name = "workJob")
    private String workjob;

    @Column(name = "hujiAddress")
    private String hujiaddress;

    @Column(name = "cardNum")
    private String cardnum;

    private String address;

    private String tel;

    private String remarks;

    @Column(name = "picUrl")
    private String picurl;
    //系统用户ID
    private String remake1;

    private String remale2;

    @Column(name = "partyMemberGroup")
    private String partymembergroup;
    @Transient
    private String partymembergroupname;
    @Transient
    private String departmentname;

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getPartymembergroupname() {
        return partymembergroupname;
    }

    public void setPartymembergroupname(String partymembergroupname) {
        this.partymembergroupname = partymembergroupname;
    }

    @Column(name = "isLeader")
    private String isleader;

    /**
     * @return parytMemberId
     */
    public String getParytmemberid() {
        return parytmemberid;
    }

    /**
     * @param parytmemberid
     */
    public void setParytmemberid(String parytmemberid) {
        this.parytmemberid = parytmemberid;
    }

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return ethnicGroup
     */
    public String getEthnicgroup() {
        return ethnicgroup;
    }

    /**
     * @param ethnicgroup
     */
    public void setEthnicgroup(String ethnicgroup) {
        this.ethnicgroup = ethnicgroup;
    }

    /**
     * @return birthPlace
     */
    public String getBirthplace() {
        return birthplace;
    }

    /**
     * @param birthplace
     */
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    /**
     * @return Marry
     */
    public String getMarry() {
        return marry;
    }

    /**
     * @param marry
     */
    public void setMarry(String marry) {
        this.marry = marry;
    }

    /**
     * @return education
     */
    public String getEducation() {
        return education;
    }

    /**
     * @param education
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * @return school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return joinPartyTime
     */
    public Date getJoinpartytime() {
        return joinpartytime;
    }

    /**
     * @param joinpartytime
     */
    public void setJoinpartytime(Date joinpartytime) {
        this.joinpartytime = joinpartytime;
    }

    /**
     * @return realJoinPartyTime
     */
    public Date getRealjoinpartytime() {
        return realjoinpartytime;
    }

    /**
     * @param realjoinpartytime
     */
    public void setRealjoinpartytime(Date realjoinpartytime) {
        this.realjoinpartytime = realjoinpartytime;
    }

    /**
     * @return partyMemberJob
     */
    public String getPartymemberjob() {
        return partymemberjob;
    }

    /**
     * @param partymemberjob
     */
    public void setPartymemberjob(String partymemberjob) {
        this.partymemberjob = partymemberjob;
    }

    /**
     * @return workTime
     */
    public Date getWorktime() {
        return worktime;
    }

    /**
     * @param worktime
     */
    public void setWorktime(Date worktime) {
        this.worktime = worktime;
    }

    /**
     * @return workJob
     */
    public String getWorkjob() {
        return workjob;
    }

    /**
     * @param workjob
     */
    public void setWorkjob(String workjob) {
        this.workjob = workjob;
    }

    /**
     * @return hujiAddress
     */
    public String getHujiaddress() {
        return hujiaddress;
    }

    /**
     * @param hujiaddress
     */
    public void setHujiaddress(String hujiaddress) {
        this.hujiaddress = hujiaddress;
    }

    /**
     * @return cardNum
     */
    public String getCardnum() {
        return cardnum;
    }

    /**
     * @param cardnum
     */
    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
     * @return remale2
     */
    public String getRemale2() {
        return remale2;
    }

    /**
     * @param remale2
     */
    public void setRemale2(String remale2) {
        this.remale2 = remale2;
    }

    /**
     * @return partyMemberGroup
     */
    public String getPartymembergroup() {
        return partymembergroup;
    }

    /**
     * @param partymembergroup
     */
    public void setPartymembergroup(String partymembergroup) {
        this.partymembergroup = partymembergroup;
    }

    /**
     * @return isLeader
     */
    public String getIsleader() {
        return isleader;
    }

    /**
     * @param isleader
     */
    public void setIsleader(String isleader) {
        this.isleader = isleader;
    }
}