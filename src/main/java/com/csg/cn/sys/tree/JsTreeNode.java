package com.csg.cn.sys.tree;

/**
 * @author yichen
 * @description
 * @date 2018/5/24
 **/
public class JsTreeNode {

    private String id;

    private String text;

    private String icon;

    private JsTreeNodeState state;

    private boolean children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public JsTreeNodeState getState() {
        return state;
    }

    public void setState(JsTreeNodeState state) {
        this.state = state;
    }

    public boolean isChildren() {
        return children;
    }

    public void setChildren(boolean children) {
        this.children = children;
    }
}
