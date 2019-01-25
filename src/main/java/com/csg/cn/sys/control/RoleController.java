package com.csg.cn.sys.control;

import com.csg.cn.db.entity.SysRole;
import com.csg.cn.sys.service.SysRoleService;
import com.csg.cn.vo.AjaxResult;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yichen
 * @description
 * @date 2018/5/27
 **/
@Controller
@RequestMapping("role")
public class RoleController {

    private static final Logger logger = Logger.getLogger(RoleController.class);

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("list")
    public String list(){
        return "role/list";
    }

    @RequestMapping("add")
    public String add(){
        return "role/add";
    }

    @RequestMapping("edit")
    public String edit(Model model, String roleId){
        SysRole role = sysRoleService.selectById(roleId);
        model.addAttribute("role", role);
        return "role/edit";
    }

    @RequestMapping("listAjax")
    @ResponseBody
    public AjaxResult listAjax(int index, int size){
        AjaxResult result = new AjaxResult();
        try {
            PageInfo<SysRole> pageInfo = sysRoleService.listAjax(index, size);
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
            result.setData(pageInfo.getList());
            result.setTotal(pageInfo.getTotal());
            result.setCurrentPage(pageInfo.getPageNum());
        }catch (Exception e){
            result.setCode(AjaxResult.FAIL);
            result.setMessage("查询异常");
            logger.error("查询异常",e);
        }
        return result;
    }

    @RequestMapping("saveAdd")
    @ResponseBody
    public AjaxResult saveAdd(SysRole sysRole, String[] checked){
        AjaxResult result = new AjaxResult();
        try {
            if (sysRoleService.saveAdd(sysRole, checked)){
                result.setCode(AjaxResult.SUCCESS);
            }else {
                result.setCode(AjaxResult.FAIL);
                result.setMessage("请勿提交同名角色");
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
    public AjaxResult saveEdit(SysRole sysRole, String[] checked){
        AjaxResult result = new AjaxResult();
        try {
            if (sysRoleService.saveEdit(sysRole, checked)){
                result.setCode(AjaxResult.SUCCESS);
            }else {
                result.setCode(AjaxResult.FAIL);
                result.setMessage("请勿提交同名角色");
            }
        }catch (Exception e){
            result.setCode(AjaxResult.FAIL);
            result.setMessage("更新异常");
            logger.error("更新异常", e);
        }
        return result;

    }

    @RequestMapping("delete")
    @ResponseBody
    public AjaxResult delete(String id){
        AjaxResult result = new AjaxResult();
        try {
            sysRoleService.delete(id);
            result.setCode(AjaxResult.SUCCESS);
        }catch (Exception e){
            result.setCode(AjaxResult.FAIL);
            result.setMessage("删除异常");
            logger.error("删除异常", e);
        }
        return result;
    }

    @RequestMapping("allRoles")
    @ResponseBody
    public AjaxResult selectAll(){
        AjaxResult result = new AjaxResult();
        try {
            result.setData(sysRoleService.allRoles());
            result.setCode(AjaxResult.SUCCESS);
        }catch (Exception e){
            result.setCode(AjaxResult.FAIL);
            result.setMessage("查询异常");
            logger.error("查询异常", e);
        }
        return result;
    }

}
