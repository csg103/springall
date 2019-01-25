package com.csg.cn.db.vo;

import com.csg.cn.db.entity.SysCompany;

/**
 * Created by yangzy on 2018/12/10.
 */
public class SysCompanyCount extends SysCompany {

    private long count;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
