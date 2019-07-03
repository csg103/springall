package com.csg.cn.db.vo.request;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname ScoreReturnVo
 * @Description TODO
 * @Date 2019/5/30 15:51
 * @Created by ${suge.chen}
 */
public class ScoreReturnVo {
    private String partMemberscoreId;
    private String score;
    private String parytmemberid;
    private String departmentName;
    private String remale2;
    private String  yearString;
    private String name;

    private String isLeader;

    private String partyMemberGroup;

    private Date year;

    public String getYearString() {
        return yearString;
    }

    public void setYearString(String yearString) {
        this.yearString = yearString;
    }



    public String getPartMemberscoreId() {
        return partMemberscoreId;
    }

    public void setPartMemberscoreId(String partMemberscoreId) {
        this.partMemberscoreId = partMemberscoreId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(String isLeader) {
        this.isLeader = isLeader;
    }

    public String getPartyMemberGroup() {
        return partyMemberGroup;
    }

    public void setPartyMemberGroup(String partyMemberGroup) {
        this.partyMemberGroup = partyMemberGroup;
    }

    public String getYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

        return sdf.format(year);
    }

    public String getParytmemberid() {
        return parytmemberid;
    }

    public void setParytmemberid(String parytmemberid) {
        this.parytmemberid = parytmemberid;
    }

    public void setYear(Date year) {
        this.year = year;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

        this.yearString = sdf.format(year);
    }

    public String getRemale2() {
        return remale2;
    }

    public void setRemale2(String remale2) {
        this.remale2 = remale2;
    }
}
