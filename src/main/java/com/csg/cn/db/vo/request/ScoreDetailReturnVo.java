package com.csg.cn.db.vo.request;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname ScoreDetailReturnVo
 * @Description TODO
 * @Date 2019/6/3 11:26
 * @Created by ${suge.chen}
 */
public class ScoreDetailReturnVo {
    private String  name;
    private String  departmentName;
    private String  pipName;
    private String  pip;
    private Date year;
    private String yearString;
    private String  operator;
    private String  num;
    private String  nowScore;
    private String  scorePip;
    private String  operatortime;
    private String  remake1;
    private String  scoreDetilId;

    public String getScoreDetilId() {
        return scoreDetilId;
    }

    public void setScoreDetilId(String scoreDetilId) {
        this.scoreDetilId = scoreDetilId;
    }

    public String getOperatortime() {
        return operatortime;
    }

    public void setOperatortime(String operatortime) {
        this.operatortime = operatortime;
    }

    public String getRemake1() {
        return remake1;
    }

    public void setRemake1(String remake1) {
        this.remake1 = remake1;
    }

    public String getYearString() {
        return yearString;
    }

    public void setYearString(String yearString) {
        this.yearString = yearString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPipName() {
        return pipName;
    }

    public void setPipName(String pipName) {
        this.pipName = pipName;
    }

    public String getPip() {
        return pip;
    }

    public void setPip(String pip) {
        this.pip = pip;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

        this.yearString = sdf.format(year);
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNowScore() {
        return nowScore;
    }

    public void setNowScore(String nowScore) {
        this.nowScore = nowScore;
    }

    public String getScorePip() {
        return scorePip;
    }

    public void setScorePip(String scorePip) {
        this.scorePip = scorePip;
    }
}

