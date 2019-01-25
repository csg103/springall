package com.csg.cn.db.dao;

import com.csg.cn.db.entity.SysRoleAuth;
import com.csg.cn.db.entity.SysRoleAuthExample;
import tk.mybatis.mapper.common.Mapper;

public interface SysRoleAuthMapper extends Mapper<SysRoleAuth> {
    long countByExample(SysRoleAuthExample example);
}