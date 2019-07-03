package com.csg.cn.db.dao;

import com.csg.cn.db.entity.PartyMemberMessage;
import com.csg.cn.db.entity.PartyMemberScore;
import com.csg.cn.db.entity.PartyMemberScoreExample;
import com.csg.cn.db.vo.request.ScoreReturnVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface PartyMemberScoreMapper extends Mapper<PartyMemberScore> {
    long countByExample(PartyMemberScoreExample example);


    int  insertList(List<PartyMemberScore> list);


    @Select("select * from t_partymember_message where name= #{userName}")
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
    @Select("select   a.partMemberscoreId ,b.parytmemberid , a.score ,a.year  ,c.departmentName ,b.name ,b.isLeader , b.partyMemberGroup  from t_partymember_score a left join t_partymember_message b on a.partymemberid =b.parytmemberid        left join  t_department c  on b.departmentId =c.departmentId  where year =#{year} order by  a.score+0  DESC")
    @Results(
            {
                    @Result(id=true,column="partMemberscoreId",property="partMemberscoreId"),
                    @Result(column="score",property="score"),
                    @Result(column="departmentName",property="departmentName"),
                    @Result(column="name",property="name"),
                    @Result(column="isLeader",property="isLeader"),
                    @Result(column="year",property="year"),
                    @Result(column="parytmemberid",property="parytmemberid"),
                    @Result(column="partyMemberGroup",property="partyMemberGroup")

            }
    )
    List<ScoreReturnVo>  selectScoreByTime(@Param("year") Date year);


    @Select("select   a.partMemberscoreId ,b.parytmemberid , a.score ,a.year  ,c.departmentName ,b.name ,b.isLeader , b.partyMemberGroup  from t_partymember_score a left join t_partymember_message b on a.partymemberid =b.parytmemberid        left join  t_department c  on b.departmentId =c.departmentId  where year =#{year}  AND c.departmentId =#{departmentId}  order by  a.score+0  DESC")
    @Results(
            {
                    @Result(id=true,column="partMemberscoreId",property="partMemberscoreId"),
                    @Result(column="score",property="score"),
                    @Result(column="departmentName",property="departmentName"),
                    @Result(column="name",property="name"),
                    @Result(column="isLeader",property="isLeader"),
                    @Result(column="year",property="year"),
                    @Result(column="parytmemberid",property="parytmemberid"),
                    @Result(column="partyMemberGroup",property="partyMemberGroup")

            }
    )
    List<ScoreReturnVo>  selectScoreByTimeByDepId(@Param("year") Date yea,@Param("departmentId") String departmentId);


    @Select("select  b.remale2, a.partMemberscoreId ,b.parytmemberid , a.score ,a.year  ,c.departmentName ,b.name ,b.isLeader , b.partyMemberGroup  from t_partymember_score a left join t_partymember_message b on a.partymemberid =b.parytmemberid        left join  t_department c  on b.departmentId =c.departmentId  where a.partMemberscoreId =#{id}")

    List<ScoreReturnVo>   selectMesById(@Param("id") String id);
}