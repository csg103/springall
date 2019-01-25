package com.csg.cn.sys.controller;

import com.csg.cn.db.entity.SysCompany;
import com.csg.cn.db.vo.DeleteMessage;
import com.csg.cn.sys.service.SysCompanyService;
import com.csg.cn.vo.AjaxResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yangzy on 2018/11/7.
 */
@Controller
@RequestMapping("/company")
public class SysCompanyController {

    Logger logger = LoggerFactory.getLogger(SysCompanyController.class);

    @Autowired
    private SysCompanyService sysCompanyService;

    @RequestMapping("/list")
    public String list(){
        return "company/list";
    }

    @RequestMapping("/data")
    @ResponseBody
    public AjaxResult data(int page, int size, String searchName){
        AjaxResult result = new AjaxResult();
        try{
            PageHelper.startPage(page, size);
            List<SysCompany> financeCompanies = sysCompanyService.selectList(searchName);
            PageInfo<SysCompany> pageInfo = new PageInfo<SysCompany>(financeCompanies);
            result.setData(pageInfo.getList());
            result.setTotal(pageInfo.getTotal());
            result.setCurrentPage(pageInfo.getPageNum());
            result.setMessage("success");
            result.setCode(AjaxResult.SUCCESS);
        }catch (Exception e){
            logger.error("查询公司错误", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/add")
    public String add(){
        return "company/add";
    }

    @RequestMapping("/edit")
    public String edit(String id, Model model){
        SysCompany sysCompany = sysCompanyService.edit(id);
        model.addAttribute("sysCompany", sysCompany);
        return "company/edit";
    }

    @RequestMapping("/saveAdd")
    @ResponseBody
    public AjaxResult saveAdd(SysCompany sysCompany){
        AjaxResult result = new AjaxResult();
        try{
            sysCompanyService.saveAdd(sysCompany);
            result.setMessage("success");
            result.setCode(AjaxResult.SUCCESS);
        }catch (Exception e){
            logger.error("添加公司错误", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/saveEdit")
    @ResponseBody
    public AjaxResult saveEdit(SysCompany sysCompany){
        AjaxResult result = new AjaxResult();
        try{
            if(sysCompanyService.saveEdit(sysCompany)){
                result.setMessage("success");
                result.setCode(AjaxResult.SUCCESS);
            }else{
                result.setCode(AjaxResult.FAIL);
                result.setMessage("公司已存在");
            }
        }catch (Exception e){
            logger.error("编辑公司错误", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(String id){
        AjaxResult result = new AjaxResult();
        try{
            if(sysCompanyService.delete(id)){
                result.setMessage("success");
                result.setCode(AjaxResult.SUCCESS);
            }else{
                result.setMessage("请先删除或修改该公司下的人员");
                result.setCode(AjaxResult.FAIL);
            }
        }catch (Exception e){
            logger.error("删除公司错误", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<String> ids){
        AjaxResult result = new AjaxResult();
        try{
            DeleteMessage deleteMessage = sysCompanyService.deleteAll(ids);
            if(deleteMessage.isResult()){
                result.setMessage("success");
                result.setCode(AjaxResult.SUCCESS);
            }else{
                result.setMessage("请先删除或修改<span style=\"color: #FF5722; font-size: 16px;\">"+deleteMessage.getName()+"</span>的人员");
                result.setCode(AjaxResult.FAIL);
            }
        }catch (Exception e){
            logger.error("删除公司错误", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
