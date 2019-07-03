package com.csg.cn.db.dao;

import com.csg.cn.db.entity.Party;
import com.csg.cn.db.entity.PartyExample;
import com.csg.cn.db.entity.PartyMemberMessage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PartyMapper extends Mapper<Party> {
    long countByExample(PartyExample example);


    @Select("select b.valueName as typeName, a.* from t_party a,t_common b where a.type=b.id ")
    List<Party> selectAllAndTypeName();


    @Select("select b.valueName as typeName, a.* from t_party a,t_common b where a.type=b.id  and  partyName like CONCAT('%',#{partyName},'%')")
    List<Party> selectByName(@Param("partyName") String partyName);


}