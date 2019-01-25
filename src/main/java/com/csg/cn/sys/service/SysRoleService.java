package com.csg.cn.sys.service;


import com.csg.cn.db.entity.SysRole;
import com.csg.cn.db.entity.SysUserRole;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author yichen
 * @description
 * @date 2018/5/27
 **/
public interface SysRoleService {

    /**
     * 分页查询
     * @return
     */
    PageInfo<SysRole> listAjax(int index, int size);

    /**
     * 增加新角色并创建与权限关联关系
     * @param sysRole
     * @param checked
     * @return
     */
    boolean saveAdd(SysRole sysRole, String[] checked);

    /**
     * selectById
     * @param id
     * @return
     */
    SysRole selectById(String id);

    /**
     * 保存更新
     * @param sysRole
     * @param checked
     * @return
     */
    boolean saveEdit(SysRole sysRole, String[] checked);

    /**
     * 删除角色
     * @param id
     */
    void delete(String id);

    /**
     * 查询所有可用角色
     * @return
     */
    List<SysRole> allRoles();

    /**
     * 按用户id返回值
     * @return
     */
    SysUserRole selectByUserId(String userId);

}
