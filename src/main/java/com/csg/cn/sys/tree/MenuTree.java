package com.csg.cn.sys.tree;


import com.csg.cn.db.entity.SysAuth;

import java.util.List;

/**
 * @author yichen
 * @description
 * @date 2018/5/30
 **/
public class MenuTree extends SysAuth {

    private String userId;

    private List<MenuTree> subMenu;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<MenuTree> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<MenuTree> subMenu) {
        this.subMenu = subMenu;
    }

    public String getTreeHtml(String ctx){
        StringBuilder builder = new StringBuilder();
        builder.append("<li>");
        if (subMenu != null && subMenu.size() > 0){
            builder.append("<a href='javascript:;' style='color:#fff;'>");
//            builder.append("<i class='iconfont'>&#xe6b8;</i>");
            builder.append("<cite>");
            builder.append(getAuthName());
            builder.append("</cite>");
//            builder.append("<i class='iconfont nav_right'>&#xe697;</i>");
            builder.append("<span class='layui-nav-more></span>");
            builder.append("</a>");
            builder.append("<ul class='sub-menu'>");
            for (SysAuth sysAuth : subMenu){
                builder.append("<li>");
                builder.append("<a _href='").append(sysAuth.getAuthUrl()).append("'>");
                builder.append("<i class='iconfont'>&#xe6a7;</i>");
                builder.append("<cite>").append(sysAuth.getAuthName()).append("</cite>");
                builder.append("</a>");
                builder.append("</li>");
            }
            builder.append("</ul>");
        }
        builder.append("</li>");

        return builder.toString();
    }
}
