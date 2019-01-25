package com.csg.cn.db.dao;

import com.csg.cn.db.entity.SysCompany;
import com.csg.cn.db.entity.SysCompanyExample;
import com.csg.cn.db.vo.SysCompanyCount;
import com.csg.cn.db.vo.SysCompanySimple;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysCompanyMapper extends Mapper<SysCompany> {
    long countByExample(SysCompanyExample example);

    List<SysCompanyCount> getCompanyTreeWithState(@Param("companyParentId") String companyParentId);

    List<SysCompanySimple> userCompanies(@Param("userId") String userId);
}