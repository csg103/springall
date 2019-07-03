package com.csg.cn.sys.controller;

import com.baidu.UUIDUtils;
import com.csg.cn.db.entity.SysAuth;
import com.csg.cn.db.entity.SysCompany;
import com.csg.cn.db.vo.SysAuthCount;
import com.csg.cn.db.vo.SysCompanyCount;
import com.csg.cn.sys.constant.SysConstant;
import com.csg.cn.sys.service.SysAuthService;
import com.csg.cn.sys.service.SysCompanyService;
import com.csg.cn.sys.service.SysUserService;
import com.csg.cn.sys.tree.JsTreeNode;
import com.csg.cn.sys.tree.JsTreeNodeState;
import com.csg.cn.vo.AjaxResult;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by yangzy on 2018/11/5.
 */
@Controller
@RequestMapping("/auth")
public class SysAuthController {

    private Logger logger = LoggerFactory.getLogger(SysAuthController.class);

    @Autowired
    private SysAuthService sysAuthService;
    @Autowired
    private SysCompanyService sysCompanyService;
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/list")
    public String list(){
        return "auth/list";
    }

    @RequestMapping("/add")
    public String add(String authParentId, Model model){
        model.addAttribute("authParentId", authParentId);
        return "auth/add";
    }

    @RequestMapping("/edit")
    public String edit(String id, Model model){
        SysAuth sysAuth = sysAuthService.selectOne(id);
        model.addAttribute("sysAuth", sysAuth);
        return "auth/edit";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(String id){
        AjaxResult result = new AjaxResult();
        try{
            long count = sysAuthService.selectSubAuth(id);
            if(count > 0){
                result.setCode(AjaxResult.FAIL);
                result.setMessage("请先删除子权限");
                return result;
            }else{
                sysAuthService.delete(id);
                result.setCode(AjaxResult.SUCCESS);
                result.setMessage("success");
            }
        }catch (Exception e){
            logger.error("删除权限失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage("fail");
        }
        return result;
    }

    @RequestMapping("/saveAdd")
    @ResponseBody
    public AjaxResult saveAdd(SysAuth sysAuth){
        AjaxResult result = new AjaxResult();
        try{
            String id = UUIDUtils.generateUUID();
            sysAuth.setId(id);
            sysAuth.setAuthDescription(sysAuth.getAuthName());
            sysAuth.setAuthStatus(SysConstant.ENABLED_ONE);
            sysAuthService.insert(sysAuth);
            Map<String, String> map = new HashMap<String, String>(4);
            map.put("id", id);
            map.put("text", sysAuth.getAuthName());
            result.setData(map);
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
        }catch (Exception e){
            logger.error("添加权限失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage("fail");
        }
        return result;
    }

    @RequestMapping("/saveEdit")
    @ResponseBody
    public AjaxResult saveEdit(SysAuth sysAuth){
        AjaxResult result = new AjaxResult();
        try{
            if(StringUtils.isNotBlank(sysAuth.getAuthName())){
                sysAuth.setAuthDescription(sysAuth.getAuthName());
            }
            sysAuthService.update(sysAuth);
            result.setData(sysAuth);
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("success");
        }catch (Exception e){
            logger.error("修改权限失败", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage("fail");
        }
        return result;
    }

    @RequestMapping("/getTree")
    @ResponseBody
    public List<JsTreeNode> getTree(String authParentId){
        List<JsTreeNode> jsTreeNodes = new ArrayList<JsTreeNode>(64);
        try{
            JsTreeNode jsTreeNode;
            JsTreeNodeState jsTreeNodeState;
            if("#".equals(authParentId)){
                jsTreeNode = new JsTreeNode();
                jsTreeNodeState = new JsTreeNodeState();
                jsTreeNodeState.setOpened(true);
                jsTreeNode.setState(jsTreeNodeState);
                jsTreeNode.setText("全部");
                jsTreeNode.setId("0");
                jsTreeNode.setChildren(true);
                jsTreeNodes.add(jsTreeNode);
            }else{
                List<SysAuth> auths = sysAuthService.selectListByAuthParentId(authParentId);
                for(SysAuth sysAuth : auths){
                    jsTreeNode = new JsTreeNode();
                    jsTreeNode.setId(sysAuth.getId());
                    jsTreeNode.setChildren(true);
                    jsTreeNode.setText(sysAuth.getAuthName());
                    jsTreeNodeState = new JsTreeNodeState();
                    jsTreeNodeState.setOpened(false);
                    jsTreeNodes.add(jsTreeNode);
                }
            }
        }catch (Exception e){
            logger.error("查询权限错误");
        }
        return jsTreeNodes;
    }


    @RequestMapping("/getCompanyTree")
    @ResponseBody
    public List<JsTreeNode> getCompanyTree(String companyParentId){
        List<JsTreeNode> jsTreeNodes = new ArrayList<JsTreeNode>(8);
        try{
            JsTreeNode jsTreeNode;
            JsTreeNodeState jsTreeNodeState;
            if("#".equals(companyParentId)){
                jsTreeNode = new JsTreeNode();
                jsTreeNodeState = new JsTreeNodeState();
                jsTreeNodeState.setOpened(true);
                jsTreeNode.setState(jsTreeNodeState);
                jsTreeNode.setText("全部");
                jsTreeNode.setId("0");
                jsTreeNode.setChildren(true);
                jsTreeNodes.add(jsTreeNode);
            }else{
                List<SysCompany> companies = sysCompanyService.selectListByCompanyParentId(companyParentId);
                for(SysCompany sysCompany : companies){
                    jsTreeNode = new JsTreeNode();
                    jsTreeNode.setId(sysCompany.getId());
                    jsTreeNode.setChildren(true);
                    jsTreeNode.setText(sysCompany.getCompanyName());
                    jsTreeNodeState = new JsTreeNodeState();
                    jsTreeNodeState.setOpened(false);
                    jsTreeNodes.add(jsTreeNode);
                }
            }
        }catch (Exception e){
            logger.error("查询公司错误");
        }
        return jsTreeNodes;
    }

    @RequestMapping("/getTreeWithState")
    @ResponseBody
    public List<JsTreeNode> getTreeWithState(String authParentId, String roleId){
        List<JsTreeNode> jsTreeNodes = new ArrayList<JsTreeNode>(64);
        try{
            JsTreeNode jsTreeNode;
            JsTreeNodeState jsTreeNodeState;
            if("#".equals(authParentId)){
                jsTreeNode = new JsTreeNode();
                jsTreeNodeState = new JsTreeNodeState();
                jsTreeNodeState.setOpened(true);
                jsTreeNode.setState(jsTreeNodeState);
                jsTreeNode.setText("全部");
                jsTreeNode.setId("0");
                jsTreeNode.setChildren(true);
                jsTreeNodes.add(jsTreeNode);
            }else{
                List<SysAuthCount> sysAuthCounts = sysAuthService.selectAuthWithSubCount(authParentId);
                if(CollectionUtils.isEmpty(sysAuthCounts)){
                    return jsTreeNodes;
                }

                Set<String> auths = sysAuthService.roleAuths(roleId);
                for(SysAuthCount sysAuthCount : sysAuthCounts){
                    jsTreeNode = new JsTreeNode();
                    jsTreeNode.setId(sysAuthCount.getId());
                    jsTreeNode.setText(sysAuthCount.getAuthName());
                    jsTreeNodeState = new JsTreeNodeState();
                    if(sysAuthCount.getCount() == 0){
                        if(auths.contains(sysAuthCount.getId())){
                            jsTreeNodeState.setSelected(true);
                        }else{
                            jsTreeNodeState.setSelected(false);
                        }
                        jsTreeNodeState.setOpened(false);
                        jsTreeNode.setChildren(false);
                    }else{
                        jsTreeNodeState.setSelected(false);
                        jsTreeNodeState.setOpened(true);
                        jsTreeNode.setChildren(true);
                    }
                    jsTreeNode.setState(jsTreeNodeState);
                    jsTreeNodes.add(jsTreeNode);
                }
            }
        }catch (Exception e){
            logger.error("查询权限错误");
        }
        return jsTreeNodes;
    }


    @RequestMapping("/getCompanyTreeWithState")
    @ResponseBody
    public List<JsTreeNode> getCompanyTreeWithState(String companyParentId, String userId){
        List<JsTreeNode> jsTreeNodes = new ArrayList<JsTreeNode>(64);
        try{
            JsTreeNode jsTreeNode;
            JsTreeNodeState jsTreeNodeState;
            if("#".equals(companyParentId)){
                jsTreeNode = new JsTreeNode();
                jsTreeNodeState = new JsTreeNodeState();
                jsTreeNodeState.setOpened(true);
                jsTreeNode.setState(jsTreeNodeState);
                jsTreeNode.setText("全部");
                jsTreeNode.setId("0");
                jsTreeNode.setChildren(true);
                jsTreeNodes.add(jsTreeNode);
            }else{
                List<SysCompanyCount> sysCompanyCounts = sysCompanyService.getCompanyTreeWithState(companyParentId);
                if(CollectionUtils.isEmpty(sysCompanyCounts)){
                    return jsTreeNodes;
                }

                Set<String> auths = sysUserService.userCompanies(userId);
                for(SysCompanyCount sysCompanyCount : sysCompanyCounts){
                    jsTreeNode = new JsTreeNode();
                    jsTreeNode.setId(sysCompanyCount.getId());
                    jsTreeNode.setText(sysCompanyCount.getCompanyName());
                    jsTreeNodeState = new JsTreeNodeState();
                    if(sysCompanyCount.getCount() == 0){
                        if(auths.contains(sysCompanyCount.getId())){
                            jsTreeNodeState.setSelected(true);
                        }else{
                            jsTreeNodeState.setSelected(false);
                        }
                        jsTreeNodeState.setOpened(false);
                        jsTreeNode.setChildren(false);
                    }else{
                        jsTreeNodeState.setSelected(false);
                        jsTreeNodeState.setOpened(true);
                        jsTreeNode.setChildren(true);
                    }
                    jsTreeNode.setState(jsTreeNodeState);
                    jsTreeNodes.add(jsTreeNode);
                }
            }
        }catch (Exception e){
            logger.error("查询权限错误");
        }
        return jsTreeNodes;
    }
}
