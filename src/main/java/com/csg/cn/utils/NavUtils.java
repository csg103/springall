package com.csg.cn.utils;


import com.csg.cn.vo.MenuTree;

import java.util.List;

/**
 * @author yichen
 * @description
 * @date 2018/5/31
 **/
public class NavUtils {

    public static String getMenuTree(String ctx, List<MenuTree> trees){
        StringBuilder sb = new StringBuilder();
        for (MenuTree t : trees){
            sb.append("<li>");
            if (t.getSubMenu() != null && t.getSubMenu().size() > 0){
                sb.append("<a href='javascript:;'>");
                sb.append("<i class='iconfont'>&#xe6b8;</i>");
                sb.append("<cite>");
                sb.append(t.getName());
                sb.append("</cite>");
                sb.append("<i class='iconfont nav_right'>&#xe697;</i>");
                sb.append("</a>");
                sb.append("<ul class='sub-menu'>");
                sb.append(getMenuTree(ctx, t.getSubMenu()));
                sb.append("</ul>");
            }else {
                sb.append("<a _href='").append(ctx).append("/").append(t.getUrl()).append("'>");
                sb.append("<i class='iconfont'>&#xe6b8;</i>");
                sb.append("<cite>");
                sb.append(t.getName());
                sb.append("</cite>");
                sb.append("</a>");
            }
            sb.append("</li>");
        }

        return sb.toString();
    }

}
