package com.csg.cn.db.dao;

import com.csg.cn.db.entity.Common;
import com.csg.cn.db.entity.CommonExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CommonMapper extends Mapper<Common> {
    long countByExample(CommonExample example);


    @Select("select * from t_common where type  = #{type}  order by  valueid")

 List<Common> selectType(@Param("type") String type);






}