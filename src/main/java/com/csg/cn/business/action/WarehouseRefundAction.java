package com.csg.cn.business.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yangzy on 2019/2/1.
 */
@Controller
@RequestMapping("/warehouseRefund")
public class WarehouseRefundAction {

    @RequestMapping("/list")
    public String list(){
        return "cms/60_returnForm_list";
    }
}
