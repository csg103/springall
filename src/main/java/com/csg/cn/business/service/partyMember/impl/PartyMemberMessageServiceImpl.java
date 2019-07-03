package com.csg.cn.business.service.partyMember.impl;

import com.baidu.UUIDUtils;
import com.csg.cn.business.service.partyMember.PartyMemberMessageService;
import com.csg.cn.db.dao.CommonMapper;
import com.csg.cn.db.dao.DepartmentMapper;
import com.csg.cn.db.dao.PartyMemberFamilyMapper;
import com.csg.cn.db.dao.PartyMemberMessageMapper;
import com.csg.cn.db.entity.*;
import com.csg.cn.db.vo.SysUserSimple;
import com.csg.cn.db.vo.request.PartyMemberFamilyVo;
import com.csg.cn.db.vo.request.PartyMemberMessageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.util.StringUtil;

import java.util.*;

/**
 * @Classname PartyMemberMessageServiceImpl
 * @Description TODO
 * @Date 2019/5/27 11:57
 * @Created by ${suge.chen}
 */
@Service
public class PartyMemberMessageServiceImpl implements PartyMemberMessageService {

    @Autowired
    private PartyMemberMessageMapper partyMemberMessageMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private PartyMemberFamilyMapper partyMemberFamilyMapper;
    @Autowired
    private CommonMapper commonMapper;

    public List<PartyMemberMessage> data(String userName) {
        List<PartyMemberMessage> list = partyMemberMessageMapper.selectList(userName);


        return list;

    }

    @Override
    public List<PartyMemberMessage> selectAll(String userName, String isLeader, String group) {
        List<PartyMemberMessage> list = null;
        //不是管理员
        if ("0".equals(isLeader)) {
            list = partyMemberMessageMapper.selectList(userName);
            //小组管理员
        } else if ("1".equals(isLeader)) {

            list = partyMemberMessageMapper.selectListByGroup(group);

        } else if ("9".equals(isLeader) || "2".equals(isLeader)) {
            list = partyMemberMessageMapper.selectAllByAll();
        }


        return list;
    }

    @Override
    public List<Department> getAllDepartment() {

        return departmentMapper.selectAll();
    }

    @Override
    public PartyMemberMessageVo getPartyMemberMessage(SysUserSimple sysUserSimple) {
        PartyMemberMessageVo partyMemberMessageVo = new PartyMemberMessageVo();
        PartyMemberMessage partyMemberMessage = partyMemberMessageMapper.selectMesByUserId(sysUserSimple.getId()).get(0);
        BeanUtils.copyProperties(partyMemberMessage, partyMemberMessageVo);
        partyMemberMessageVo.setRole(sysUserSimple.getRole());
        partyMemberMessageVo.setLoginname(sysUserSimple.getName());
        return partyMemberMessageVo;
    }

    @Override
    public PartyMemberMessage selectPartyMemberByID(String id) {

        return partyMemberMessageMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Boolean saveMes(PartyMemberMessageVo partyMemberMessageVo) {
        PartyMemberMessage partyMemberMessage = new PartyMemberMessage();
        BeanUtils.copyProperties(partyMemberMessageVo, partyMemberMessage);
        partyMemberMessageMapper.updateByPrimaryKeySelective(partyMemberMessage);
        List<PartyMemberFamilyVo> list = partyMemberMessageVo.getPartyMemberFamilyVoList();
        for (int i = 0; i < list.size(); i++) {
            if (StringUtil.isEmpty(list.get(i).getName())) {
                list.remove(i);
            }

        }

//        PartyMemberFamilyExample partyMemberFamilyExample = new PartyMemberFamilyExample();
//        partyMemberFamilyExample.createCriteria().andPartymemberidEqualTo(partyMemberMessageVo.getParytmemberid());
//
//        if (partyMemberFamilyMapper.selectByExample(partyMemberFamilyExample).size() != 0)
        partyMemberFamilyMapper.deleteById(partyMemberMessageVo.getParytmemberid());

        for (PartyMemberFamilyVo partyMemberFamilyVo : list) {
            PartyMemberFamily partyMemberFamily = new PartyMemberFamily();
            BeanUtils.copyProperties(partyMemberFamilyVo, partyMemberFamily);
            partyMemberFamily.setFamilymemberid(UUIDUtils.generateUUID());
            partyMemberFamily.setPartymemberid(partyMemberMessageVo.getParytmemberid());
            partyMemberFamilyMapper.insert(partyMemberFamily);
        }

        return true;
    }

    @Override
    public List<List<PartyMemberMessage>> getAllPartyMemberMessage() {
        List<PartyMemberMessage> partyMemberMessageList = partyMemberMessageMapper.selectAllAndGroupName();
        Set<String> set = new HashSet();
        List<String> listGroup = new ArrayList();
        for (PartyMemberMessage partyMemberMessage : partyMemberMessageList) {
            set.add(partyMemberMessage.getPartymembergroup());
        }
        for (String str : set) {
            listGroup.add(str);
        }
        Map map = new HashMap<>();
        List<List<PartyMemberMessage>> PartyMemberMessageList = new ArrayList();
        for (String str : listGroup) {
            if (!StringUtils.equals(str, "18")) {
                List<PartyMemberMessage> list = new ArrayList();
                for (PartyMemberMessage partyMemberMessage : partyMemberMessageList) {
                    if (StringUtils.equals(partyMemberMessage.getPartymembergroup(), str)) {


                        list.add(partyMemberMessage);

                    }

                }
                PartyMemberMessageList.add(list);
            }
        }

        return PartyMemberMessageList;
    }

    @Override
    public List<Common> getGroup(String type) {

        return commonMapper.selectType(type);
    }


}
