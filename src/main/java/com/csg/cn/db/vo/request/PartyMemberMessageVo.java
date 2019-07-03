package com.csg.cn.db.vo.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PartyMemberMessageVo  implements Serializable{

    private String parytmemberid;
            private String id ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String departmentid;

    private String name;

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    private String loginname;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String role;
    private String sex;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    private String ethnicgroup;

    private String birthplace;

    private String marry;

    private String education;

    private String school;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date joinpartytime;
@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date realjoinpartytime;

    private String partymemberjob;
@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date worktime;

    private String workjob;

    private String hujiaddress;

    private String cardnum;

    private String address;

    private String tel;

    private String remarks;

    public String getParytmemberid() {
        return parytmemberid;
    }

    public void setParytmemberid(String parytmemberid) {
        this.parytmemberid = parytmemberid;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEthnicgroup() {
        return ethnicgroup;
    }

    public void setEthnicgroup(String ethnicgroup) {
        this.ethnicgroup = ethnicgroup;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getMarry() {
        return marry;
    }

    public void setMarry(String marry) {
        this.marry = marry;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getJoinpartytime() {
        return joinpartytime;
    }

    public void setJoinpartytime(Date joinpartytime) {
        this.joinpartytime = joinpartytime;
    }

    public Date getRealjoinpartytime() {
        return realjoinpartytime;
    }

    public void setRealjoinpartytime(Date realjoinpartytime) {
        this.realjoinpartytime = realjoinpartytime;
    }

    public String getPartymemberjob() {
        return partymemberjob;
    }

    public void setPartymemberjob(String partymemberjob) {
        this.partymemberjob = partymemberjob;
    }

    public Date getWorktime() {
        return worktime;
    }

    public void setWorktime(Date worktime) {
        this.worktime = worktime;
    }

    public String getWorkjob() {
        return workjob;
    }

    public void setWorkjob(String workjob) {
        this.workjob = workjob;
    }

    public String getHujiaddress() {
        return hujiaddress;
    }

    public void setHujiaddress(String hujiaddress) {
        this.hujiaddress = hujiaddress;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getRemake1() {
        return remake1;
    }

    public void setRemake1(String remake1) {
        this.remake1 = remake1;
    }

    public String getRemale2() {
        return remale2;
    }

    public void setRemale2(String remale2) {
        this.remale2 = remale2;
    }

    public String getPartymembergroup() {
        return partymembergroup;
    }

    public void setPartymembergroup(String partymembergroup) {
        this.partymembergroup = partymembergroup;
    }

    public String getIsleader() {
        return isleader;
    }

    public void setIsleader(String isleader) {
        this.isleader = isleader;
    }

    public List<PartyMemberFamilyVo> getPartyMemberFamilyVoList() {
        return partyMemberFamilyVoList;
    }

    public void setPartyMemberFamilyVoList(List<PartyMemberFamilyVo> partyMemberFamilyVoList) {
        this.partyMemberFamilyVoList = partyMemberFamilyVoList;
    }

    private String picurl;

    private String remake1;

    private String remale2;

    private String partymembergroup;

    private String isleader;

    private List<PartyMemberFamilyVo> partyMemberFamilyVoList;
}