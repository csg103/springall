package com.csg.cn.db.dao;

import com.csg.cn.db.entity.User;
import com.csg.cn.db.entity.UserExample;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    long countByExample(UserExample example);

    @Select("select a.* from t_user a ,t_user_admin b where  a.id = b.id ")
    public List<User> selectAllSql();
}