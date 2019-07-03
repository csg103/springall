package com.csg.cn.db.vo.request;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname ScoreReturnVo
 * @Description TODO
 * @Date 2019/5/30 15:51
 * @Created by ${suge.chen}
 */
public class AddOrSubScore {
    private String isAdd;
    private String score;

    public String getIsAdd() {
        return isAdd;
    }

    public void setIsAdd(String isAdd) {
        this.isAdd = isAdd;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
