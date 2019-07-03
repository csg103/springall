package com.csg.cn.business.action.partyMember;

import com.csg.cn.business.service.partyMember.PartyMemberMeetingService;
import com.csg.cn.db.entity.PartyMemberMessage;
import com.csg.cn.db.entity.PartyRecord;
import com.csg.cn.vo.AjaxResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Classname partyListAction
 * @Description TODO
 * @Date 2019/6/24 9:25
 * @Created by ${suge.chen}
 */
@Controller
@RequestMapping("/partyList")
public class partyListAction {

    @Autowired
    private PartyMemberMeetingService partyMemberMeetingService;
    Logger logger = LoggerFactory.getLogger(partyMemberAction.class);
    @RequestMapping("/list")
    public String list(Model model) {
        String userName = (String) SecurityUtils.getSubject().getSession().getAttribute("userName");
        model.addAttribute("username",userName);
        return "partyList/list";
    }

    @RequestMapping("/data")
    @ResponseBody
    public AjaxResult data(int page,int size ,String starttime, String endtime, String searchName) {
        AjaxResult result = new AjaxResult();

        String isLeader = (String) SecurityUtils.getSubject().getSession().getAttribute("isLeader");
        String group = (String) SecurityUtils.getSubject().getSession().getAttribute("group");
        try {
            PageHelper.startPage(page, size);
            List<PartyRecord> sysUserSimples = partyMemberMeetingService.selectPartyRecord(starttime,endtime,searchName);
            PageInfo<PartyRecord> pageInfo = new PageInfo<>(sysUserSimples);
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


}
