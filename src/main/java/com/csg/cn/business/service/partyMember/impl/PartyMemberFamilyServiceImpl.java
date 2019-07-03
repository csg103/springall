package com.csg.cn.business.service.partyMember.impl;

import com.csg.cn.business.service.partyMember.PartyMemberFamilyService;
import com.csg.cn.business.service.partyMember.PartyMemberMessageService;
import com.csg.cn.db.dao.DepartmentMapper;
import com.csg.cn.db.dao.PartyMemberFamilyMapper;
import com.csg.cn.db.dao.PartyMemberMessageMapper;
import com.csg.cn.db.entity.Department;
import com.csg.cn.db.entity.PartyMemberFamily;
import com.csg.cn.db.entity.PartyMemberMessage;
import com.csg.cn.db.vo.SysUserSimple;
import com.csg.cn.db.vo.request.PartyMemberMessageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname PartyMemberMessageServiceImpl
 * @Description TODO
 * @Date 2019/5/27 11:57
 * @Created by ${suge.chen}
 */
@Service
public class PartyMemberFamilyServiceImpl implements PartyMemberFamilyService {

    @Autowired
    PartyMemberFamilyMapper partyMemberFamilyMapper;

    @Override
    public List<PartyMemberFamily> getFamilyMes(String id) {
        return partyMemberFamilyMapper.getFamilyMes(id);
    }
}
