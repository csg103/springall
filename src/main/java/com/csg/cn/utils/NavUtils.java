package com.baidu;


import com.csg.cn.sys.tree.MenuTree;

import java.util.List;

/**
 * @author yichen
 * @description
 * @date 2018/5/31
 **/
public class NavUtils {

    public static String getMenuTree(String ctx, List<MenuTree> trees) {
        StringBuilder sb = new StringBuilder();
        for (MenuTree t : trees) {
            sb.append("<li class='left_slider'>");
            if (t.getSubMenu() != null && t.getSubMenu().size() > 0) {
                sb.append("<a href='javascript:;' class='item_hover'>");
                sb.append("<i class='iconfont none'>&#xe6b8;</i>");
                sb.append("<cite>");
                sb.append(t.getAuthName());
                sb.append("</cite>");
                sb.append("<i class='iconfont nav_right'>&#xe697;</i>");
                sb.append("</a>");
                sb.append("<ul class='sub-menu'>");
                sb.append(getMenuTree(ctx, t.getSubMenu()));
                sb.append("</ul>");
            } else {
                sb.append("<a onclick='xadmin.add_tab" +
                        "('折线图','auth/list')" +
                        "'");
                //                sb.append("<a _href='").append(ctx).append("http://localhost:8080/").append(t.getAuthUrl()).append("'>");
//                sb.append("<i class='iconfont none'>&#xe6b8;</i>");
                sb.append("<cite>");
                sb.append(t.getAuthName());
                sb.append("</cite>");
                sb.append("</a>");
            }
            sb.append("</li>");
        }

        return sb.toString();
    }

}
