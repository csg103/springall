package com.csg.cn.vo;


import com.csg.cn.db.entity.SysPermission;

import java.util.List;

/**
 * @author yichen
 * @description
 * @date 2018/5/30
 **/
public class MenuTree extends SysPermission {

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
            builder.append("<a href='javascript:;'>");
            builder.append("<i class='iconfont'>&#xe6b8;</i>");
            builder.append("<cite>");
            builder.append(getName());
            builder.append("</cite>");
            builder.append("<i class='iconfont nav_right'>&#xe697;</i>");
            builder.append("</a>");
            builder.append("<ul class='sub-menu'>");
            for (SysPermission p : subMenu){
                builder.append("<li>");
                builder.append("<a _href='").append(p.getUrl()).append("'>");
                builder.append("<i class='iconfont'>&#xe6a7;</i>");
                builder.append("<cite>").append(p.getName()).append("</cite>");
                builder.append("</a>");
                builder.append("</li>");
            }
            builder.append("</ul>");
        }
        builder.append("</li>");

        return builder.toString();
    }
}
