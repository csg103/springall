package com.csg.cn.business.service.partyMember;

import com.csg.cn.db.entity.Department;
import com.csg.cn.db.entity.PartyMemberFamily;
import com.csg.cn.db.entity.PartyMemberMessage;
import com.csg.cn.db.vo.SysUserSimple;
import com.csg.cn.db.vo.request.PartyMemberMessageVo;

import java.util.List;

/**
 * @Classname PartyMemberFamilyService
 * @Description TODO
 * @Date 2019/5/27 11:57
 * @Created by ${suge.chen}
 */
public interface PartyMemberFamilyService {
    List<PartyMemberFamily> getFamilyMes(String id );


}
