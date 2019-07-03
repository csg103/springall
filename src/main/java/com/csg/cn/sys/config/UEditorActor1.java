package com.csg.cn.sys.config;

import com.baidu.ueditor.ActionEnter;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @Classname UEditorActor
 * @Description TODO
 * @Date 2019/6/3 16:47
 * @Created by ${suge.chen}
 */
@Controller
public class UEditorActor1 {
    @Autowired
    private FastDFSUploader fastDFSUploader;

    @Value("${config.pwd}")
    private String pwd;

    @Value("${fdfs.host}")
    private String host;
    @RequestMapping("/config")
    @ResponseBody
    public void config(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("application/json");
//        String rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/ueditor/jsp";
        String rootPath = pwd;

        System.out.println(rootPath);
        response.setCharacterEncoding("utf-8");
        String exec = new ActionEnter(request, rootPath).exec();
        PrintWriter writer = null;
        System.out.println(exec);
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.write(new ActionEnter(request, rootPath).exec());
        writer.flush();
        writer.close();
    }

    @RequestMapping("/imgUpload")
    @ResponseBody
    public Map imgUpload(MultipartFile upfile) {

        System.out.println("-------------------------开始上传------------------------------");
        byte[] bytes = new byte[0];
        try {
            bytes = upfile.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String originalFileName = upfile.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileName = upfile.getName();
        long fileSize = upfile.getSize();
        String url = host + fastDFSUploader.upload(bytes, originalFileName)[1];
        String fileId = "pic";
        System.out.println("-------------------------结束上传------------------------------");
        return resultMap("SUCCESS", url, fileSize, fileId, fileName, extension);
    }

    private Map<String, Object> resultMap(String state, String url, long size, String title, String original, String type) {
        Map<String, Object> result = Maps.newHashMap();
        result.put("state", state);
        result.put("original", original);
        result.put("size", size);
        result.put("title", title);
        result.put("type", type);
        result.put("url", url);
        return result;
    }
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
