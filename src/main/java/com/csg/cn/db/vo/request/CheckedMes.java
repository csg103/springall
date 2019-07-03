package com.csg.cn.db.vo.request;

/**
 * @Classname CheckedMes
 * @Description TODO
 * @Date 2019/6/14 14:05
 * @Created by ${suge.chen}
 */
public class CheckedMes {
    private  String value;
    private  String title;
    private Boolean disabled;
    private Boolean checked;
private  String group;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
