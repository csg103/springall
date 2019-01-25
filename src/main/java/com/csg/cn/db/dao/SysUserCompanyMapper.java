package com.csg.cn.db.dao;

import com.csg.cn.db.entity.SysUserCompany;
import com.csg.cn.db.entity.SysUserCompanyExample;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserCompanyMapper extends Mapper<SysUserCompany> {
    long countByExample(SysUserCompanyExample example);
}