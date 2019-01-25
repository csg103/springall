package com.csg.cn.sys.controller;


import com.csg.cn.db.entity.SysCompany;
import com.csg.cn.db.entity.SysRole;
import com.csg.cn.db.entity.SysUser;
import com.csg.cn.db.vo.SysUpdatePassword;
import com.csg.cn.db.vo.SysUserSimple;
import com.csg.cn.sys.service.SysCompanyService;
import com.csg.cn.sys.service.SysRoleService;
import com.csg.cn.sys.service.SysUserService;
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
 * Created by yangzy on 2018/11/5.
 */
@Controller
@RequestMapping("/user")
public class SysUserController {

    Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysCompanyService sysCompanyService;

    @RequestMapping("/list")
    public String list(){
        return "user/list";
    }

    @RequestMapping("/add")
    public String add(Model model){
        List<SysRole> roles = sysRoleService.selectListByEnabled();
        model.addAttribute("roles", roles);
//        List<FinanceCompany> companys = financeCompanyService.selectListByEnabled();
//        model.addAttribute("companys", companys);
        return "user/add";
    }

    @RequestMapping("/edit")
    public String edit(String id, Model model){
        List<SysRole> roles = sysRoleService.selectListByEnabled();
        model.addAttribute("roles", roles);
        List<SysCompany> companys = sysCompanyService.selectListByEnabled();
        model.addAttribute("companys", companys);
        model.addAttribute("id", id);
        return "user/edit";
    }

    @RequestMapping("/editAjax")
    @ResponseBody
    public AjaxResult editAjax(String id){
        AjaxResult result = new AjaxResult();
        try{
            SysUserSimple sysUserSimple = sysUserService.selectUserInfo(id);
            result.setData(sysUserSimple);
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
        }catch (Exception e){
            logger.error("编辑人员失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/data")
    @ResponseBody
    public AjaxResult data(int page, int size, String searchName){
        AjaxResult result = new AjaxResult();
        try{
            PageHelper.startPage(page, size);
            List<SysUserSimple> sysUserSimples = sysUserService.selectList(searchName);
            PageInfo<SysUserSimple> pageInfo = new PageInfo<SysUserSimple>(sysUserSimples);
            result.setData(pageInfo.getList());
            result.setTotal(pageInfo.getTotal());
            result.setCurrentPage(pageInfo.getPageNum());
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
        }catch (Exception e){
            logger.error("查询人员列表失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/saveAdd")
    @ResponseBody
    public AjaxResult saveAdd(SysUserSimple sysUserSimple, String[] checked){
        AjaxResult result = new AjaxResult();
        try{
            if(sysUserService.saveAdd(sysUserSimple, checked)){
                result.setCode(AjaxResult.SUCCESS);
                result.setMessage("success");
            }else{
                result.setCode(AjaxResult.FAIL);
                result.setMessage("登录名已存在");
            }
        }catch (Exception e){
            logger.error("添加人员失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/saveEdit")
    @ResponseBody
    public AjaxResult saveEdit(SysUserSimple sysUserSimple, String[] checked){
        AjaxResult result = new AjaxResult();
        try{
            if(sysUserService.saveEdit(sysUserSimple, checked)){
                result.setCode(AjaxResult.SUCCESS);
                result.setMessage("success");
            }else{
                result.setCode(AjaxResult.FAIL);
                result.setMessage("登录名已存在");
            }
        }catch (Exception e){
            logger.error("编辑人员失败", e);
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
            sysUserService.delete(id);
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
        }catch (Exception e){
            logger.error("删除人员失败", e);
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
            sysUserService.deleteAll(ids);
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
        }catch (Exception e){
            logger.error("删除人员失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/change")
    public String change(String userId, Model model){
        SysUser sysUser = sysUserService.selectOne(userId);
        model.addAttribute("sysUser", sysUser);
        return "user/change";
    }

    @RequestMapping("/saveChange")
    @ResponseBody
    public AjaxResult saveChange(SysUpdatePassword sysUpdatePassword){
        AjaxResult result = new AjaxResult();
        try{
            if(sysUserService.saveChange(sysUpdatePassword)){
                result.setCode(AjaxResult.SUCCESS);
                result.setMessage("success");
            }else{
                result.setCode(AjaxResult.FAIL);
                result.setMessage("原密码错误");
            }
        }catch (Exception e){
            logger.error("修改密码失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
