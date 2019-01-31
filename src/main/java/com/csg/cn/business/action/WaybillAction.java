package com.csg.cn.business.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yangzy on 2019/1/31.
 */
@Controller
@RequestMapping("/waybill")
public class WaybillAction {

    @RequestMapping("/list")
    public String list(){
        return "cms/10_transport_list";
    }
}
