package com.csg.cn.sys.control;

import com.csg.cn.db.entity.PermissionWithSubCount;
import com.csg.cn.db.entity.SysPermission;
import com.csg.cn.db.entity.jstree.JsTreeNode;
import com.csg.cn.db.entity.jstree.JsTreeNodeState;
import com.csg.cn.sys.service.SysPermissionService;
import com.csg.cn.utils.UUIDUtils;
import com.csg.cn.vo.AjaxResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author yichen
 * @description
 * @date 2018/5/24
 **/
@Controller
@RequestMapping("/permission")
public class PermissionController {

    private static final Logger logger = Logger.getLogger(PermissionController.class);

    @Autowired
    private SysPermissionService sysPermissionService;

    @RequestMapping("/list")
    public String list(){
        return "permission/list";
    }

    @RequestMapping("add")
    public String add(String pid, Model model){
        model.addAttribute("pid", pid);
        return "permission/add";
    }

    @RequestMapping("edit")
    public String edit(String id, Model model){
        SysPermission permission = sysPermissionService.selectById(id);
        model.addAttribute("permission", permission);
        return "permission/edit";
    }

    @RequestMapping("/getTree")
    @ResponseBody
    public List<JsTreeNode> getPermissionTree(String pid){
        List<JsTreeNode> nodes = new ArrayList<>();
        try {
            if (pid.equals("#")){
                JsTreeNode root = new JsTreeNode();
                JsTreeNodeState rootState = new JsTreeNodeState();
                rootState.setOpened(true);
                root.setState(rootState);
                root.setText("全部");
                root.setId("0");
                root.setChildren(true);
                nodes.add(root);
            }else {
                List<SysPermission> permissions = sysPermissionService.getPermissionsByPid(pid);
                permissions.forEach(sysPermission -> {
                    JsTreeNode node = new JsTreeNode();
                    node.setId(sysPermission.getId());
                    node.setChildren(true);
                    node.setText(sysPermission.getName());
                    JsTreeNodeState state = new JsTreeNodeState();
                    state.setOpened(false);
                    nodes.add(node);
                });
            }
        }catch (Exception e){
            logger.error("查询权限报错", e);
        }
        return nodes;

    }

    @RequestMapping("getTreeWithState")
    @ResponseBody
    public List<JsTreeNode> getTreeWithState(String pid, String roleId){
        List<JsTreeNode> nodes = new ArrayList<>();
        try {
            if (pid.equals("#")){
                JsTreeNode root = new JsTreeNode();
                JsTreeNodeState rootState = new JsTreeNodeState();
                rootState.setOpened(true);
                root.setState(rootState);
                root.setText("全部");
                root.setId("0");
                root.setChildren(true);
                nodes.add(root);
            }else {
                List<PermissionWithSubCount> permissions = sysPermissionService.selectPermissionWithSubCount(pid);
                if (permissions.size() == 0){
                    return nodes;
                }

                Set<String> checkedPermissionSet = sysPermissionService.rolesPermission(roleId);
                permissions.forEach(sysPermission -> {
                    JsTreeNode node = new JsTreeNode();
                    node.setId(sysPermission.getId());
                    node.setText(sysPermission.getName());
                    JsTreeNodeState state = new JsTreeNodeState();
                    if (sysPermission.getCount() == 0){
                        if (checkedPermissionSet.contains(sysPermission.getId())){
                            state.setSelected(true);
                        }else {
                            state.setSelected(false);
                        }
                        node.setChildren(false);
                        state.setOpened(false);
                    }else {
                        state.setSelected(false);
                        node.setChildren(true);
                        state.setOpened(true);
                    }

                    node.setState(state);
                    nodes.add(node);
                });
            }
        }catch (Exception e){
            logger.error("查询权限报错", e);
        }
        return nodes;
    }

    @RequestMapping("saveAdd")
    @ResponseBody
    public AjaxResult addPermission(SysPermission sysPermission){
        AjaxResult result = new AjaxResult();
        try {
            sysPermission.setId(UUIDUtils.generateUUID());
            sysPermissionService.insert(sysPermission);
            Map<String, String> nodeMap = new HashMap<>();
            nodeMap.put("text", sysPermission.getName());
            nodeMap.put("id", sysPermission.getId());
            result.setData(nodeMap);
            result.setCode(AjaxResult.SUCCESS);
        }catch (Exception e){
            logger.error("添加权限失败",e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage("添加权限失败");
        }
        return result;
    }

    @RequestMapping("saveEdit")
    @ResponseBody
    public AjaxResult editPermission(SysPermission sysPermission){
        AjaxResult result = new AjaxResult();
        try {
            sysPermissionService.update(sysPermission);
            result.setData(sysPermission);
            result.setCode(AjaxResult.SUCCESS);
        }catch (Exception e){
            logger.error("修改权限失败",e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage("修改权限失败");
        }
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    public AjaxResult delete(String id){
        AjaxResult result = new AjaxResult();
        try {
            long count = sysPermissionService.countSubPermission(id);
            if (count > 0){
                result.setCode(AjaxResult.FAIL);
                result.setMessage("请先删除子权限");
                return result;
            }else {
                result.setCode(AjaxResult.SUCCESS);
                sysPermissionService.deletePermission(id);
            }
        }catch (Exception e){
            logger.error("删除异常", e);
            result.setCode(AjaxResult.FAIL);
            result.setMessage("删除异常");
        }
        return result;
    }

}
