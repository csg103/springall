package com.csg.cn.db.entity;

import javax.persistence.*;

@Table(name = "t_partymember_score_pip")
public class PartyMemberScorePip {
    @Id
    @Column(name = "scoreId")
    private String scoreid;

    @Column(name = "isAdd")
    private String isadd;

    private String name;

    private String pip;

    private String score;

    private String remake1;

    private String remake2;

    /**
     * @return scoreId
     */
    public String getScoreid() {
        return scoreid;
    }

    /**
     * @param scoreid
     */
    public void setScoreid(String scoreid) {
        this.scoreid = scoreid;
    }

    /**
     * @return isAdd
     */
    public String getIsadd() {
        return isadd;
    }

    /**
     * @param isadd
     */
    public void setIsadd(String isadd) {
        this.isadd = isadd;
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
     * @return pip
     */
    public String getPip() {
        return pip;
    }

    /**
     * @param pip
     */
    public void setPip(String pip) {
        this.pip = pip;
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