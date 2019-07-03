package com.csg.cn.business.action.welcome;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname welcomeAction
 * @Description TODO
 * @Date 2019/5/27 9:29
 * @Created by ${suge.chen}
 */
@Controller
@RequestMapping("/welcome")
public class welcomeAction {

    @RequestMapping("/goMain")
    public String list( Model model){
        String userName = (String) SecurityUtils.getSubject().getSession().getAttribute("userName");
        String isLeader = (String) SecurityUtils.getSubject().getSession().getAttribute("isLeader");
        String group = (String) SecurityUtils.getSubject().getSession().getAttribute("group");
        model.addAttribute("isLeader", isLeader);
        model.addAttribute("userName", userName);
        model.addAttribute("group", group);
        return "welcome";
    }
}
