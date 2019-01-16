package com.csg.cn.db.dao;

import com.csg.cn.db.entity.SysUserRole;
import com.csg.cn.db.entity.SysUserRoleExample;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserRoleMapper extends Mapper<SysUserRole> {
    long countByExample(SysUserRoleExample example);
}