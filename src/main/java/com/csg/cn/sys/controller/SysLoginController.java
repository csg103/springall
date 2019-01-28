package com.csg.cn.sys.controller;

import com.csg.cn.db.entity.SysUser;
import com.csg.cn.db.vo.SysCompanySimple;
import com.csg.cn.sys.service.SysAuthService;
import com.csg.cn.utils.MD5Utils;
import com.csg.cn.vo.AjaxResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yangzy on 2018/10/31.
 */
@Controller
public class SysLoginController {

    @Autowired
    private SysAuthService sysAuthService;

    private Logger logger = LoggerFactory.getLogger(SysLoginController.class);

    @RequestMapping("/loginIn")
    @ResponseBody
    public AjaxResult loginIn(String username, String password){
        AjaxResult result = new AjaxResult();
        try{
            UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Utils.encode(password));
            SecurityUtils.getSubject().login(token);
            SecurityUtils.getSubject().getSession().setTimeout(-1001l);
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("成功");
        }catch (UnknownAccountException e){
            result.setCode(AjaxResult.SUCCESS);
            //用户名不存在
            result.setMessage("0");
        }catch (IncorrectCredentialsException e){
            result.setCode(AjaxResult.SUCCESS);
            //密码错误
            result.setMessage("1");
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/home")
    public String home(HttpServletRequest request, Model model){
        String ctx = request.getContextPath();
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        String treeHtml = sysAuthService.menuTree(ctx, user.getId());
        model.addAttribute("tree", treeHtml);
        model.addAttribute("userId", user.getId());
        model.addAttribute("username", user.getName());

        List<SysCompanySimple> sysCompanySimples = user.getSysCompanySimples();
        model.addAttribute("currentCompany", user.getCurrentCompanyName());
        model.addAttribute("userCompanies", sysCompanySimples);
        return "Home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "login";
    }

    @RequestMapping("/changeCompany")
    @ResponseBody
    public AjaxResult changeCompany(String companyId, String companyName){
        AjaxResult result = new AjaxResult();
        try{
            SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
            sysUser.setCurrentCompanyId(companyId);
            sysUser.setCurrentCompanyName(companyName);
            result.setMessage("success");
            result.setCode(AjaxResult.SUCCESS);
        }catch (Exception e){
            logger.error(e.getMessage());
            result.setMessage(e.getMessage());
            result.setCode(AjaxResult.FAIL);
        }
        return result;
    }

    @RequestMapping("/403")
    public String notAuthorized(){
        return "403";
    }
}
