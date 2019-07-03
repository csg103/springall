package com.csg.cn.business.service.partyMember.impl;

import com.baidu.UUIDUtils;
import com.csg.cn.business.service.partyMember.AppendixService;
import com.csg.cn.db.dao.AppendixMapper;
import com.csg.cn.db.entity.Appendix;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Classname AppendixServiceImpl
 * @Description TODO
 * @Date 2019/6/25 8:49
 * @Created by ${suge.chen}
 */
@Service
public class AppendixServiceImpl implements AppendixService {
    @Autowired
    private AppendixMapper appendixMapper;

    @Override
    public List<Appendix> selectAppendixList(String starttime, String endtime, String name, String type) {
        if (StringUtils.equals(type, "0") && StringUtils.isEmpty(name)) {
            return appendixMapper.selectAppendixByTime(starttime, endtime);
        } else if (!StringUtils.equals(type, "0") && StringUtils.isEmpty(name)) {
            return appendixMapper.selectAppendixByTimeType(starttime, endtime, type);
        } else if (StringUtils.equals(type, "0") && !StringUtils.isEmpty(name)) {
            return appendixMapper.selectAppendixByTimeName(starttime, endtime, name);
        } else {
            return appendixMapper.selectAppendixByTimeTypeName(starttime, endtime, type, name);
        }
    }

    @Override
    public int saveAppendixList(List<Appendix> list) {
        String userName = (String) SecurityUtils.getSubject().getSession().getAttribute("userName");
        for (int i = 0; i < list.size(); i++) {
            Appendix appendix ;
            appendix = list.get(i);
            appendix.setAppendixid(UUIDUtils.generateUUID());
            appendix.setOpertime(new Date());
            appendix.setOpername(userName);
            appendixMapper.insert(list.get(i));

        }
        return 0;
    }

    @Override
    public int deleteAllById(List<String> ids) {
        for (String id : ids) {


            appendixMapper.deleteByPrimaryKey(id);
        }
        return 0;
    }
}
