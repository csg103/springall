package com.csg.cn.business.action.partyMember;

import com.csg.cn.business.service.partyMember.AppendixService;
import com.csg.cn.business.service.partyMember.PartyMemberMeetingService;
import com.csg.cn.db.entity.Appendix;
import com.csg.cn.db.entity.Common;
import com.csg.cn.db.entity.PartyRecord;
import com.csg.cn.sys.config.FastDFSUploader;
import com.csg.cn.vo.AjaxResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import net.sf.json.JSONArray;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Classname appendixAction
 * @Description TODO
 * @Date 2019/6/24 9:25
 * @Created by ${suge.chen}
 */
@Controller
@RequestMapping("/appendix")
public class appendixAction {
    @Value("${fdfs.host}")
    private String host;
    @Autowired
    private PartyMemberMeetingService partyMemberMeetingService;
    @Autowired
    private AppendixService appendixService;
    @Autowired
    private FastDFSUploader fastDFSUploader;

    Logger logger = LoggerFactory.getLogger(partyMemberAction.class);

    @RequestMapping("/list")
    public String list(Model model) {
        String userName = (String) SecurityUtils.getSubject().getSession().getAttribute("userName");
        List<Common> typeList = partyMemberMeetingService.selectType("03");
        model.addAttribute("typeList", typeList);
        model.addAttribute("username", userName);
        return "appendix/list";
    }

    @RequestMapping("/data")
    @ResponseBody
    public AjaxResult data(int page, int size, String starttime, String endtime, String parytmemberid ,String type) {
        AjaxResult result = new AjaxResult();

        String isLeader = (String) SecurityUtils.getSubject().getSession().getAttribute("isLeader");
        String group = (String) SecurityUtils.getSubject().getSession().getAttribute("group");
        try {
            PageHelper.startPage(page, size);
            List<Appendix> appendixList = appendixService.selectAppendixList(starttime, endtime, parytmemberid,type);
            PageInfo<Appendix> pageInfo = new PageInfo<>(appendixList);
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
    @RequestMapping("/add")
    public String add(Model model) {
        String userName = (String) SecurityUtils.getSubject().getSession().getAttribute("userName");
        List<Common> typeList = partyMemberMeetingService.selectType("03");
        model.addAttribute("typeList", typeList);
        model.addAttribute("username", userName);
        return "appendix/add";
    }

    @RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> ramanage(@RequestParam("file") MultipartFile upfile) {

//Appendix appendix =new Appendix();
        byte[] bytes = new byte[0];
        try {
            bytes = upfile.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String originalFileName = upfile.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileName = upfile.getName();
        long fileSize = upfile.getSize();
        String url =host + fastDFSUploader.upload(bytes, originalFileName)[1];
        String fileId = "pic";
        logger.debug(url);
//        appendix.setAppendname(fileName);
//        appendix.setRemake1(Long.toString(fileSize));
//        appendix.set
//        int saveAppendix()
        return resultMap("SUCCESS", url, fileSize, fileId, fileName, extension);
    }

    private Map<String, Object> resultMap(String state, String url, long size, String title, String original, String type) {
        Map<String, Object> result = Maps.newHashMap();
        result.put("code","0");
        result.put("original", original);
        result.put("size", size);
        result.put("title", title);
        result.put("type", type);
        result.put("url", url);
        return result;
    }


    @RequestMapping("/saveAdd")
    @ResponseBody
    public AjaxResult saveAdd(@RequestParam String Mes) {
        AjaxResult result = new AjaxResult();
        List<Appendix> list=(List<Appendix>)JSONArray.toList(JSONArray.fromObject(Mes), Appendix.class);

        String isLeader = (String) SecurityUtils.getSubject().getSession().getAttribute("isLeader");
        String group = (String) SecurityUtils.getSubject().getSession().getAttribute("group");
        try {

        int i = appendixService.saveAppendixList(list);


            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
        } catch (Exception e) {
            logger.error("查询人员列表失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<String> ids) {
        AjaxResult result = new AjaxResult();
        try {
            appendixService.deleteAllById(ids);
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
        } catch (Exception e) {
            logger.error("删除人员失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }



}
