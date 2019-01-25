package com.csg.cn.sys.service;

import com.csg.cn.db.entity.SysUser;
import com.github.pagehelper.PageInfo;

/**
 * @author yichen
 * @description
 * @date 2018/5/19
 **/
public interface SysUserService {

    PageInfo<SysUser> listAjax(int index, int size);

    boolean saveAdd(SysUser sysUser, String roleId);

    boolean saveEdit(SysUser sysUser, String roleId);

    SysUser selectById(String id);

    void delete(String id);

}
