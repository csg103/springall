package com.csg.cn.sys.control;

import com.csg.cn.db.entity.SysUser;
import com.csg.cn.db.entity.SysUserRole;
import com.csg.cn.sys.config.FastDFSUploader;
import com.csg.cn.sys.service.SysRoleService;
import com.csg.cn.sys.service.SysUserService;
import com.csg.cn.vo.AjaxResult;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author yichen
 * @description
 * @date 2018/5/19
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private FastDFSUploader fastDFSUploader;

    @RequestMapping("/list")
    public String list() throws IOException {
        return "sys/list";
    }

    @RequestMapping("add")
    public String add(){
        return "sys/add";
    }

    @RequestMapping("edit")
    public String edit(String id, Model model){
        SysUser user = sysUserService.selectById(id);
        SysUserRole userRole = sysRoleService.selectByUserId(id);
        model.addAttribute("user",user);
        model.addAttribute("role", userRole);
        return "sys/edit";
    }

    @RequestMapping("/listAjax")
    @ResponseBody
    public AjaxResult listAjax(int size, int index){
        PageInfo<SysUser> pageInfo = sysUserService.listAjax(index, size);

        AjaxResult result = new AjaxResult();
        result.setCode(AjaxResult.SUCCESS);
        result.setMessage("success");
        result.setData(pageInfo.getList());
        result.setTotal(pageInfo.getTotal());
        result.setCurrentPage(pageInfo.getPageNum());
        return result;
    }

    @RequestMapping("saveAdd")
    @ResponseBody
    public AjaxResult saveAdd(SysUser sysUser, String roleId){
        AjaxResult result = new AjaxResult();
        try {
            if (sysUserService.saveAdd(sysUser, roleId)){
                result.setCode(AjaxResult.SUCCESS);
            }else {
                result.setCode(AjaxResult.FAIL);
                result.setMessage("用户名重复！");
            }
        }catch (Exception e){
            result.setCode(AjaxResult.FAIL);
            result.setMessage("保存异常");
            logger.error("保存异常", e);
        }
        return result;
    }

    @RequestMapping("saveEdit")
    @ResponseBody
    public AjaxResult saveEdit(SysUser sysUser, String roleId){
        AjaxResult result = new AjaxResult();
        try {
            if (sysUserService.saveEdit(sysUser, roleId)){
                result.setCode(AjaxResult.SUCCESS);
            }else {
                result.setCode(AjaxResult.FAIL);
                result.setMessage("用户名重复！");
            }
        }catch (Exception e){
            result.setCode(AjaxResult.FAIL);
            result.setMessage("保存异常");
            logger.error("保存异常", e);
        }
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    public AjaxResult delete(String id){
        AjaxResult result = new AjaxResult();
        try {
            sysUserService.delete(id);
            result.setCode(AjaxResult.SUCCESS);
        }catch (Exception e){
            result.setCode(AjaxResult.FAIL);
            result.setMessage("删除异常");
            logger.error("删除异常", e);
        }
        return result;
    }



}
