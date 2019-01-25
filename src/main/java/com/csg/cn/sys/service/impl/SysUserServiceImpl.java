package com.csg.cn.sys.service.impl;

import com.csg.cn.db.dao.SysUserMapper;
import com.csg.cn.db.dao.SysUserRoleMapper;
import com.csg.cn.db.entity.SysUser;
import com.csg.cn.db.entity.SysUserExample;
import com.csg.cn.db.entity.SysUserRole;
import com.csg.cn.db.entity.SysUserRoleExample;
import com.csg.cn.sys.service.SysUserService;
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
 * @date 2018/5/19
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public PageInfo<SysUser> listAjax(int index, int size) {

        PageHelper.startPage(index, size);
        List<SysUser> users = sysUserMapper.selectAll();
        PageInfo<SysUser> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    public boolean saveAdd(SysUser sysUser, String roleId) {

        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(sysUser.getUsername());

        long count = sysUserMapper.countByExample(example);

        if (count > 0){
            return false;
        }

        sysUser.setId(UUIDUtils.generateUUID());
        sysUser.setSalt(sysUser.getUsername());
        sysUserMapper.insert(sysUser);

        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setId(UUIDUtils.generateUUID());
        sysUserRole.setRoleId(roleId);
        sysUserRole.setUserId(sysUser.getId());
        sysUserRoleMapper.insert(sysUserRole);

        return true;
    }

    @Override
    public boolean saveEdit(SysUser sysUser, String roleId) {

        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(sysUser.getUsername()).andIdNotEqualTo(sysUser.getId());

        long count = sysUserMapper.countByExample(example);

        if (count > 0){
            return false;
        }

        sysUserMapper.updateByPrimaryKeySelective(sysUser);

        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        sysUserRoleExample.createCriteria().andUserIdEqualTo(sysUser.getId());

        sysUserRoleMapper.deleteByExample(sysUserRoleExample);

        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setId(UUIDUtils.generateUUID());
        sysUserRole.setRoleId(roleId);
        sysUserRole.setUserId(sysUser.getId());
        sysUserRoleMapper.insert(sysUserRole);

        return true;
    }

    @Override
    public SysUser selectById(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(String id) {
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria().andUserIdEqualTo(id);

        sysUserRoleMapper.deleteByExample(example);

        sysUserMapper.deleteByPrimaryKey(id);
    }
}
