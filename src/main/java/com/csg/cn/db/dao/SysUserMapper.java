package com.csg.cn.db.dao;

import com.csg.cn.db.entity.SysUser;
import com.csg.cn.db.entity.SysUserExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserMapper extends Mapper<SysUser> {
    long countByExample(SysUserExample example);
    @Select("select a.* from t_sys_user a  where a.c_username = #{username}")
    @Results(
            {
                    @Result(id=true,column="id",property="id"),
                    @Result(column="c_username",property="username"),
                    @Result(column="c_name",property="name"),
                    @Result(column="c_password",property="password"),
                    @Result(column="c_salt",property="salt"),
                    @Result(column="c_company_id",property="companyId")

            }
    )
    List<SysUser> selectUserByUsername(@Param("username") String username);
}