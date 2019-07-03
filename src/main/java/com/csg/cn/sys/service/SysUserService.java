package com.csg.cn.sys.service;

import com.csg.cn.db.entity.PartyMemberMessage;
import com.csg.cn.db.entity.SysUser;
import com.csg.cn.db.vo.SysUpdatePassword;
import com.csg.cn.db.vo.SysUserSimple;
import com.csg.cn.db.vo.request.PartyMemberMessageVo;

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

    boolean saveAdd(PartyMemberMessageVo sysUserSimple, String[] checked);

    boolean saveEdit(PartyMemberMessageVo sysUserSimple, String[] checked);

    boolean saveChange(SysUpdatePassword sysUpdatePassword);

    void delete(String id);

    void deleteAll(List<String> ids);

    Set<String> userCompanies(String userId);
}
