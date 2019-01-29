package com.csg.cn.business.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yangzy on 2019/1/28.
 */
@RequestMapping("/orderSelect")
@Controller
public class OrderSelectAction {

    @RequestMapping("/list")
    public String list(){
        return "cms/01_order_list";
    }
}
