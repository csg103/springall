package com.csg.cn.db.dao;

import com.csg.cn.db.entity.PartyMemberScorePip;
import com.csg.cn.db.entity.PartyMemberScorePipExample;
import tk.mybatis.mapper.common.Mapper;

public interface PartyMemberScorePipMapper extends Mapper<PartyMemberScorePip> {
    long countByExample(PartyMemberScorePipExample example);
}