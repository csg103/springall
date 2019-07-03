package com.csg.cn.business.action.partyMember;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.csg.cn.business.service.partyMember.PartyMemberMeetingService;
import com.csg.cn.business.service.partyMember.PartyMemberMessageService;
import com.csg.cn.db.entity.*;
import com.csg.cn.db.vo.request.CheckedMes;
import com.csg.cn.db.vo.request.PartyMeetingVO;
import com.csg.cn.sys.config.FastDFSUploader;
import com.csg.cn.vo.AjaxResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.sun.rowset.internal.Row;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.ArrayUtils;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.util.StringUtil;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @Classname partyMemberMeetingAction
 * @Description TODO
 * @Date 2019/6/11 11:41
 * @Created by ${suge.chen}
 */
@Controller
@RequestMapping("/party")
public class partyMemberMeetingAction {
    Logger logger = LoggerFactory.getLogger(partyMemberAction.class);
    @Autowired
    PartyMemberMeetingService partyMemberMeetingService;
    @Autowired
    PartyMemberMessageService partyMemberMessageService;
    @Autowired
    private FastDFSUploader fastDFSUploader;
    @Value("${fdfs.host}")
    private String host;
    @RequestMapping("/meeting")
    public String list(Model model) {

        String isLeader = (String) SecurityUtils.getSubject().getSession().getAttribute("isLeader");
        model.addAttribute("isLeader", isLeader);
        return "party/list";
    }

    @RequestMapping("/editPartyMes")
    @ResponseBody
    public AjaxResult editPartyMes(PartyMeetingVO partyMeetingVO) {

        AjaxResult result = new AjaxResult();
        try {
            int i = partyMemberMeetingService.updateById(partyMeetingVO);

        } catch (Exception e) {
            logger.error("生成会议成功", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        result.setCode(AjaxResult.SUCCESS);
        result.setMessage("success");
        return result;
    }


    @RequestMapping("/add")
    public String add(Model model) {
        String str = "01";
        List<Common> list = partyMemberMeetingService.selectType(str);
        model.addAttribute("listType", list);
        List<List<PartyMemberMessage>> partyMemberMessageList = partyMemberMessageService.getAllPartyMemberMessage();


//        model.addAttribute("listMember1", partyMemberMessageMap.get(0));
//        model.addAttribute("listMember2", partyMemberMessageMap.get("2"));
//        model.addAttribute("listMember3", partyMemberMessageMap.get("3"));
        model.addAttribute("listMember", partyMemberMessageList);
        List<Common> groupList = partyMemberMeetingService.selectType("02");
        model.addAttribute("groupList", groupList);


        return "party/add";
    }


    @RequestMapping("/saveAdd")
    @ResponseBody
    public AjaxResult saveAdd(PartyMeetingVO partyMeetingVO) {

        AjaxResult result = new AjaxResult();
        try {
            int i = partyMemberMeetingService.saveAdd(partyMeetingVO);

        } catch (Exception e) {
            logger.error("生成会议成功", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        result.setCode(AjaxResult.SUCCESS);
        result.setMessage("success");
        return result;
    }

    @RequestMapping("/data")
    @ResponseBody
    public AjaxResult data(int page, int size, String partyname) {
        AjaxResult result = new AjaxResult();
        List<Party> partylist = null;
        try {
            PageHelper.startPage(page, size);
            if (StringUtils.isEmpty(partyname))
                partylist = partyMemberMeetingService.selectAll();
            else
                partylist = partyMemberMeetingService.selectByName(partyname);
            PageInfo<Party> pageInfo = new PageInfo<>(partylist);
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

    @RequestMapping("/deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<String> ids) {
        AjaxResult result = new AjaxResult();
        try {
            partyMemberMeetingService.deleteAllById(ids);
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
        } catch (Exception e) {
            logger.error("删除人员失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }


    @RequestMapping("/edit")
    public String edit(@RequestParam String id, Model model) {
        Party party = partyMemberMeetingService.selectById(id);
        String plays = party.getPartyplayers();
        List listPlayers =null;

        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        StringBuffer sb3 = new StringBuffer();
        if (!StringUtils.isEmpty(plays)) {
            Set<String> set = new HashSet();


            String[] strArray = plays.split(",");
            for (String str : strArray) {
                set.add(str.substring(33, str.length()));
            }
            List<String> result = new ArrayList<>(set);
            Collections.sort(result);

            List<String> list = new ArrayList();
            for (String str : result) {


                StringBuffer sb = new StringBuffer();
                for (String strPlay : strArray) {


                    if (StringUtils.equals(str, strPlay.substring(33, strPlay.length()))) {
                        sb.append(strPlay.substring(0, 32)).append(",");

                    }
                }
               String checkedMes = sb.substring(0,sb.length()-1)+"_group"+str;
                list.add(checkedMes);
            }

            listPlayers=list;
            String checkedArry = JSONArray.toJSON(list).toString();

            model.addAttribute("checkedList", checkedArry+",");


            for (String str : strArray) {
                if (StringUtils.equals("1", str.substring(33, str.length())))
                    sb1.append(str.substring(0, 32)).append(",");
                else if (StringUtils.equals("2", str.substring(33, str.length())))
                    sb2.append(str.substring(0, 32)).append(",");
                else if (StringUtils.equals("3", str.substring(33, str.length())))
                    sb3.append(str.substring(0, 32)).append(",");

            }


//            model.addAttribute("isChecked1", sb1.toString().substring(0, sb1.length() - 1));
//            model.addAttribute("isChecked2", sb2.toString().substring(0, sb2.length() - 1));
//            model.addAttribute("isChecked3", sb3.toString().substring(0, sb3.length() - 1));

        }else{
            listPlayers=new ArrayList();
        model.addAttribute("checkedList", "[,,]");
        }
        List<List<PartyMemberMessage>> partyMemberMessageMap = partyMemberMessageService.getAllPartyMemberMessage();
        String isLeader = (String) SecurityUtils.getSubject().getSession().getAttribute("isLeader");
        String group = (String) SecurityUtils.getSubject().getSession().getAttribute("group");

        String array = JSONArray.toJSON(partyMemberMessageMap).toString();
//        model.addAttribute("listMember1", JSONArray.toJSON(partyMemberMessageMap.get("15")).toString());
//        model.addAttribute("listMember2", JSONArray.toJSON(partyMemberMessageMap.get("16")).toString());
//        model.addAttribute("listMember3", JSONArray.toJSON(partyMemberMessageMap.get("3")).toString());
        //查询类型并设置选中状态
        List<Common> list = partyMemberMeetingService.selectType("01");
        String[] arry = party.getType().split(",");
        model.addAttribute("listType", list);
        for (int i = 0; i < list.size(); i++) {
            if (ArrayUtils.contains(arry, list.get(i).getId())) {
                list.get(i).setIsChecked("1");
            }

        }
        List<Common> groupList = partyMemberMeetingService.selectType("02");
        model.addAttribute("groupList", groupList);

        model.addAttribute("listMember", array);
        model.addAttribute("listType", list);
        model.addAttribute("isLeader", isLeader);
        model.addAttribute("group", group);
        model.addAttribute("groupid", party.getRemake1());

        model.addAttribute("party", party);
        model.addAttribute("id", id);
//        model.addAttribute("partyMemberFamilyVoList", partyMemberFamilyVoList);
        return "party/edit";
    }

    @RequestMapping(value = "/uploadPicTab")
    public String uploadPicTab(String id, Model model) {


        model.addAttribute("partyId", id);
        String userName = (String) SecurityUtils.getSubject().getSession().getAttribute("userName");
        model.addAttribute("userName", userName);
        return "party/uploadPic";
    }


    @RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> ramanage(@RequestParam("file") MultipartFile upfile) {


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
        String url = host+ "/"+fastDFSUploader.upload(bytes, originalFileName)[1];
        String fileId = "pic";

        return resultMap("SUCCESS", url, fileSize, fileId, fileName, extension);
    }


    @RequestMapping("/deletePic")
    @ResponseBody
    public AjaxResult deletePic(String id) {
        AjaxResult result = new AjaxResult();
        partyMemberMeetingService.deletePicById(id);

        try {
//            partyMemberMeetingService.deleteAllById(ids);
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
        } catch (Exception e) {
            logger.error("删除人员失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }


    private Map<String, Object> resultMap(String state, String url, long size, String title, String original, String type) {
        Map<String, Object> result = Maps.newHashMap();
        result.put("state", state);
        result.put("original", original);
        result.put("size", size);
        result.put("title", title);
        result.put("type", type);
        result.put("url", url);
        return result;
    }


    @RequestMapping("/saveRecord")
    @ResponseBody
    public AjaxResult saveRecord(PartyRecord partyRecord) {

        AjaxResult result = new AjaxResult();
        try {
            int i = partyMemberMeetingService.saveReacod(partyRecord);

        } catch (Exception e) {
            logger.error("生成会议成功", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        result.setCode(AjaxResult.SUCCESS);
        result.setMessage("success");
        return result;
    }

    @RequestMapping("/picList")
    @ResponseBody
    public AjaxResult picList(int page, int size, String partyname, String partyId) {
        AjaxResult result = new AjaxResult();
        List<PartyRecord> partylist = null;
        try {
            PageHelper.startPage(page, size);

            partylist = partyMemberMeetingService.selectRecoder(partyname, partyId);
            PageInfo<PartyRecord> pageInfo = new PageInfo<>(partylist);
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
