package com.csg.cn.business.service.partyMember;

import com.csg.cn.db.entity.Common;
import com.csg.cn.db.entity.Department;
import com.csg.cn.db.entity.PartyMemberMessage;
import com.csg.cn.db.vo.SysUserSimple;
import com.csg.cn.db.vo.request.PartyMemberMessageVo;

import java.util.List;
import java.util.Map;

/**
 * @Classname PartyMemberMessageService
 * @Description TODO
 * @Date 2019/5/27 11:57
 * @Created by ${suge.chen}
 */
public interface PartyMemberMessageService {


    List<PartyMemberMessage> data(String userName);

    List<PartyMemberMessage> selectAll(String userName, String isLeader, String group);


    List<Department> getAllDepartment();

    PartyMemberMessageVo getPartyMemberMessage(SysUserSimple sysUserSimple);


    PartyMemberMessage  selectPartyMemberByID(String id);
      Boolean saveMes(PartyMemberMessageVo partyMemberMessageVo);

    List<List<PartyMemberMessage>> getAllPartyMemberMessage();


    List<Common> getGroup(String type);

}
