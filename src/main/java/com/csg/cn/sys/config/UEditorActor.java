package com.csg.cn.sys.config;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @Classname UEditorActor
 * @Description TODO
 * @Date 2019/6/3 16:47
 * @Created by ${suge.chen}
 */
@Controller
@RequestMapping("/ueditor")
public class UEditorActor {

//    @RequestMapping("/config")
//    @ResponseBody
//    public void   config(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
//        response.setContentType("application/json");
//        String rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/ueditor/jsp";
//        response.setCharacterEncoding("utf-8");
//        String exec = new ActionEnter(request, rootPath).exec();
//        PrintWriter writer = null;
//        System.out.println(exec);
//        try {
//            writer = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        writer.write(new ActionEnter(request, rootPath).exec());
//        writer.flush();
//        writer.close();
//    }
//    @RequestMapping("/config")
//    public String config(String action, HttpServletRequest request, HttpServletResponse response) {
//        return "redirect:/ueditor/jsp/config.json";
//    }

    @RequestMapping("/html")
    public String list() {
        return "ueditor/index";
    }


//    @RequestMapping("/lay")
//    public String lay(String action, HttpServletRequest request, HttpServletResponse response) {
//        return "redirect:/ueditor/jsp/config.json";
//    }


//    @PostMapping("/upload")
//        public String  upload(MultipartFile file) {
//    return  "";
//    }


}
