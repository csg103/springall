package com.csg.cn.db.entity.jstree;

/**
 * @author yichen
 * @description
 * @date 2018/5/24
 **/
public class JsTreeNodeState {

    private boolean opened;

    private boolean disabled;

    private boolean selected;

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
