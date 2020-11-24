package com.warma.timed_task.mapper;

import com.warma.timed_task.module.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select * from cloudlearning")
    List<Emp> findAllEmp();
}
