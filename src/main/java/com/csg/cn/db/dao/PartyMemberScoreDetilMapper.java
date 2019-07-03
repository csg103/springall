package com.csg.cn.db.dao;

import com.csg.cn.db.entity.PartyMemberScoreDetil;
import com.csg.cn.db.entity.PartyMemberScoreDetilExample;
import com.csg.cn.db.vo.request.AddOrSubScore;
import com.csg.cn.db.vo.request.ScoreDetailReturnVo;
import com.csg.cn.db.vo.request.ScoreReturnVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface PartyMemberScoreDetilMapper extends Mapper<PartyMemberScoreDetil> {
    long countByExample(PartyMemberScoreDetilExample example);


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
    @Select("select  a.remake2, b.isadd from t_partymember_score_detil  a  right join  t_partymember_score_pip b  on  a.pipid =b.scoreid   where a.year= #{year}  and a.partymemberId = #{partymemberId}  ")
        @Results(
            {
                    @Result(column="remake2",property="score"),
                    @Result(column="isadd",property="isAdd")

            }
    )
    List<AddOrSubScore> selectNowScoreDetil(@Param("year")Date year, @Param("partymemberId") String partymemberId);



@Select("select c.scoreDetilId , c.operatorTime  as operatortime , d.remake1 as remake1 ,   b.name,e.departmentName ,d.name as pipName ,d.pip ,c.year,c.operator,c. remake1 as num,c.remake2  as nowScore ,d.score as scorePip  from t_partymember_score  a  right join t_partymember_message b on   a.partymemberId=b.parytMemberId   right join  t_partymember_score_detil c  on b.parytMemberId=c. partymemberId    right join  t_partymember_score_pip d on c.pipId= d.scoreId    right join t_department e  on b.departmentId=e.departmentId  where a.partMemberscoreId = #{partMemberscoreId}  ")

    List<ScoreDetailReturnVo>  selectScoreDetailById(String year,  @Param("partMemberscoreId")String partMemberscoreId);
}