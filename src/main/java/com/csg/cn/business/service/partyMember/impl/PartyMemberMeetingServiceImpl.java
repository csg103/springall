package com.csg.cn.business.service.partyMember.impl;

import com.alibaba.fastjson.JSONObject;
import com.baidu.UUIDUtils;
import com.csg.cn.business.service.partyMember.PartyMemberMeetingService;
import com.csg.cn.db.dao.*;
import com.csg.cn.db.entity.*;
import com.csg.cn.db.vo.request.CheckedMes;
import com.csg.cn.db.vo.request.PartyMeetingVO;
import com.csg.cn.sys.config.FastDFSUploader;
import com.csg.cn.utils.BaseUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;
import org.thymeleaf.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Classname PartyMemberMeetingServiceImpl
 * @Description TODO
 * @Date 2019/6/11 14:50
 * @Created by ${suge.chen}
 */
@Service
public class PartyMemberMeetingServiceImpl implements PartyMemberMeetingService {
    @Autowired
    private CommonMapper commonMapper;
    @Autowired
    private PartyMapper partyMapper;

    @Autowired
    private PartyRecordMapper partyRecordMapper;

    @Autowired
    private PartyMemberMessageMapper partyMemberMessageMapper;
    @Autowired
    private PartyMemberScoreDetilMapper partyMemberScoreDetilMapper;
    @Autowired
    private PartyMemberScorePipMapper partyMemberScorePipMapper;
    @Autowired
    private PartyMemberScoreMapper partyMemberScoreMapper;


    @Autowired
    private FastDFSUploader fastDFSUploader;

    @Value("${fdfs.host}")
    private String host;

    @Override
    public List<Common> selectType(String str) {
        List list = commonMapper.selectType(str);
        return list;
    }

    @Override
    public int saveAdd(PartyMeetingVO partyMeetingVO) {
        String userName = (String) SecurityUtils.getSubject().getSession().getAttribute("userName");
        String isLeader = (String) SecurityUtils.getSubject().getSession().getAttribute("isLeader");
        String group = (String) SecurityUtils.getSubject().getSession().getAttribute("group");
        Party party = new Party();
        party.setOper(userName);
        party.setOpertime(new Date());
        //小组会 小组
        party.setRemake1(partyMeetingVO.getGroupid());
        party.setPartyadress(partyMeetingVO.getPartyadress());
        party.setPartyid(UUIDUtils.generateUUID());
        party.setPartytime(partyMeetingVO.getPartytime());
        party.setPartyname(partyMeetingVO.getPartyname());
        party.setType(partyMeetingVO.getType());
        int i = partyMapper.insert(party);


        return i;
    }

    @Override
    public List<Party> selectAll() {

        return partyMapper.selectAllAndTypeName();
    }

    @Override
    public int deleteAllById(List<String> ids) {
        PartyExample partyExample;
        for (String id : ids) {


            partyMapper.deleteByPrimaryKey(id);
        }
        return 1;

    }

    @Override
    public List<Party> selectByName(String name) {


        return partyMapper.selectByName(name);
    }

    @Override
    public Party selectById(String id) {

        return partyMapper.selectByPrimaryKey(id);
    }

    @Override
    public PartyMeetingVO getPartyMessage(Party party) {
//        PartyMeetingVO
//        String strtype = party.getType();
//        String[]  strArgs =strtype.split(",");
//
//        for(String type :strArgs){
//           Common common = commonMapper.selectByPrimaryKey(type);
//
//        }
        return null;
    }


    @Override
    public int updateById(PartyMeetingVO partyMeetingVO) {
        List<CheckedMes> list = new ArrayList();
        for (String str : partyMeetingVO.getMes()) {
            list.addAll(JSONObject.parseArray(str, CheckedMes.class));
        }
        StringBuffer sb = new StringBuffer();
        for (CheckedMes checkedMes : list) {
            sb.append(checkedMes.getValue()).append("_").append(checkedMes.getGroup()).append(",");
        }
//        PartyExample partyExample =new PartyExample();
//        partyExample.createCriteria()
        Party party = new Party();
        party.setPartyid(partyMeetingVO.getPartyid());
        party.setPartyplayers(sb.toString());
        int i = partyMapper.updateByPrimaryKeySelective(party);

//更新分数// 根据会议类型匹配出未参加会议的人员 更新scoreDetaik 表  并且删除已有的当前会议的签到情况，更新  并重新计算分数更新分数表。
        updateScore(partyMeetingVO, list);


        return i;
    }


    private void updateScore(PartyMeetingVO partyMeetingVO, List<CheckedMes> list) {
        String[] arryType = partyMeetingVO.getType().split(",");
        List<PartyMemberMessage> partyMemberMessageListNoCkeck = new ArrayList<>();
        for (String str : arryType) {
            if ("".equals(str)) continue;
            //党员大会或者党课
            if (StringUtils.equals(str, "1") || StringUtils.equals(str, "4")) {
                List<PartyMemberMessage> partyMemberMessageList = partyMemberMessageMapper.selectAll();

                for (PartyMemberMessage partyMemberMessage : partyMemberMessageList) {
                    if (partyMemberMessage.getName().equals("admin")) {
                        partyMemberMessageListNoCkeck.add(partyMemberMessage);

                    }
                    for (CheckedMes checkedMes : list)
                        if (StringUtils.equals(checkedMes.getValue(), partyMemberMessage.getParytmemberid())) {
                            partyMemberMessageListNoCkeck.add(partyMemberMessage);

                        }

                }
                partyMemberMessageList.removeAll(partyMemberMessageListNoCkeck);

                    saveScoreDetail(partyMemberMessageList, partyMeetingVO, str);



            }
            //党小组会
            if (StringUtils.equals(str, "3")) {
                PartyMemberMessageExample partyMemberMessageExample = new PartyMemberMessageExample();
                partyMemberMessageExample.createCriteria().andPartymembergroupEqualTo(partyMeetingVO.getGroupid());
                List<PartyMemberMessage> partyMemberMessageList = partyMemberMessageMapper.selectByExample(partyMemberMessageExample);
                for (PartyMemberMessage partyMemberMessage : partyMemberMessageList) {
                    for (CheckedMes checkedMes : list)
                        if (StringUtils.equals(checkedMes.getValue(), partyMemberMessage.getParytmemberid())) {
                            partyMemberMessageListNoCkeck.add(partyMemberMessage);

                        }
                }
                partyMemberMessageList.removeAll(partyMemberMessageListNoCkeck);

                    saveScoreDetail(partyMemberMessageList, partyMeetingVO, str);


            }
            //支部委员会
            if (StringUtils.equals(str, "2")) {
                PartyMemberMessageExample partyMemberMessageExample = new PartyMemberMessageExample();
                partyMemberMessageExample.createCriteria().andIsleaderEqualTo("2");
                List<PartyMemberMessage> partyMemberMessageList = partyMemberMessageMapper.selectByExample(partyMemberMessageExample);
                for (PartyMemberMessage partyMemberMessage : partyMemberMessageList) {
                    for (CheckedMes checkedMes : list)
                        if (StringUtils.equals(checkedMes.getValue(), partyMemberMessage.getParytmemberid())) {
                            partyMemberMessageListNoCkeck.add(partyMemberMessage);

                        }
                }
                partyMemberMessageList.removeAll(partyMemberMessageListNoCkeck);

                    saveScoreDetail(partyMemberMessageList, partyMeetingVO, str);

            }

        }

    }

    void saveScoreDetail(List<PartyMemberMessage> partyMemberMessageList, PartyMeetingVO partyMeetingVO, String str) {

        PartyMemberScoreDetilExample partyMemberScoreDetilExample1 = new PartyMemberScoreDetilExample();
        partyMemberScoreDetilExample1.createCriteria().andRemake1EqualTo(partyMeetingVO.getPartyid());
        List<PartyMemberScoreDetil> prtyMemberScoreDetilListParty = partyMemberScoreDetilMapper.selectByExample(partyMemberScoreDetilExample1);

        delScoreDetail(partyMeetingVO);

        Calendar cal = Calendar.getInstance();
        cal.setTime(partyMeetingVO.getPartytime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = null;
        try {
            date = sdf.parse(String.valueOf(cal.get(Calendar.YEAR)));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        for (PartyMemberMessage partyMemberMessage : partyMemberMessageList) {
            PartyMemberScoreDetil partyMemberScoreDetil = new PartyMemberScoreDetil();
            partyMemberScoreDetil.setScoredetilid(UUIDUtils.generateUUID());
            partyMemberScoreDetil.setPartymemberid(partyMemberMessage.getParytmemberid());
            //缺席三会一课
            partyMemberScoreDetil.setPipid("6");
            partyMemberScoreDetil.setRemake1(partyMeetingVO.getPartyid());
            partyMemberScoreDetil.setOperatortime(new Date());
            partyMemberScoreDetil.setOperator((String) SecurityUtils.getSubject().getSession().getAttribute("userName"));
            partyMemberScoreDetil.setYear(date);
            partyMemberScoreDetilMapper.insert(partyMemberScoreDetil);


        }


        for (PartyMemberMessage partyMemberMessage : partyMemberMessageList) {
            List<PartyMemberScorePip> partyMemberScorePipList = partyMemberScorePipMapper.selectAll();
            PartyMemberScoreDetilExample partyMemberScoreDetilExample = new PartyMemberScoreDetilExample();
            partyMemberScoreDetilExample.createCriteria().andYearEqualTo(date).andPartymemberidEqualTo(partyMemberMessage.getParytmemberid());
            List<PartyMemberScoreDetil> prtyMemberScoreDetilList1 = partyMemberScoreDetilMapper.selectByExample(partyMemberScoreDetilExample);
            int i = BaseUtils.getScore(prtyMemberScoreDetilList1, partyMemberScorePipList);
            //计算分数
            PartyMemberScore partyMemberScore = new PartyMemberScore();
            partyMemberScore.setScore(Integer.toString(i));
            PartyMemberScoreExample partyMemberScoreExample = new PartyMemberScoreExample();


            partyMemberScoreExample.createCriteria().andYearEqualTo(date).andPartymemberidEqualTo(partyMemberMessage.getParytmemberid());


            partyMemberScoreMapper.updateByExampleSelective(partyMemberScore, partyMemberScoreExample);

        }
        //当修改时 如果所有人都选中了 则重新计算上次所有相关本次会议人员的分数，避免增加人数是 不能重新计算的问题
        if (partyMemberMessageList.size() == 0) {
            for (PartyMemberScoreDetil partyMemberScoreDetil : prtyMemberScoreDetilListParty) {
                List<PartyMemberScorePip> partyMemberScorePipList = partyMemberScorePipMapper.selectAll();
                PartyMemberScoreDetilExample partyMemberScoreDetilExample = new PartyMemberScoreDetilExample();
                partyMemberScoreDetilExample.createCriteria().andYearEqualTo(date).andPartymemberidEqualTo(partyMemberScoreDetil.getPartymemberid());
                List<PartyMemberScoreDetil> prtyMemberScoreDetilList1 = partyMemberScoreDetilMapper.selectByExample(partyMemberScoreDetilExample);
                int i = BaseUtils.getScore(prtyMemberScoreDetilList1, partyMemberScorePipList);
                //计算分数
                PartyMemberScore partyMemberScore = new PartyMemberScore();
                partyMemberScore.setScore(Integer.toString(i));
                PartyMemberScoreExample partyMemberScoreExample = new PartyMemberScoreExample();
                partyMemberScoreExample.createCriteria().andYearEqualTo(date).andPartymemberidEqualTo(partyMemberScoreDetil.getPartymemberid());
                partyMemberScoreMapper.updateByExampleSelective(partyMemberScore, partyMemberScoreExample);

            }


        }


    }

    void delScoreDetail(PartyMeetingVO partyMeetingVO) {

        PartyMemberScoreDetilExample partyMemberScoreDetilExample = new PartyMemberScoreDetilExample();
        partyMemberScoreDetilExample.createCriteria().andRemake1EqualTo(partyMeetingVO.getPartyid());
        partyMemberScoreDetilMapper.deleteByExample(partyMemberScoreDetilExample);
    }

    @Override
    public int saveReacod(PartyRecord record) {

//        PartyRecord record = new PartyRecord();
        record.setRecordid(UUIDUtils.generateUUID());
        record.setPicip(host);
        record.setPicurl("/M00" + record.getPicurl().split("/M00")[1]);
        String userName = (String) SecurityUtils.getSubject().getSession().getAttribute("userName");
        record.setPartymemberid(userName);
        record.setUploadtime(new Date());

        return partyRecordMapper.insert(record);
    }

    @Override
    public List<PartyRecord> selectRecoder(String seachName, String id) {
        List<PartyRecord> list = null;
        if (StringUtils.isEmpty(seachName)) {
            list = partyRecordMapper.selectMesByPartyId(id);
        } else {
            list = partyRecordMapper.selectMesByPartyIdAndName(id, seachName);
        }
        return list;
    }

    @Override
    public int deletePicById(String id) {

        PartyRecord pr = partyRecordMapper.selectByPrimaryKey(id);
        fastDFSUploader.delete("group1", pr.getPicurl());
        partyRecordMapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public List<PartyRecord> selectPartyRecord(String startTime, String endTime, String seachName) {
        if (StringUtils.isEmpty(startTime)) {
            startTime = "2019-01-01";
        }
        if (StringUtils.isEmpty(endTime)) {
            endTime = "2019-12-31";
        }

        if (!StringUtils.isEmpty(seachName)) {
            return partyRecordMapper.selectPartyRecord(startTime, endTime, seachName);
        } else {
            return partyRecordMapper.selectPartyRecordNoName(startTime, endTime);
        }

    }

}
