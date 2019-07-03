package com.csg.cn.db.dao;

import com.csg.cn.db.entity.Appendix;
import com.csg.cn.db.entity.AppendixExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AppendixMapper extends Mapper<Appendix> {
    long countByExample(AppendixExample example);


    @Select("select b.valuename as appendtypename, a.* from t_appendix a ,t_common b where a.appendtype =b.id  and  a.opertime > #{starttime} and a.opertime < #{endtime} ")
    List<Appendix> selectAppendixByTime(@Param("starttime") String starttime,@Param("endtime") String endtime);



    @Select("select b.valuename as appendtypename, a.* from t_appendix a ,t_common b where a.appendtype =b.id  and  a.opertime > #{starttime} and a.opertime < #{endtime} and appendtype =#{type}")
    List<Appendix> selectAppendixByTimeType(@Param("starttime") String starttime,@Param("endtime") String endtime,@Param("type") String type);



    @Select("select b.valuename as appendtypename , a.* from t_appendix a ,t_common b where a.appendtype =b.id  and  a.opertime > #{starttime} and a.opertime < #{endtime} and appendname like CONCAT('%',#{name},'%')")
    List<Appendix> selectAppendixByTimeName(@Param("starttime") String starttime,@Param("endtime") String endtime,@Param("name") String name);



    @Select("select b.valuename as appendtypename , a.* from t_appendix a ,t_common b where a.appendtype =b.id  and  a.opertime > #{starttime} and a.opertime < #{endtime}  and appendname like CONCAT('%',#{name},'%')  and appendtype =#{type}")
    List<Appendix> selectAppendixByTimeTypeName(@Param("starttime") String starttime,@Param("endtime") String endtime,@Param("type") String type,@Param("name") String name);



}