package com.csg.cn.db.dao;

import com.csg.cn.db.entity.PartyMemberFamily;
import com.csg.cn.db.entity.PartyMemberFamilyExample;
import com.csg.cn.db.entity.PartyMemberMessage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PartyMemberFamilyMapper extends Mapper<PartyMemberFamily> {
    int countByExample(PartyMemberFamilyExample example);


    @Select("select * from t_partymember_family where partymemberid= #{partymemberid}")
    List<PartyMemberFamily> getFamilyMes(@Param("partymemberid") String partymemberid);



    @Select("delete  from t_partymember_family where partymemberid = #{partymemberid}")
    void deleteById(@Param("partymemberid") String partymemberid);


}