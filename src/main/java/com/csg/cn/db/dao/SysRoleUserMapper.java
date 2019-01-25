package com.csg.cn.db.dao;

import com.csg.cn.db.entity.SysRoleUser;
import com.csg.cn.db.entity.SysRoleUserExample;
import tk.mybatis.mapper.common.Mapper;

public interface SysRoleUserMapper extends Mapper<SysRoleUser> {
    long countByExample(SysRoleUserExample example);
}