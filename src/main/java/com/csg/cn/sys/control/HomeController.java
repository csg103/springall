package com.csg.cn.sys.control;


import com.csg.cn.db.entity.SysUser;
import com.csg.cn.sys.service.SysPermissionService;
import com.csg.cn.vo.AjaxResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * @description
 * @date
 **/
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @RequestMapping("home")

    public String home( HttpServletRequest request, Model model){
        String ctx = request.getContextPath();
        ClassUtils.getDefaultClassLoader().getResource("").getPath();
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        String treeHtml = sysPermissionService.menuTree(ctx, user.getId());
        model.addAttribute("tree", treeHtml);
        model.addAttribute("username", user.getName());
        return "Home";
    }

    @RequestMapping("")
    public String toHome(){
        return "redirect:login";
    }

    @RequestMapping("login")
    public String login(){
        return "Login";
    }

    @RequestMapping("ajaxLogin")
    @ResponseBody
    public Object ajaxLogin(String username, String password){
        AjaxResult result = new AjaxResult();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            SecurityUtils.getSubject().login(token);
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(AjaxResult.FAIL);
            result.setCode("失败");
        }
        return result;
    }

    @RequestMapping("logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "Login";
    }

}
