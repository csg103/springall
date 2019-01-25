package com.csg.cn.sys.service;

import com.csg.cn.db.entity.SysAuth;
import com.csg.cn.db.vo.SysAuthCount;

import java.util.List;
import java.util.Set;

/**
 * Created by yangzy on 2018/10/31.
 */
public interface SysAuthService {

    List<SysAuth> selectListByRoleId(String roleId);

    String menuTree(String ctx, String userId);

    List<SysAuth> selectListByAuthParentId(String authParentId);

    void insert(SysAuth sysAuth);

    void update(SysAuth sysAuth);

    SysAuth selectOne(String id);

    Long selectSubAuth(String id);

    void delete(String id);

    List<SysAuthCount> selectAuthWithSubCount(String authParentId);

    Set<String> roleAuths(String roleId);
}
