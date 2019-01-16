package com.csg.cn.business.action;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fx on 2018/10/31.
 */
@Controller
@RequestMapping("/order")
public class OrderController {


    @RequestMapping("/html")
    public String html(){

        return "order/list";
    }


}
