package com.csg.cn.sys.service;

import com.csg.cn.db.entity.SysCompany;
import com.csg.cn.db.vo.DeleteMessage;
import com.csg.cn.db.vo.SysCompanyCount;
import com.csg.cn.db.vo.SysCompanySimple;

import java.util.List;

/**
 * Created by yangzy on 2018/11/7.
 */
public interface SysCompanyService {

    List<SysCompany> selectListByEnabled();

    List<SysCompany> selectList(String searchName);

    List<SysCompany> selectListByCompanyParentId(String companyParentId);

    List<SysCompanyCount> getCompanyTreeWithState(String companyParentId);

    List<SysCompanySimple> userCompanies(String userId);

    void saveAdd(SysCompany sysCompany);

    SysCompany edit(String id);

    boolean saveEdit(SysCompany sysCompany);

    boolean delete(String id);

    DeleteMessage deleteAll(List<String> ids);
}
