package com.csg.cn.sys.service.impl;

import com.csg.cn.db.dao.SysRoleMapper;
import com.csg.cn.db.dao.SysRolePermissionMapper;
import com.csg.cn.db.dao.SysUserRoleMapper;
import com.csg.cn.db.entity.*;
import com.csg.cn.sys.service.SysRoleService;
import com.csg.cn.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yichen
 * @description
 * @date 2018/5/27
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public PageInfo<SysRole> listAjax(int index, int size) {

        PageHelper.startPage(index, size);
        List<SysRole> list = sysRoleMapper.selectAll();
        PageInfo<SysRole> page = new PageInfo<>(list);

        return page;
    }

    @Override
    public boolean saveAdd(SysRole sysRole, String[] checked) {

        SysRoleExample example = new SysRoleExample();
        example.createCriteria().andRoleEqualTo(sysRole.getRole());
        long count = sysRoleMapper.countByExample(example);
        if (count > 0){
            return false;
        }

        sysRole.setId(UUIDUtils.generateUUID());
        sysRoleMapper.insert(sysRole);

        for (String permission : checked){
            SysRolePermission rpRel = new SysRolePermission();
            rpRel.setId(UUIDUtils.generateUUID());
            rpRel.setPermissionId(permission);
            rpRel.setRoleId(sysRole.getId());
            sysRolePermissionMapper.insert(rpRel);
        }

        return true;
    }

    @Override
    public SysRole selectById(String id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean saveEdit(SysRole sysRole, String[] checked) {

        SysRoleExample roleExample = new SysRoleExample();
        roleExample.createCriteria().andRoleEqualTo(sysRole.getRole());
        List<SysRole> roles = sysRoleMapper.selectByExample(roleExample);
        if (roles.size() > 0 && !sysRole.getRole().equals(roles.get(0).getRole())){
            return false;
        }

        SysRolePermissionExample example = new SysRolePermissionExample();
        example.createCriteria().andRoleIdEqualTo(sysRole.getId());
        sysRolePermissionMapper.deleteByExample(example);

        for (String permission : checked){
            SysRolePermission rpRel = new SysRolePermission();
            rpRel.setId(UUIDUtils.generateUUID());
            rpRel.setPermissionId(permission);
            rpRel.setRoleId(sysRole.getId());
            sysRolePermissionMapper.insert(rpRel);
        }

        sysRoleMapper.updateByPrimaryKey(sysRole);

        return true;
    }

    @Override
    public void delete(String id) {
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        sysUserRoleExample.createCriteria().andRoleIdEqualTo(id);

        sysUserRoleMapper.deleteByExample(sysUserRoleExample);

        SysRolePermissionExample rolePermissionExample = new SysRolePermissionExample();
        rolePermissionExample.createCriteria().andRoleIdEqualTo(id);

        sysRolePermissionMapper.deleteByExample(rolePermissionExample);

        sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SysRole> allRoles() {

        SysRoleExample example = new SysRoleExample();
        example.createCriteria().andFlagEqualTo((byte) 1);

        return sysRoleMapper.selectByExample(example);
    }

    @Override
    public SysUserRole selectByUserId(String userId) {
        SysUserRole role = new SysUserRole();
        role.setUserId(userId);
        return sysUserRoleMapper.selectOne(role);
    }
}
