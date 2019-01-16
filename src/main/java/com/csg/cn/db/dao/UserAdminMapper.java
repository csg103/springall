package com.csg.cn.db.dao;

import com.csg.cn.db.entity.UserAdmin;
import com.csg.cn.db.entity.UserAdminExample;
import tk.mybatis.mapper.common.Mapper;

public interface UserAdminMapper extends Mapper<UserAdmin> {
    long countByExample(UserAdminExample example);
}