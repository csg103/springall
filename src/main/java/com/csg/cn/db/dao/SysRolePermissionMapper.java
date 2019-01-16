package com.csg.cn.db.dao;

import com.csg.cn.db.entity.SysRolePermission;
import com.csg.cn.db.entity.SysRolePermissionExample;
import tk.mybatis.mapper.common.Mapper;

public interface SysRolePermissionMapper extends Mapper<SysRolePermission> {
    long countByExample(SysRolePermissionExample example);
}