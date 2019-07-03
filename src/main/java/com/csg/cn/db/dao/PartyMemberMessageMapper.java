package com.csg.cn.db.dao;

import com.csg.cn.db.entity.PartyMemberMessage;
import com.csg.cn.db.entity.PartyMemberMessageExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PartyMemberMessageMapper extends Mapper<PartyMemberMessage> {
    int countByExample(PartyMemberMessageExample example);



    @Select("select a.*,b.valuename as partymembergroupname ,c.departmentname  from t_partymember_message a left join  t_common b on a.partymembergroup=b.id  left join t_department c on a.departmentid=c.departmentid   where name= #{userName} and b.type='02' ")
//    @Results(
//            {
//                    @Result(id=true,column="id",property="id"),
//                    @Result(column="c_username",property="username"),
//                    @Result(column="c_name",property="name"),
//                    @Result(column="c_password",property="password"),
//                    @Result(column="c_salt",property="salt"),
//                    @Result(column="c_company_id",property="companyId")
//
//            }
//    )
    List<PartyMemberMessage> selectList(@Param("userName") String userName);

    @Select("select a.*,b.valuename as partymembergroupname ,c.departmentname  from t_partymember_message  a left join  t_common b on a.partymembergroup=b.id  left join t_department c on a.departmentid=c.departmentid    where partyMemberGroup= #{group}   and b.type='02'")
    List<PartyMemberMessage> selectListByGroup(@Param("group") String group);



    @Select("select b.valuename  as partymembergroupname,c.departmentname  ,a.* from t_partymember_message  a left join  t_common b on a.partymembergroup=b.id    left join t_department c on a.departmentid=c.departmentid  where   b.type='02'")
    List<PartyMemberMessage> selectAllByAll();


    @Select("select a.* from t_partymember_message a  where remake1= #{remake1} ")
    List<PartyMemberMessage> selectMesByUserId(@Param("remake1") String id);


    @Update("update t_partymember_message set remale2 =#{remake2} where parytmemberid =  #{parytmemberid} ")
    int   updateRemake2ById(@Param("parytmemberid") String parytmemberid,@Param("remake2") String remake2);



    @Select("select a.* ,b.valuename as partymembergroupname from t_partymember_message a ,t_common b where  a.partymembergroup  =b.id")
    List<PartyMemberMessage> selectAllAndGroupName();


}