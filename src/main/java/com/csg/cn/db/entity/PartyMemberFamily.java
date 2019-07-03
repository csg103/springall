package com.csg.cn.db.entity;

import javax.persistence.*;

@Table(name = "t_partymember_family")
public class PartyMemberFamily {
    @Id
    @Column(name = "familyMemberId")
    private String familymemberid;

    @Column(name = "partyMemberId")
    private String partymemberid;

    private String relation;

    private String name;

    @Column(name = "zhengZhiMianMao")
    private String zhengzhimianmao;

    private String work;

    private String tel;

    private String remake1;

    private String remake2;

    /**
     * @return familyMemberId
     */
    public String getFamilymemberid() {
        return familymemberid;
    }

    /**
     * @param familymemberid
     */
    public void setFamilymemberid(String familymemberid) {
        this.familymemberid = familymemberid;
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
     * @return relation
     */
    public String getRelation() {
        return relation;
    }

    /**
     * @param relation
     */
    public void setRelation(String relation) {
        this.relation = relation;
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
     * @return zhengZhiMianMao
     */
    public String getZhengzhimianmao() {
        return zhengzhimianmao;
    }

    /**
     * @param zhengzhimianmao
     */
    public void setZhengzhimianmao(String zhengzhimianmao) {
        this.zhengzhimianmao = zhengzhimianmao;
    }

    /**
     * @return work
     */
    public String getWork() {
        return work;
    }

    /**
     * @param work
     */
    public void setWork(String work) {
        this.work = work;
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