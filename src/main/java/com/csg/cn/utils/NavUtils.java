package com.csg.cn.utils;




import com.csg.cn.sys.tree.MenuTree;

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
                sb.append("<li class='layui-nav-item'>");
                sb.append("<a href='javascript:;'>"+ t.getAuthName() +"</a>");
                sb.append("<dl class='layui-nav-child'>");
                sb.append(getMenuTree(ctx, t.getSubMenu()));
                sb.append("</dl>");
            }else {
                sb.append("<dd>");
                sb.append("<a class='nav_item' href='").append(ctx).append("/").append(t.getAuthUrl()).append("'>");
                sb.append(t.getAuthName());
                sb.append("</a>");
                sb.append("</dd>");
            }
            sb.append("</li>");
        }

        return sb.toString();
    }

}
