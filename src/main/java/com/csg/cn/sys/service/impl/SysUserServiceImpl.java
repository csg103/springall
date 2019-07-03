package com.csg.cn.sys.service.impl;

import com.baidu.MD5Utils;
import com.baidu.UUIDUtils;
import com.csg.cn.db.dao.PartyMemberMessageMapper;
import com.csg.cn.db.dao.SysRoleUserMapper;
import com.csg.cn.db.dao.SysUserCompanyMapper;
import com.csg.cn.db.dao.SysUserMapper;
import com.csg.cn.db.entity.*;
import com.csg.cn.db.vo.SysUpdatePassword;
import com.csg.cn.db.vo.SysUserSimple;
import com.csg.cn.db.vo.request.PartyMemberMessageVo;
import com.csg.cn.sys.constant.UserConstant;
import com.csg.cn.sys.service.SysUserService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yangzy on 2018/10/31.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;
    @Autowired
    private SysUserCompanyMapper sysUserCompanyMapper;

    @Autowired
    private PartyMemberMessageMapper partyMemberMessageMapper;

    @Override
    public SysUser selectOneByUsername(String username) {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUsernameEqualTo(username)
                .andUserStatusEqualTo(UserConstant.USER_STATUS_NORMAL);
        List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
        if(CollectionUtils.isNotEmpty(list)){
            return list.get(0);
        }
        return null;
    }

    @Override
    public SysUser selectOne(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysUserSimple selectUserInfo(String id) {
        return sysUserMapper.selectUserInfo(id);
    }

    @Override
    public List<SysUserSimple> selectList(String searchName) {
        return sysUserMapper.selectList(searchName);
    }

    @Override
    public List<SysUser> selectList() {
        return sysUserMapper.selectAll();
    }

    @Override
    @Transactional
    public boolean saveAdd(PartyMemberMessageVo sysUserSimple, String[] checked) {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUsernameEqualTo(sysUserSimple.getName());
        if(sysUserMapper.countByExample(sysUserExample) > 0){
            return false;
        }

        String userId = UUIDUtils.generateUUID();
        String password = "123456";

        SysUser sysUser = new SysUser();
        sysUser.setId(userId);
        sysUser.setUsername(sysUserSimple.getName());
        sysUser.setName(sysUserSimple.getLoginname());
        sysUser.setPassword(MD5Utils.encode(password));
        sysUser.setPhone(sysUserSimple.getTel());
        sysUser.setSalt(sysUserSimple.getName());
        sysUser.setUserStatus(UserConstant.USER_STATUS_NORMAL);
        sysUserMapper.insert(sysUser);

//        SysUserCompany sysUserCompany;
//        for(String companyId : checked){
//            if("0".equals(companyId)){
//                continue;
//            }
//            sysUserCompany = new SysUserCompany();
//            sysUserCompany.setId(UUIDUtils.generateUUID());
//            sysUserCompany.setUserId(userId);
//            sysUserCompany.setCompanyId(companyId);
//            sysUserCompanyMapper.insert(sysUserCompany);
//        }

        SysRoleUser sysRoleUser = new SysRoleUser();
        sysRoleUser.setId(UUIDUtils.generateUUID());
        sysRoleUser.setRoleId(sysUserSimple.getRole());
        sysRoleUser.setUserId(userId);
        sysRoleUserMapper.insert(sysRoleUser);

        PartyMemberMessage partyMemberMessage =new PartyMemberMessage();
        partyMemberMessage.setParytmemberid(UUIDUtils.generateUUID());
        partyMemberMessage.setDepartmentid(sysUserSimple.getDepartmentid());
        partyMemberMessage.setName(sysUserSimple.getName());
        partyMemberMessage.setIsleader(sysUserSimple.getIsleader());
        partyMemberMessage.setPartymembergroup(sysUserSimple.getPartymembergroup());
        partyMemberMessage.setRemake1(sysUser.getId());

        partyMemberMessageMapper.insertSelective(partyMemberMessage);

        return true;
    }

    @Override
    @Transactional
    public boolean saveEdit(PartyMemberMessageVo partyMemberMessageVo, String[] checked) {
//        if(!partyMemberMessageVo.getUsername().equals(sysUserSimple.getLastUserName())){
//            SysUserExample sysUserExample = new SysUserExample();
//            sysUserExample.createCriteria().andUsernameEqualTo(sysUserSimple.getUsername());
//            if(sysUserMapper.countByExample(sysUserExample) > 0){
//                return false;
//            }
//        }

        SysUser sysUser = new SysUser();
        sysUser.setId(partyMemberMessageVo.getId());
        sysUser.setName(partyMemberMessageVo.getLoginname());
        sysUser.setUsername(partyMemberMessageVo.getLoginname());
//        sysUser.setPhone(partyMemberMessageVo.getPhone());
        sysUser.setSalt(partyMemberMessageVo.getLoginname());
        sysUserMapper.updateByPrimaryKeySelective(sysUser);

        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(partyMemberMessageVo.getId());
        sysRoleUserMapper.deleteByExample(sysRoleUserExample);

        SysRoleUser sysRoleUser = new SysRoleUser();
        sysRoleUser.setId(UUIDUtils.generateUUID());
        sysRoleUser.setUserId(partyMemberMessageVo.getId());
        sysRoleUser.setRoleId(partyMemberMessageVo.getRole());
        sysRoleUserMapper.insert(sysRoleUser);

        PartyMemberMessageExample partyMemberMessageExample =new PartyMemberMessageExample();
        partyMemberMessageExample.createCriteria().andRemake1EqualTo(partyMemberMessageVo.getId());
       PartyMemberMessage partyMemberMessage =new PartyMemberMessage();

        BeanUtils.copyProperties(partyMemberMessageVo,partyMemberMessage);
        partyMemberMessageMapper.updateByExampleSelective(partyMemberMessage,partyMemberMessageExample);

//        SysUserCompanyExample sysUserCompanyExample = new SysUserCompanyExample();
//        sysUserCompanyExample.createCriteria().andUserIdEqualTo(sysUserSimple.getId());
//        sysUserCompanyMapper.deleteByExample(sysUserCompanyExample);
        SysUserCompany sysUserCompany;
//        for(String companyId : checked){
//            if("0".equals(companyId)){
//                continue;
//            }
//            sysUserCompany = new SysUserCompany();
//            sysUserCompany.setId(UUIDUtils.generateUUID());
//            sysUserCompany.setUserId(sysUserSimple.getId());
//            sysUserCompany.setCompanyId(companyId);
//            sysUserCompanyMapper.insert(sysUserCompany);
//        }
        return true;
    }

    @Override
    public boolean saveChange(SysUpdatePassword sysUpdatePassword) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(sysUpdatePassword.getId());
        if(!MD5Utils.encode(sysUpdatePassword.getOldPassword()).equals(sysUser.getPassword())){
            return false;
        }
        sysUser.setPassword(MD5Utils.encode(sysUpdatePassword.getNewPassword()));
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
        return true;
    }

    @Override
    public void delete(String id) {
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(id);
        sysRoleUserMapper.deleteByExample(sysRoleUserExample);

        sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteAll(List<String> ids) {
        SysRoleUserExample sysRoleUserExample;
        for(String id : ids){
            sysRoleUserExample = new SysRoleUserExample();
            sysRoleUserExample.createCriteria().andUserIdEqualTo(id);
            sysRoleUserMapper.deleteByExample(sysRoleUserExample);

            sysUserMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public Set<String> userCompanies(String userId) {
        SysUserCompanyExample sysUserCompanyExample = new SysUserCompanyExample();
        sysUserCompanyExample.createCriteria().andUserIdEqualTo(userId);
        List<SysUserCompany> sysUserCompanies = sysUserCompanyMapper.selectByExample(sysUserCompanyExample);
        Set<String> companies = new HashSet<String>(16);
        for(SysUserCompany sysUserCompany : sysUserCompanies){
            companies.add(sysUserCompany.getCompanyId());
        }
        return companies;
    }
}
