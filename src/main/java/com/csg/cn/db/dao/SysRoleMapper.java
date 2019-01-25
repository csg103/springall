package com.csg.cn.db.dao;

import com.csg.cn.db.entity.SysRole;
import com.csg.cn.db.entity.SysRoleExample;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysRoleMapper extends Mapper<SysRole> {
    long countByExample(SysRoleExample example);

    List<SysRole> selectListByUserId(String userId);
}