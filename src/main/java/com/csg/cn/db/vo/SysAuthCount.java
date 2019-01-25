package com.csg.cn.db.vo;

import com.csg.cn.db.entity.SysAuth;

/**
 * Created by yangzy on 2018/11/6.
 */
public class SysAuthCount extends SysAuth {

    private long count;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
