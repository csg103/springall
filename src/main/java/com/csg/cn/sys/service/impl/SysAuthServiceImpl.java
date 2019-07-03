package com.csg.cn.sys.service.impl;

import com.csg.cn.db.dao.SysAuthMapper;
import com.csg.cn.db.dao.SysRoleAuthMapper;
import com.csg.cn.db.entity.SysAuth;
import com.csg.cn.db.entity.SysAuthExample;
import com.csg.cn.db.entity.SysRoleAuth;
import com.csg.cn.db.entity.SysRoleAuthExample;
import com.csg.cn.db.vo.SysAuthCount;
import com.csg.cn.sys.service.SysAuthService;
import com.csg.cn.sys.tree.MenuTree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yangzy on 2018/10/31.
 */
@Service
public class SysAuthServiceImpl implements SysAuthService {

    @Autowired
    private SysAuthMapper sysAuthMapper;
    @Autowired
    private SysRoleAuthMapper sysRoleAuthMapper;

    @Override
    public List<SysAuth> selectListByRoleId(String roleId) {
        return sysAuthMapper.selectListByRoleId(roleId);
    }

    @Override
   public    List<MenuTree>  menuTree(String ctx, String userId){
//        List<MenuTree> menuTreeList = sysAuthMapper.selectMenu("0", userId);

//        List<MenuTree> menuTreeList =
        return sysAuthMapper.selectMenu("0", userId);
    }

    @Override
    public List<SysAuth> selectListByAuthParentId(String authParentId) {
        SysAuthExample sysAuthExample = new SysAuthExample();
        sysAuthExample.createCriteria().andAuthParentIdEqualTo(authParentId);
        sysAuthExample.setOrderByClause("auth_order desc");
        return sysAuthMapper.selectByExample(sysAuthExample);
    }

    @Override
    public void insert(SysAuth sysAuth) {
        sysAuthMapper.insert(sysAuth);
    }

    @Override
    public void update(SysAuth sysAuth) {
        sysAuthMapper.updateByPrimaryKeySelective(sysAuth);
    }

    @Override
    public SysAuth selectOne(String id) {
        return sysAuthMapper.selectByPrimaryKey(id);
    }

    @Override
    public Long selectSubAuth(String id) {
        SysAuthExample sysAuthExample = new SysAuthExample();
        sysAuthExample.createCriteria().andAuthParentIdEqualTo(id);
        return sysAuthMapper.countByExample(sysAuthExample);
    }

    @Override
    public void delete(String id) {
        sysAuthMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SysAuthCount> selectAuthWithSubCount(String authParentId) {
        return sysAuthMapper.selectAuthWithSubCount(authParentId);
    }

    @Override
    public Set<String> roleAuths(String roleId) {
        SysRoleAuthExample sysRoleAuthExample = new SysRoleAuthExample();
        sysRoleAuthExample.createCriteria().andRoleIdEqualTo(roleId);
        List<SysRoleAuth> sysRoleAuths = sysRoleAuthMapper.selectByExample(sysRoleAuthExample);
        Set<String> auths = new HashSet<String>(16);
        for(SysRoleAuth sysRoleAuth : sysRoleAuths){
            auths.add(sysRoleAuth.getAuthId());
        }
        return auths;
    }
}
