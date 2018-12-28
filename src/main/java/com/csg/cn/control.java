package com.csg.cn;

import com.csg.cn.dao.UserMapper;
import com.csg.cn.entity.User;
import com.csg.cn.entity.UserExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
* 描述 ： controltest
* 作者 ： csg
* 时间 ： 2018-12-25
*/
@Api(value = "control", description = "control")
@Controller
@RequestMapping("/test")
public class control {
    @Autowired
    private UserMapper userMapper;


    @RequestMapping(value = "/testdatabaseMd5", method = {RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value = "用户登录", notes = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string"),
            @ApiImplicitParam(name = "passwd", value = "密码", required = true, dataType = "string")
    })



    public Object testdatabaseMd5(Model model){

        PageHelper.startPage(1, 5);
        List<User> userList =  userMapper.selectAll();
        List<User> userList1 =  userMapper.selectAllSql();



        PageInfo page = new PageInfo(userList);
        PageInfo page1 = new PageInfo(userList1);
        return  userList;
    }




    @RequestMapping(value = "/testdatabaseMd51", method = {RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value = "用户登录1", notes = "用户登录接口1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username1", value = "用户名", required = true, dataType = "string"),
            @ApiImplicitParam(name = "passwd1", value = "密码", required = true, dataType = "string")
    })



    public Object testdatabaseMd15(Model model){

        PageHelper.startPage(1, 5);
        List<User> userList =  userMapper.selectAll();
        List<User> userList1 =  userMapper.selectAllSql();



        PageInfo page = new PageInfo(userList);
        PageInfo page1 = new PageInfo(userList1);
        return  userList;
    }



}
