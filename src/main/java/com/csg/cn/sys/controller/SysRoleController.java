package com.csg.cn.sys.controller;

import com.csg.cn.db.entity.SysRole;
import com.csg.cn.sys.service.SysRoleService;
import com.csg.cn.vo.AjaxResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yangzy on 2018/11/5.
 */
@Controller
@RequestMapping("/role")
public class SysRoleController {

    Logger logger = LoggerFactory.getLogger(SysRoleController.class);

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("/list")
    public String list(){
        return "role/list";
    }

    @RequestMapping("/add")
    public String add(){
        return "role/add";
    }

    @RequestMapping("/edit")
    public String edit(String id, Model model){
        SysRole sysRole = sysRoleService.selectOne(id);
        model.addAttribute("sysRole", sysRole);
        return "role/edit";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(String id){
        AjaxResult result = new AjaxResult();
        try{
            sysRoleService.delete(id);
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
        }catch (Exception e){
            logger.error("删除角色失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage("fail");
        }
        return result;
    }

    @RequestMapping("/saveAdd")
    @ResponseBody
    public AjaxResult saveAdd(SysRole sysRole, String[] checked){
        AjaxResult result = new AjaxResult();
        try {
            if(sysRoleService.saveAdd(sysRole, checked)){
                result.setCode(AjaxResult.SUCCESS);
                result.setMessage("success");
            }else{
                result.setCode(AjaxResult.FAIL);
                result.setMessage("角色名已存在");
            }
        }catch (Exception e){
            logger.error("添加角色失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage("fail");
        }
        return result;
    }

    @RequestMapping("/saveEdit")
    @ResponseBody
    public AjaxResult saveEdit(SysRole sysRole, String[] checked){
        AjaxResult result = new AjaxResult();
        try{
            if(sysRoleService.saveEdit(sysRole, checked)){
                result.setCode(AjaxResult.SUCCESS);
                result.setMessage("success");
            }else{
                result.setCode(AjaxResult.FAIL);
                result.setMessage("角色名已存在");
            }
        }catch (Exception e){
            logger.error("编辑角色失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage("fail");
        }
        return result;
    }

    @RequestMapping("/data")
    @ResponseBody
    public AjaxResult data(int page, int size){
        AjaxResult result = new AjaxResult();
        try{
            PageHelper.startPage(page, size);
            List<SysRole> financeRoles = sysRoleService.selectAll();
            PageInfo<SysRole> pageInfo = new PageInfo<SysRole>(financeRoles);
            result.setData(pageInfo.getList());
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
        }catch (Exception e){
            logger.error("查询角色失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage("fail");
        }
        return result;
    }
}
