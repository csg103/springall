package com.csg.cn.business.service.partyMember.impl;

import com.baidu.UUIDUtils;
import com.csg.cn.business.service.partyMember.PartyMemberScoreService;
import com.csg.cn.db.dao.PartyMemberMessageMapper;
import com.csg.cn.db.dao.PartyMemberScoreDetilMapper;
import com.csg.cn.db.dao.PartyMemberScoreMapper;
import com.csg.cn.db.dao.PartyMemberScorePipMapper;
import com.csg.cn.db.entity.*;
import com.csg.cn.db.vo.request.AddOrSubScore;
import com.csg.cn.db.vo.request.ScoreDetailReturnVo;
import com.csg.cn.db.vo.request.ScoreReturnVo;
import com.csg.cn.utils.BaseUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Classname PartyMemberScoreImpl
 * @Description TODO
 * @Date 2019/5/30 14:06
 * @Created by ${suge.chen}
 */
@Service
public class PartyMemberScoreImpl implements PartyMemberScoreService {
    @Autowired
    private PartyMemberScoreMapper partyMemberScoreMapper;
    @Autowired
    private PartyMemberMessageMapper partyMemberMessageMapper;
    @Autowired
    private PartyMemberScorePipMapper partyMemberScorePipMapper;

    @Autowired
    private PartyMemberScoreDetilMapper partyMemberScoreDetilMapper;

    @Override
    @Transactional
    public int addScoreBase(String year) {

        PartyMemberScoreExample partyMemberScoreExample = new PartyMemberScoreExample();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = null;
        try {
            date = sdf.parse(year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        partyMemberScoreExample.createCriteria().andYearEqualTo(date);
        List<PartyMemberScore> partyMemberScoreList = partyMemberScoreMapper.selectByExample(partyMemberScoreExample);
        List<String> listId = new ArrayList();
        for (PartyMemberScore partyMemberScore : partyMemberScoreList) {
            listId.add(partyMemberScore.getPartymemberid());
        }

        PartyMemberMessageExample partyMemberMessageExample = new PartyMemberMessageExample();
        partyMemberMessageExample.createCriteria().andIsleaderNotEqualTo("9");
        List<PartyMemberMessage> partyMemberMessageList = partyMemberMessageMapper.selectByExample(partyMemberMessageExample);

        List<PartyMemberScore> partyMemberScorelist = new ArrayList();
        for (PartyMemberMessage partyMemberMessage : partyMemberMessageList) {
            if (!listId.contains(partyMemberMessage.getParytmemberid())) {
                PartyMemberScore partyMemberScore = new PartyMemberScore();
                partyMemberScore.setScore("100");
                partyMemberScore.setPartmemberscoreid(UUIDUtils.generateUUID());
                partyMemberScore.setPartymemberid(partyMemberMessage.getParytmemberid());
                partyMemberScore.setYear(date);
                partyMemberScorelist.add(partyMemberScore);
            }

        }
        if (partyMemberScorelist.size() != 0)
            partyMemberScoreMapper.insertList(partyMemberScorelist);

        return 1;
    }

    @Override
    public List selectScoreByTime(String year,String departmentid) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = null;
        try {
            date = sdf.parse(year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(StringUtils.isEmpty(departmentid))
        return partyMemberScoreMapper.selectScoreByTime(date);
        else
            return  partyMemberScoreMapper.selectScoreByTimeByDepId(date,departmentid);
    }

    @Override
    public ScoreReturnVo selectMesById(String id) {
        List<ScoreReturnVo> scoreReturnVo = partyMemberScoreMapper.selectMesById(id);
        return scoreReturnVo.get(0);
    }

    @Override
    public List<PartyMemberScorePip> getPip() {


        return partyMemberScorePipMapper.selectAll();
    }
    @Override
    @Transactional
    public int saveDetailNew(String yearString, String parytmemberid, String selectId,String remake) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = null;
        try {
            date = sdf.parse(yearString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PartyMemberScoreDetil partyMemberScoreDetil = new PartyMemberScoreDetil();
        partyMemberScoreDetil.setScoredetilid(UUIDUtils.generateUUID());
        partyMemberScoreDetil.setPartymemberid(parytmemberid);
        partyMemberScoreDetil.setPipid(selectId);

        partyMemberScoreDetil.setOperatortime(new Date());
        partyMemberScoreDetil.setOperator((String) SecurityUtils.getSubject().getSession().getAttribute("userName"));
        try {
            partyMemberScoreDetil.setYear(sdf.parse(yearString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        partyMemberScoreDetilMapper.insert(partyMemberScoreDetil);

        //查询评分标准
        PartyMemberScorePip partyMemberScorePip = partyMemberScorePipMapper.selectByPrimaryKey(selectId);
        //查询当前人当前年度 当前项目是否有分数值 如果有分数则在所能扣除的最大分数内扣除 超过的则按最大分数处理  如果没有则新增
            List<PartyMemberScorePip> partyMemberScorePipList = partyMemberScorePipMapper.selectAll();

        PartyMemberScoreDetilExample partyMemberScoreDetilExample1 = new PartyMemberScoreDetilExample();
        partyMemberScoreDetilExample1.createCriteria().andYearEqualTo(date).andPartymemberidEqualTo(parytmemberid);
        List<PartyMemberScoreDetil> prtyMemberScoreDetilList1 = partyMemberScoreDetilMapper.selectByExample(partyMemberScoreDetilExample1);

        int i = BaseUtils.getScore(prtyMemberScoreDetilList1, partyMemberScorePipList);
        PartyMemberScore partyMemberScore =new PartyMemberScore();
        partyMemberScore.setScore(Integer.toString(i));
        PartyMemberScoreExample partyMemberScoreExample =new PartyMemberScoreExample();
        partyMemberScoreExample.createCriteria().andYearEqualTo(date).andPartymemberidEqualTo(parytmemberid);


        partyMemberScoreMapper.updateByExampleSelective(partyMemberScore,partyMemberScoreExample);
        return 1;
    }

    @Override
    @Transactional
    public int saveDetail(String yearString, String parytmemberid, String selectId,String remake) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = null;
        try {
            date = sdf.parse(yearString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //查询评分标准
        PartyMemberScorePip partyMemberScorePip = partyMemberScorePipMapper.selectByPrimaryKey(selectId);
        //查询当前人当前年度 当前项目是否有分数值 如果有分数则在所能扣除的最大分数内扣除 超过的则按最大分数处理  如果没有则新增
        PartyMemberScoreDetilExample partyMemberScoreDetilExample = new PartyMemberScoreDetilExample();
        partyMemberScoreDetilExample.createCriteria().andYearEqualTo(date).andPartymemberidEqualTo(parytmemberid).andPipidEqualTo(selectId);
        List<PartyMemberScoreDetil> prtyMemberScoreDetilList = partyMemberScoreDetilMapper.selectByExample(partyMemberScoreDetilExample);
       List<PartyMemberScorePip> partyMemberScorePipList =  partyMemberScorePipMapper.selectAll();

        PartyMemberScoreDetilExample partyMemberScoreDetilExample1 = new PartyMemberScoreDetilExample();
        partyMemberScoreDetilExample1.createCriteria().andYearEqualTo(date).andPartymemberidEqualTo(parytmemberid);
        List<PartyMemberScoreDetil> prtyMemberScoreDetilList1 = partyMemberScoreDetilMapper.selectByExample(partyMemberScoreDetilExample1);

        int i = BaseUtils.getScore(prtyMemberScoreDetilList1,partyMemberScorePipList);

        String num = "0";
        String scoreMaq = "0";
        //remake1 为得分次数 remake2 为当前人 当前年度 当前选择条件 的总得分 总得分不超过PIP表的score
        if (prtyMemberScoreDetilList.size() != 0) {
            if (!StringUtils.isEmpty(prtyMemberScoreDetilList.get(0).getRemake1())) {
                num = prtyMemberScoreDetilList.get(0).getRemake1();
            }

            if ((Integer.valueOf(num) + 1) * Integer.valueOf(partyMemberScorePip.getRemake1()) > Integer.valueOf(partyMemberScorePip.getScore())) {
                num = StringUtils.toString(Integer.valueOf(num) + 1);
                scoreMaq = partyMemberScorePip.getScore();
            } else {
                num = StringUtils.toString(Integer.valueOf(num) + 1);
                scoreMaq =StringUtils.toString(Integer.valueOf(prtyMemberScoreDetilList.get(0).getRemake2()) + Integer.valueOf(partyMemberScorePip.getRemake1()));
            }

            PartyMemberScoreDetil PartyMemberScoreDetilNew = prtyMemberScoreDetilList.get(0);
            PartyMemberScoreDetilNew.setRemake1(num);
            PartyMemberScoreDetilNew.setRemake2(scoreMaq);
            partyMemberScoreDetilMapper.updateByPrimaryKeySelective(PartyMemberScoreDetilNew);

        } else {
            PartyMemberScoreDetil partyMemberScoreDetil = new PartyMemberScoreDetil();
            partyMemberScoreDetil.setScoredetilid(UUIDUtils.generateUUID());
            partyMemberScoreDetil.setPartymemberid(parytmemberid);
            partyMemberScoreDetil.setPipid(selectId);
            partyMemberScoreDetil.setRemake1("1");
            partyMemberScoreDetil.setRemake2(partyMemberScorePip.getRemake1());
            partyMemberScoreDetil.setOperatortime(new Date());
            partyMemberScoreDetil.setOperator((String) SecurityUtils.getSubject().getSession().getAttribute("userName"));
            try {
                partyMemberScoreDetil.setYear(sdf.parse(yearString));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            partyMemberScoreDetilMapper.insert(partyMemberScoreDetil);

        }
        Date date1 = null;
        //根据detil表额总扣分数算出现在得分数 更新 score表
        try {
            date1 = sdf.parse(yearString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<AddOrSubScore> addOrSubScoreList = partyMemberScoreDetilMapper.selectNowScoreDetil(date1, parytmemberid);
        int score = 100;
        for (AddOrSubScore addOrSubScore : addOrSubScoreList) {
            if (addOrSubScore.getIsAdd().equals("1")) {
                score = score + Integer.valueOf(addOrSubScore.getScore());
            } else {
                score = score - Integer.valueOf(addOrSubScore.getScore());
            }
        }


        PartyMemberScoreExample partyMemberScoreExample = new PartyMemberScoreExample();
        partyMemberScoreExample.createCriteria().andYearEqualTo(date).andPartymemberidEqualTo(parytmemberid);
        List<PartyMemberScore> prtyMemberScoreList = partyMemberScoreMapper.selectByExample(partyMemberScoreExample);
        PartyMemberScore partyMemberScore = prtyMemberScoreList.get(0);
        partyMemberScore.setScore(Integer.toString(score));
        partyMemberScoreMapper.updateByExampleSelective(partyMemberScore,partyMemberScoreExample);

partyMemberMessageMapper.updateRemake2ById(parytmemberid,remake);
        return 0;
    }


//    @Transactional
//    public int saveDetail1(String yearString, String parytmemberid, String selectId) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
//        Date date = null;
//        try {
//            date = sdf.parse(yearString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        //查询评分标准
//        PartyMemberScorePip partyMemberScorePip = partyMemberScorePipMapper.selectByPrimaryKey(selectId);
//        //查询当前人当前年度 当前项目是否有分数值 如果有分数则在所能扣除的最大分数内扣除 超过的则按最大分数处理  如果没有则新增
//        PartyMemberScoreDetilExample partyMemberScoreDetilExample = new PartyMemberScoreDetilExample();
//        partyMemberScoreDetilExample.createCriteria().andYearEqualTo(date).andPartymemberidEqualTo(parytmemberid).andPipidEqualTo(selectId);
//        List<PartyMemberScoreDetil> prtyMemberScoreDetilList = partyMemberScoreDetilMapper.selectByExample(partyMemberScoreDetilExample);
//        String num = "0";
//        String scoreMaq = "0";
//        //remake1 为得分次数 remake2 为当前人 当前年度 当前选择条件 的总得分 总得分不超过PIP表的score
//        if (prtyMemberScoreDetilList.size() != 0) {
//            if (!StringUtils.isEmpty(prtyMemberScoreDetilList.get(0).getRemake1())) {
//                num = prtyMemberScoreDetilList.get(0).getRemake1();
//            }
//
//            if ((Integer.valueOf(num) + 1) * Integer.valueOf(partyMemberScorePip.getRemake1()) > Integer.valueOf(partyMemberScorePip.getScore())) {
//                num = StringUtils.toString(Integer.valueOf(num) + 1);
//                scoreMaq = partyMemberScorePip.getScore();
//            } else {
//                num = StringUtils.toString(Integer.valueOf(num) + 1);
//                scoreMaq =StringUtils.toString(Integer.valueOf(prtyMemberScoreDetilList.get(0).getRemake2()) + Integer.valueOf(partyMemberScorePip.getRemake1()));
//            }
//
//            PartyMemberScoreDetil PartyMemberScoreDetilNew = prtyMemberScoreDetilList.get(0);
//            PartyMemberScoreDetilNew.setRemake1(num);
//            PartyMemberScoreDetilNew.setRemake2(scoreMaq);
//            partyMemberScoreDetilMapper.updateByPrimaryKeySelective(PartyMemberScoreDetilNew);
//
//        } else {
//            PartyMemberScoreDetil partyMemberScoreDetil = new PartyMemberScoreDetil();
//            partyMemberScoreDetil.setScoredetilid(UUIDUtils.generateUUID());
//            partyMemberScoreDetil.setPartymemberid(parytmemberid);
//            partyMemberScoreDetil.setPipid(selectId);
//            partyMemberScoreDetil.setRemake1("1");
//            partyMemberScoreDetil.setRemake2(partyMemberScorePip.getRemake1());
//            partyMemberScoreDetil.setOperatortime(new Date());
//            partyMemberScoreDetil.setOperator((String) SecurityUtils.getSubject().getSession().getAttribute("userName"));
//            try {
//                partyMemberScoreDetil.setYear(sdf.parse(yearString));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            partyMemberScoreDetilMapper.insert(partyMemberScoreDetil);
//
//        }
//        Date date1 = null;
//        //根据detil表额总扣分数算出现在得分数 更新 score表
//        try {
//            date1 = sdf.parse(yearString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        List<AddOrSubScore> addOrSubScoreList = partyMemberScoreDetilMapper.selectNowScoreDetil(date1, parytmemberid);
//        int score = 100;
//        for (AddOrSubScore addOrSubScore : addOrSubScoreList) {
//            if (addOrSubScore.getIsAdd().equals("1")) {
//                score = score + Integer.valueOf(addOrSubScore.getScore());
//            } else {
//                score = score - Integer.valueOf(addOrSubScore.getScore());
//            }
//        }
//
//
//        PartyMemberScoreExample partyMemberScoreExample = new PartyMemberScoreExample();
//        partyMemberScoreExample.createCriteria().andYearEqualTo(date).andPartymemberidEqualTo(parytmemberid);
//        List<PartyMemberScore> prtyMemberScoreList = partyMemberScoreMapper.selectByExample(partyMemberScoreExample);
//        PartyMemberScore partyMemberScore = prtyMemberScoreList.get(0);
//        partyMemberScore.setScore(Integer.toString(score));
//
//
//        partyMemberScoreMapper.updateByExampleSelective(partyMemberScore,partyMemberScoreExample);
//
//        return 0;
//    }

     public List<ScoreDetailReturnVo>  selectScoreDetailById(String year, String id){
         return partyMemberScoreDetilMapper.selectScoreDetailById(year,id);
    }

    @Override
    public void deleteAll(List<String> ids) {
        PartyMemberScoreDetilExample partyMemberScoreDetilExample;
        Date date = null;
        String parytmemberid=null;
        for(String id : ids){
            PartyMemberScoreDetil partyMemberScoreDetil=    partyMemberScoreDetilMapper.selectByPrimaryKey(id);
            date=partyMemberScoreDetil.getYear();
            parytmemberid=partyMemberScoreDetil.getPartymemberid();
            partyMemberScoreDetilExample = new PartyMemberScoreDetilExample();
            partyMemberScoreDetilExample.createCriteria().andScoredetilidEqualTo(id);
            partyMemberScoreDetilMapper.deleteByExample(partyMemberScoreDetilExample);

            partyMemberScoreDetilMapper.deleteByPrimaryKey(id);
        }


        //查询当前人当前年度 当前项目是否有分数值 如果有分数则在所能扣除的最大分数内扣除 超过的则按最大分数处理  如果没有则新增
        List<PartyMemberScorePip> partyMemberScorePipList = partyMemberScorePipMapper.selectAll();

        PartyMemberScoreDetilExample partyMemberScoreDetilExample1 = new PartyMemberScoreDetilExample();
        partyMemberScoreDetilExample1.createCriteria().andYearEqualTo(date).andPartymemberidEqualTo(parytmemberid);
        List<PartyMemberScoreDetil> prtyMemberScoreDetilList1 = partyMemberScoreDetilMapper.selectByExample(partyMemberScoreDetilExample1);

        int i = BaseUtils.getScore(prtyMemberScoreDetilList1, partyMemberScorePipList);
        PartyMemberScore partyMemberScore =new PartyMemberScore();
        partyMemberScore.setScore(Integer.toString(i));
        PartyMemberScoreExample partyMemberScoreExample =new PartyMemberScoreExample();
        partyMemberScoreExample.createCriteria().andYearEqualTo(date).andPartymemberidEqualTo(parytmemberid);


        partyMemberScoreMapper.updateByExampleSelective(partyMemberScore,partyMemberScoreExample);

    }
}
