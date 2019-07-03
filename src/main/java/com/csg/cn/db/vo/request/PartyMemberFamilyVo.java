package com.csg.cn.db.vo.request;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Classname PartyMemberFamilyVo
 * @Description TODO
 * @Date 2019/5/28 11:13
 * @Created by ${suge.chen}
 */
public class PartyMemberFamilyVo implements Serializable {
    private String familymemberid;

    private String partymemberid;

    private String relation;

    private String name;

    private String zhengzhimianmao;

    private String work;

    private String tel;

    private String remake1;

    private String remake2;

    public String getFamilymemberid() {
        return familymemberid;
    }

    public void setFamilymemberid(String familymemberid) {
        this.familymemberid = familymemberid;
    }

    public String getPartymemberid() {
        return partymemberid;
    }

    public void setPartymemberid(String partymemberid) {
        this.partymemberid = partymemberid;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZhengzhimianmao() {
        return zhengzhimianmao;
    }

    public void setZhengzhimianmao(String zhengzhimianmao) {
        this.zhengzhimianmao = zhengzhimianmao;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRemake1() {
        return remake1;
    }

    public void setRemake1(String remake1) {
        this.remake1 = remake1;
    }

    public String getRemake2() {
        return remake2;
    }

    public void setRemake2(String remake2) {
        this.remake2 = remake2;
    }
}
