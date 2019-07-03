package com.csg.cn.business.service.partyMember;

import com.csg.cn.db.entity.Common;
import com.csg.cn.db.entity.Party;
import com.csg.cn.db.entity.PartyRecord;
import com.csg.cn.db.vo.request.PartyMeetingVO;

import java.util.Date;
import java.util.List;

/**
 * @Classname PartyMemberMeetingService
 * @Description TODO
 * @Date 2019/6/11 14:50
 * @Created by ${suge.chen}
 */
public interface PartyMemberMeetingService {


    List<Common> selectType(String str);

    int saveAdd(PartyMeetingVO partyMeetingVO);

    List<Party> selectAll();

    int deleteAllById(List<String> ids);

    List<Party> selectByName(String name);

    Party selectById(String id);

    PartyMeetingVO getPartyMessage(Party party);


    int updateById(PartyMeetingVO partyMeetingVO);

    int saveReacod(PartyRecord partyId);

    List<PartyRecord> selectRecoder(String seachName, String id);

   int  deletePicById(String id);

    List<PartyRecord> selectPartyRecord(String startTime,String endTime,String seachName);




}
