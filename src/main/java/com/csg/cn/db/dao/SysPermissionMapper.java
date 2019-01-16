package com.csg.cn.db.dao;

import com.csg.cn.db.entity.PermissionWithSubCount;
import com.csg.cn.db.entity.SysPermission;
import com.csg.cn.db.entity.SysPermissionExample;
import com.csg.cn.vo.MenuTree;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysPermissionMapper extends Mapper<SysPermission> {
    long countByExample(SysPermissionExample example);

    /**
     * 根据pid查询权限及对应子权限个数
     * @param pid
     * @return
     */
    List<PermissionWithSubCount> selectPermissionWithSubCount(@Param("pid") String pid);

    /**
     * 动态渲染左侧菜单列表
     * @param id
     * @return
     */

    @Select(" select tsp.*,tsur.n_user_id from t_sys_user_role tsur" +
            "    left join t_sys_role_permission tsrp on tsur.n_role_id = tsrp.c_role_id" +
            "    left join t_sys_permission tsp on tsrp.c_permission_id = tsp.id" +
            "    where tsur.n_user_id = #{userId} and tsp.c_pid = #{id} and tsp.c_is_menu = 1")

    @Results(
            {
                    @Result(id=true,column="id",property="id"),
                    @Result(column="c_name",property="name"),
                    @Result(column="c_url",property="url"),
                    @Result(column="c_permission",property="permission"),
                    @Result(column="c_pid",property="pid"),
                    @Result(column="c_company_id",property="companyId"),
                    @Result(column="c_is_menu",property="isMenu"),
                    @Result(column="n_user_id",property="userId")

            }


    )
    List<SysPermission> selectMenu(@Param("id") String id, @Param("userId") String userId);

    List<MenuTree> selectMenuXml(@Param("id") String id, @Param("userId") String userId);

}