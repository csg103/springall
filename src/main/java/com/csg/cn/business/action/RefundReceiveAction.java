package com.csg.cn.business.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yangzy on 2019/1/31.
 */
@Controller
@RequestMapping("/refundReceive")
public class RefundReceiveAction {

    @RequestMapping("/list")
    public String list(){
        return "cms/15_return_list";
    }
}
