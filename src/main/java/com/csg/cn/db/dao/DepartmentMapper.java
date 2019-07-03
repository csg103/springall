package com.csg.cn.db.dao;

import com.csg.cn.db.entity.Department;
import com.csg.cn.db.entity.DepartmentExample;
import tk.mybatis.mapper.common.Mapper;

public interface DepartmentMapper extends Mapper<Department> {
    int countByExample(DepartmentExample example);
}