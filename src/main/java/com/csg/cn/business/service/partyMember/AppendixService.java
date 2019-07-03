package com.csg.cn.business.service.partyMember;

import com.csg.cn.db.entity.Appendix;
import com.csg.cn.db.entity.Common;
import com.csg.cn.db.entity.Party;
import com.csg.cn.db.entity.PartyRecord;
import com.csg.cn.db.vo.request.PartyMeetingVO;

import java.util.List;

/**
 * @Classname PartyMemberMeetingService
 * @Description TODO
 * @Date 2019/6/11 14:50
 * @Created by ${suge.chen}
 */
public interface AppendixService {

   List<Appendix> selectAppendixList(String name, String starttime, String endtime, String type);

  int  saveAppendixList(List<Appendix> list);

    int deleteAllById(List<String> ids);
}
