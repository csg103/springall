package com.csg.cn.business.action.partyMember;

import com.csg.cn.business.service.partyMember.PartyMemberFamilyService;
import com.csg.cn.business.service.partyMember.PartyMemberMessageService;
import com.csg.cn.business.service.partyMember.PartyMemberScoreService;
import com.csg.cn.db.entity.Department;
import com.csg.cn.db.entity.PartyMemberFamily;
import com.csg.cn.db.entity.PartyMemberMessage;
import com.csg.cn.db.entity.PartyMemberScorePip;
import com.csg.cn.db.vo.DeleteMessage;
import com.csg.cn.db.vo.request.ScoreDetailReturnVo;
import com.csg.cn.db.vo.request.ScoreReturnVo;
import com.csg.cn.vo.AjaxResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.util.StringUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Classname PartyMemberScoreAction
 * @Description TODO
 * @Date 2019/5/30 11:08
 * @Created by ${suge.chen}
 */
@Controller
@RequestMapping("/partyMemberScore")
public class PartyMemberScoreAction {

    Logger logger = LoggerFactory.getLogger(partyMemberAction.class);
    @Autowired
    private PartyMemberMessageService partyMemberMessageService;

    @Autowired
    private PartyMemberScoreService partyMemberScoreService;


    @RequestMapping("/list")
    public String list(  Model model) {
        String userName = (String) SecurityUtils.getSubject().getSession().getAttribute("userName");
        String isLeader = (String) SecurityUtils.getSubject().getSession().getAttribute("isLeader");
        String group = (String) SecurityUtils.getSubject().getSession().getAttribute("group");
        model.addAttribute("isLeader", isLeader);
        model.addAttribute("userName", userName);
        model.addAttribute("group", group);
        List<Department> departmentsList =partyMemberMessageService.getAllDepartment();
        model.addAttribute("departmentsList", departmentsList);
        return "partyMemberScore/list";
    }




    @RequestMapping("/data")
    @ResponseBody
    public AjaxResult data(int page, int size, String searchTime,String departmentid) {
        AjaxResult result = new AjaxResult();
        if(StringUtil.isEmpty(searchTime)){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            searchTime=sdf.format(date);
        }
        try {
            PageHelper.startPage(page, size);
            List<ScoreReturnVo> scoreReturnVoList = partyMemberScoreService.selectScoreByTime(searchTime,departmentid);
            PageInfo<ScoreReturnVo> pageInfo = new PageInfo<>(scoreReturnVoList);
            result.setData(pageInfo.getList());
            result.setTotal(pageInfo.getTotal());
            result.setCurrentPage(pageInfo.getPageNum());
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
        } catch (Exception e) {
            logger.error("查询人员列表失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }


    @RequestMapping("/addBaseScore")
    @ResponseBody
    public AjaxResult addScoreBase( String year) {
        AjaxResult result = new AjaxResult();
        try {
            int   i = partyMemberScoreService.addScoreBase(year);

        } catch (Exception e) {
            logger.error("生成基础分数失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        result.setCode(AjaxResult.SUCCESS);
        result.setMessage("success");
        return result;
    }

    @RequestMapping("/detail")
    public String detail( String id, Model model,String year ,String view) {

        String isLeader = (String) SecurityUtils.getSubject().getSession().getAttribute("isLeader");
        model.addAttribute("id", id);
        model.addAttribute("view", view);  model.addAttribute("isLeader", isLeader);


        model.addAttribute("year", year);
        return "partyMemberScore/detail";
    }


    @RequestMapping("/add")
    public String add(@RequestParam String id, Model model) {

        ScoreReturnVo scoreReturnVo = partyMemberScoreService.selectMesById(id);
        List<PartyMemberScorePip> pipList =partyMemberScoreService.getPip();
        List<PartyMemberScorePip> addPip =new ArrayList();
        List<PartyMemberScorePip> subPip =new ArrayList();
        for(PartyMemberScorePip pip:pipList){
        if(StringUtils.equals(pip.getIsadd(),"1")){
            addPip.add(pip);
        }else {
            subPip.add(pip);
        }

        }

        model.addAttribute("scoreReturnVo", scoreReturnVo);
        model.addAttribute("addPip", addPip);

        model.addAttribute("subPip", subPip);
        return "partyMemberScore/add";
    }
    @RequestMapping("/saveDetail")
    @ResponseBody
    public AjaxResult saveDetail( String yearString ,String parytmemberid,String selectId,String remake) {
        parytmemberid =parytmemberid.split(",")[0];
        AjaxResult result = new AjaxResult();

        remake =remake.split(",")[0];



        try {

            int   i = partyMemberScoreService.saveDetailNew(yearString,parytmemberid,selectId,remake);

        } catch (Exception e) {
            logger.error("生成基础分数失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        result.setCode(AjaxResult.SUCCESS);
        result.setMessage("success");
        return result;
    }
    @RequestMapping("/dataDetail")
    @ResponseBody
    public AjaxResult dataDetail(int page, int size, String year, String id) {
        AjaxResult result = new AjaxResult();
        if(StringUtil.isEmpty(year)){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            year=sdf.format(date);
        }
        try {
            PageHelper.startPage(page, size);
            List<ScoreDetailReturnVo> scoreDetailReturnVoList = partyMemberScoreService.selectScoreDetailById(year,id);
            PageInfo<ScoreDetailReturnVo> pageInfo = new PageInfo<>(scoreDetailReturnVoList);
            result.setData(pageInfo.getList());
            result.setTotal(pageInfo.getTotal());
            result.setCurrentPage(pageInfo.getPageNum());
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
        } catch (Exception e) {
            logger.error("查询人员列表失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/deleteScoreDetile")
    @ResponseBody
    public AjaxResult deleteScoreDetile(@RequestBody List<String> ids){
        AjaxResult result = new AjaxResult();
        try{
           partyMemberScoreService.deleteAll(ids);

                result.setMessage("success");
                result.setCode(AjaxResult.SUCCESS);

        }catch (Exception e){
            logger.error("删除分数详情错误", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }


}
