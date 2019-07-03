package com.csg.cn.db.dao;

import com.csg.cn.db.entity.PartyMemberMessage;
import com.csg.cn.db.entity.PartyRecord;
import com.csg.cn.db.entity.PartyRecordExample;
import com.csg.cn.db.vo.request.PartyMeetingVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface PartyRecordMapper extends Mapper<PartyRecord> {
    long countByExample(PartyRecordExample example);

    @Select("select a.*,CONCAT(picip ,picurl) as AllUrl  from t_party_record a where partyid= #{partyid}")

    List<PartyRecord> selectMesByPartyId(@Param("partyid") String partyid);


    @Select("select a.*,CONCAT(picip ,picurl) as AllUrl   from t_party_record a  where partyid= #{partyid} and partymemberid=  #{partymemberid}")

    List<PartyRecord> selectMesByPartyIdAndName(@Param("partyid") String partyid ,@Param("partymemberid") String name);


    @Select("select a.*,CONCAT(picip ,picurl) as AllUrl ,b.partyname as partyName  from t_party_record a ,t_party b where a.partyid=b.partyid and a.uploadtime>= #{starttime} and  a.uploadtime <= #{endtime} and a.partymemberid like CONCAT('%',#{partymemberid},'%')")
    List<PartyRecord> selectPartyRecord(@Param("starttime") String starttime , @Param("endtime") String endtime , @Param("partymemberid") String name);



    @Select("select a.*,CONCAT(picip ,picurl) as AllUrl  ,b.partyname as partyName   from t_party_record a ,t_party b where a.partyid=b.partyid  and a.uploadtime>= #{starttime} and  a.uploadtime <= #{endtime}")
    List<PartyRecord> selectPartyRecordNoName(@Param("starttime") String starttime , @Param("endtime") String endtime );




}