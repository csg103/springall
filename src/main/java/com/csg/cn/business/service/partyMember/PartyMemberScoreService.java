package com.csg.cn.business.service.partyMember;

import com.csg.cn.db.entity.PartyMemberFamily;
import com.csg.cn.db.entity.PartyMemberScorePip;
import com.csg.cn.db.vo.request.ScoreDetailReturnVo;
import com.csg.cn.db.vo.request.ScoreReturnVo;

import java.util.List;

/**
 * @Classname PartyMemberFamilyService
 * @Description TODO
 * @Date 2019/5/27 11:57
 * @Created by ${suge.chen}
 */
public interface PartyMemberScoreService {

    public int  addScoreBase(String year);

   List<ScoreReturnVo>  selectScoreByTime(String year ,String departmentid);

    ScoreReturnVo selectMesById(String id );

    List<PartyMemberScorePip>  getPip();

    int  saveDetail( String yearString ,String parytmemberid,String selectId,String remake);

    int  saveDetailNew( String yearString ,String parytmemberid,String selectId,String remake);


    List<ScoreDetailReturnVo>  selectScoreDetailById(String year, String id);

   void deleteAll(List<String> ids);
}
