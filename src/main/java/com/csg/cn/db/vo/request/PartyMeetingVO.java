package com.csg.cn.db.vo.request;

import com.csg.cn.db.entity.PartyMemberMessage;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Classname PartyMeetingVO
 * @Description TODO
 * @Date 2019/6/13 8:43
 * @Created by ${suge.chen}
 */
public class PartyMeetingVO {


    private String partyname;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date partytime;
    private String partyadress;
    private String type;
    private String typeName;
    private String partyid;
    private String groupid;

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getPartyid() {
        return partyid;
    }

    public void setPartyid(String partyid) {
        this.partyid = partyid;
    }

    private String[] mes ;

    public String[] getMes() {
        return mes;
    }

    public void setMes(String[] mes) {
        this.mes = mes;
    }

    private String data1;

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
//    public List<Mes>[] getMes() {
//        return mes;
//    }
//
//    public void setMes(List<Mes>[] mes) {
//        this.mes = mes;
//    }

    public String getPartyname() {
        return partyname;
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }

    public Date getPartytime() {
        return partytime;
    }

    public void setPartytime(Date partytime) {
        this.partytime = partytime;
    }

    public String getPartyadress() {
        return partyadress;
    }

    public void setPartyadress(String partyadress) {
        this.partyadress = partyadress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
