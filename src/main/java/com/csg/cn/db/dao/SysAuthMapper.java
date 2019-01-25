package com.csg.cn.db.dao;

import com.csg.cn.db.entity.SysAuth;
import com.csg.cn.db.entity.SysAuthExample;
import com.csg.cn.db.vo.SysAuthCount;
import com.csg.cn.sys.tree.MenuTree;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysAuthMapper extends Mapper<SysAuth> {
    long countByExample(SysAuthExample example);

    List<SysAuth> selectListByRoleId(String roleId);

    List<MenuTree> selectMenu(@Param("id") String id, @Param("userId") String userId);

    List<SysAuthCount> selectAuthWithSubCount(@Param("authParentId") String authParentId);
}