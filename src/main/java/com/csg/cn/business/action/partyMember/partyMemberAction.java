package com.csg.cn.business.action.partyMember;

import com.csg.cn.business.service.partyMember.PartyMemberFamilyService;
import com.csg.cn.business.service.partyMember.PartyMemberMessageService;
import com.csg.cn.db.entity.PartyMemberFamily;
import com.csg.cn.db.entity.PartyMemberMessage;
import com.csg.cn.db.vo.request.PartyMemberMessageVo;
import com.csg.cn.sys.service.SysAuthService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * @Classname welcomeAction
 * @Description TODO
 * @Date 2019/5/27 9:29
 * @Created by ${suge.chen}
 */
@Controller
@RequestMapping("/partyMember")
public class partyMemberAction {
    Logger logger = LoggerFactory.getLogger(partyMemberAction.class);

    @Autowired
    private PartyMemberMessageService partyMemberMessageService;
    @Autowired
    private PartyMemberFamilyService partyMemberFamilyService;

    @Autowired
    private SysAuthService sysAuthService;

    @RequestMapping("/list")
    public String list() {
        return "partyMember/list";
    }

    @RequestMapping("/data")
    @ResponseBody
    public AjaxResult data(int page, int size, String searchName) {
        AjaxResult result = new AjaxResult();
        String userName = (String) SecurityUtils.getSubject().getSession().getAttribute("userName");
        String isLeader = (String) SecurityUtils.getSubject().getSession().getAttribute("isLeader");
        String group = (String) SecurityUtils.getSubject().getSession().getAttribute("group");
        try {
            PageHelper.startPage(page, size);
//            List<PartyMemberMessage> sysUserSimples = partyMemberMessageService.data(currentUserId);
            List<PartyMemberMessage> sysUserSimples = partyMemberMessageService.selectAll(userName, isLeader, group);
            PageInfo<PartyMemberMessage> pageInfo = new PageInfo<>(sysUserSimples);
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


    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(String id) {
        AjaxResult result = new AjaxResult();
        try {
//            partyMemberMessageService.deleteByID(id);
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
        } catch (Exception e) {
            logger.error("删除人员失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }


    @RequestMapping("/saveAdd")
    @ResponseBody
    public AjaxResult saveAdd(PartyMemberMessageVo partyMemberMessageVo) {
        AjaxResult result = new AjaxResult();
        try {
            partyMemberMessageService.saveMes(partyMemberMessageVo);
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
        } catch (Exception e) {
            logger.error("删除人员失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }


    @RequestMapping("/add")
    public String add() {
        return "partyMember/add";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam String id, Model model) {

        PartyMemberMessage partyMemberMessage = partyMemberMessageService.selectPartyMemberByID(id);
        List<PartyMemberFamily> partyMemberFamilyVoList = partyMemberFamilyService.getFamilyMes(id);

        if (partyMemberFamilyVoList.size() == 0) {
            PartyMemberFamily partyMemberFamily = new PartyMemberFamily();
            partyMemberFamily.setRelation("父亲");
            PartyMemberFamily partyMemberFamily1 = new PartyMemberFamily();
            partyMemberFamily1.setRelation("母亲");
            partyMemberFamilyVoList.add(partyMemberFamily);
            partyMemberFamilyVoList.add(partyMemberFamily1);

        }
        if (partyMemberFamilyVoList.size() < 5) {
            int j = partyMemberFamilyVoList.size();
            for (int i = 0; i < 5 - j; i++) {
                PartyMemberFamily partyMemberFamily = new PartyMemberFamily();
                partyMemberFamilyVoList.add(partyMemberFamily);

            }
        }

        if (StringUtil.isEmpty(partyMemberMessage.getSex())) {
            partyMemberMessage.setSex("1");
        }

        if (StringUtil.isEmpty(partyMemberMessage.getMarry())) {
            partyMemberMessage.setMarry("1");
        }

        model.addAttribute("partyMemberMessage", partyMemberMessage);
        model.addAttribute("partyMemberFamilyVoList", partyMemberFamilyVoList);
        return "partyMember/edit";
    }
}

