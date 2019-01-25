package com.csg.cn.sys.service;

import com.csg.cn.db.entity.SysRole;

import java.util.List;

/**
 * Created by yangzy on 2018/10/31.
 */
public interface SysRoleService {

    List<SysRole> selectListByUserId(String userId);

    List<SysRole> selectAll();

    List<SysRole> selectListByEnabled();

    boolean saveAdd(SysRole sysRole, String[] checked);

    SysRole selectOne(String id);

    boolean saveEdit(SysRole sysRole, String[] checked);

    void delete(String id);
}
