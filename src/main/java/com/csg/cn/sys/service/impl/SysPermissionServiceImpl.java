package com.csg.cn.sys.service.impl;


import com.csg.cn.db.dao.SysPermissionMapper;
import com.csg.cn.db.dao.SysRolePermissionMapper;
import com.csg.cn.db.entity.*;
import com.csg.cn.sys.service.SysPermissionService;
import com.csg.cn.utils.NavUtils;
import com.csg.cn.vo.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yichen
 * @description
 * @date
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public List<SysPermission> getPermissionsByPid(String pid) {

        SysPermissionExample example = new SysPermissionExample();
        example.createCriteria().andPidEqualTo(pid);

        return sysPermissionMapper.selectByExample(example);
    }

    @Override
    public void insert(SysPermission sysPermission) {
        sysPermissionMapper.insert(sysPermission);
    }

    @Override
    public SysPermission selectById(String id) {
        return sysPermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(SysPermission sysPermission) {
        sysPermissionMapper.updateByPrimaryKey(sysPermission);
    }

    @Override
    public long countSubPermission(String id){
        SysPermissionExample example = new SysPermissionExample();
        example.createCriteria().andPidEqualTo(id);
        long count = sysPermissionMapper.countByExample(example);
        return count;
    }

    @Override
    public void deletePermission(String id) {
        SysRolePermissionExample example = new SysRolePermissionExample();
        example.createCriteria().andPermissionIdEqualTo(id);
        sysRolePermissionMapper.deleteByExample(example);

        sysPermissionMapper.deleteByPrimaryKey(id);

    }

    @Override
    public Set<String> rolesPermission(String roleId) {
        SysRolePermissionExample example = new SysRolePermissionExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<SysRolePermission> list = sysRolePermissionMapper.selectByExample(example);
        Set<String> set = new HashSet<>();
        for (SysRolePermission srp : list){

            set.add(srp.getPermissionId());
        }
        return set;
    }

    @Override
    public long countSubPermissionByPid(String pid) {
        SysPermissionExample example = new SysPermissionExample();
        example.createCriteria().andPidEqualTo(pid);
        return sysPermissionMapper.countByExample(example);
    }

    @Override
    public List<PermissionWithSubCount> selectPermissionWithSubCount(String pid) {
        return sysPermissionMapper.selectPermissionWithSubCount(pid);
    }

    @Override
    public String menuTree(String ctx, String userId) {
        List<MenuTree> menuTreeList = sysPermissionMapper.selectMenuXml("0", userId);
        return NavUtils.getMenuTree(ctx, menuTreeList);
    }
}
