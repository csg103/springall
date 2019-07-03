package com.csg.cn.db.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_partymember_score")
public class PartyMemberScore {
    @Column(name = "partMemberscoreId")
    private String partmemberscoreid;

    @Column(name = "partymemberId")
    private String partymemberid;

    private String score;

    private Date year;

    /**
     * @return partMemberscoreId
     */
    public String getPartmemberscoreid() {
        return partmemberscoreid;
    }

    /**
     * @param partmemberscoreid
     */
    public void setPartmemberscoreid(String partmemberscoreid) {
        this.partmemberscoreid = partmemberscoreid;
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
     * @return score
     */
    public String getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(String score) {
        this.score = score;
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
}