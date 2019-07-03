package com.csg.cn.db.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_partymember_score_detil")
public class PartyMemberScoreDetil {
    @Id
    @Column(name = "scoreDetilId")
    private String scoredetilid;

    @Column(name = "partymemberId")
    private String partymemberid;

    @Column(name = "pipId")
    private String pipid;

    private Date year;

    private String operator;

    @Column(name = "operatorTime")
    private Date operatortime;

    private String remake;

    private String remake1;

    private String remake2;

    /**
     * @return scoreDetilId
     */
    public String getScoredetilid() {
        return scoredetilid;
    }

    /**
     * @param scoredetilid
     */
    public void setScoredetilid(String scoredetilid) {
        this.scoredetilid = scoredetilid;
    }

    /**
     * @return partymemberId
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
     * @return pipId
     */
    public String getPipid() {
        return pipid;
    }

    /**
     * @param pipid
     */
    public void setPipid(String pipid) {
        this.pipid = pipid;
    }

    /**
     * @return year
     */
    public Date getYear() {
        return year;
    }

    /**
     * @param year
     */
    public void setYear(Date year) {
        this.year = year;
    }

    /**
     * @return operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return operatorTime
     */
    public Date getOperatortime() {
        return operatortime;
    }

    /**
     * @param operatortime
     */
    public void setOperatortime(Date operatortime) {
        this.operatortime = operatortime;
    }

    /**
     * @return remake
     */
    public String getRemake() {
        return remake;
    }

    /**
     * @param remake
     */
    public void setRemake(String remake) {
        this.remake = remake;
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