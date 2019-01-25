package com.csg.cn.db.dao;

import com.csg.cn.db.entity.SysUser;
import com.csg.cn.db.entity.SysUserExample;
import com.csg.cn.db.vo.SysUserSimple;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserMapper extends Mapper<SysUser> {
    long countByExample(SysUserExample example);

    List<SysUserSimple> selectList(@Param("searchName") String searchName);

    SysUserSimple selectUserInfo(@Param("id") String id);
}