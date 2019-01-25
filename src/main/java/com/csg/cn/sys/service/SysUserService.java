package com.csg.cn.sys.service;

import com.csg.cn.db.entity.SysUser;
import com.csg.cn.db.vo.SysUpdatePassword;
import com.csg.cn.db.vo.SysUserSimple;

import java.util.List;
import java.util.Set;

/**
 * Created by yangzy on 2018/10/31.
 */
public interface SysUserService {

    SysUser selectOneByUsername(String username);

    SysUser selectOne(String id);

    SysUserSimple selectUserInfo(String id);

    List<SysUserSimple> selectList(String searchName);

    List<SysUser> selectList();

    boolean saveAdd(SysUserSimple sysUserSimple, String[] checked);

    boolean saveEdit(SysUserSimple sysUserSimple, String[] checked);

    boolean saveChange(SysUpdatePassword sysUpdatePassword);

    void delete(String id);

    void deleteAll(List<String> ids);

    Set<String> userCompanies(String userId);
}
