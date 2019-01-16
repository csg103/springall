package com.csg.cn.db.entity;

/**
 * @author yichen
 * @description
 * @date 2018/5/28
 **/
public class PermissionWithSubCount extends SysPermission {

    private long count;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
