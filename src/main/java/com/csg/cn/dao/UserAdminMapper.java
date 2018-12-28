package com.csg.cn.dao;

import com.csg.cn.entity.UserAdmin;
import com.csg.cn.entity.UserAdminExample;
import tk.mybatis.mapper.common.Mapper;

public interface UserAdminMapper extends Mapper<UserAdmin> {
    long countByExample(UserAdminExample example);
}