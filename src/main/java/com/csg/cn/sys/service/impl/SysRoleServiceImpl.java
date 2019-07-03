package com.csg.cn.sys.service.impl;

import com.baidu.UUIDUtils;
import com.csg.cn.db.dao.SysRoleAuthMapper;
import com.csg.cn.db.dao.SysRoleMapper;
import com.csg.cn.db.dao.SysRoleUserMapper;
import com.csg.cn.db.entity.*;
import com.csg.cn.sys.constant.SysConstant;
import com.csg.cn.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yangzy on 2018/10/31.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleAuthMapper sysRoleAuthMapper;
    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Override
    public List<SysRole> selectListByUserId(String userId) {
        return sysRoleMapper.selectListByUserId(userId);
    }

    @Override
    public List<SysRole> selectAll() {
       return sysRoleMapper.selectAll();
    }

    @Override
    public List<SysRole> selectListByEnabled() {
        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria().andRoleStatusEqualTo(SysConstant.ENABLED_ONE);
        return sysRoleMapper.selectByExample(sysRoleExample);
    }

    @Override
    public boolean saveAdd(SysRole sysRole, String[] checked) {
        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria().andRoleNameEqualTo(sysRole.getRoleName());
        if(sysRoleMapper.countByExample(sysRoleExample) > 0){
            return false;
        }
        String id = UUIDUtils.generateUUID();
        sysRole.setId(id);
        sysRoleMapper.insert(sysRole);

        SysRoleAuth sysRoleAuth;
        for(String authId : checked){
            if("0".equals(authId)){
                continue;
            }
            sysRoleAuth = new SysRoleAuth();
            sysRoleAuth.setId(UUIDUtils.generateUUID());
            sysRoleAuth.setAuthId(authId);
            sysRoleAuth.setRoleId(id);
            sysRoleAuthMapper.insert(sysRoleAuth);
        }
        return true;
    }

    @Override
    public SysRole selectOne(String id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean saveEdit(SysRole sysRole, String[] checked) {
        if(!sysRole.getRoleName().equals(sysRole.getLastRoleName())){
            SysRoleExample sysRoleExample = new SysRoleExample();
            sysRoleExample.createCriteria().andRoleNameEqualTo(sysRole.getRoleName());
            if(sysRoleMapper.countByExample(sysRoleExample) > 0){
                return false;
            }
        }

        SysRoleAuthExample sysRoleAuthExample = new SysRoleAuthExample();
        sysRoleAuthExample.createCriteria().andRoleIdEqualTo(sysRole.getId());
        sysRoleAuthMapper.deleteByExample(sysRoleAuthExample);

        SysRoleAuth sysRoleAuth;
        for(String authId : checked){
            if("0".equals(authId)){
                continue;
            }
            sysRoleAuth = new SysRoleAuth();
            sysRoleAuth.setId(UUIDUtils.generateUUID());
            sysRoleAuth.setRoleId(sysRole.getId());
            sysRoleAuth.setAuthId(authId);
            sysRoleAuthMapper.insert(sysRoleAuth);
        }

        sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        return true;
    }

    @Override
    public void delete(String id) {
        sysRoleMapper.deleteByPrimaryKey(id);

        SysRoleAuthExample sysRoleAuthExample = new SysRoleAuthExample();
        sysRoleAuthExample.createCriteria().andRoleIdEqualTo(id);
        sysRoleAuthMapper.deleteByExample(sysRoleAuthExample);

        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andRoleIdEqualTo(id);
        sysRoleUserMapper.deleteByExample(sysRoleUserExample);
    }
}
