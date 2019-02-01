package com.csg.cn.business.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yangzy on 2019/2/1.
 */
@Controller
@RequestMapping("/warehouseAdjust")
public class WarehouseAdjustAction {

    @RequestMapping("/list")
    public String list(){
        return "cms/70_store_list";
    }
}
