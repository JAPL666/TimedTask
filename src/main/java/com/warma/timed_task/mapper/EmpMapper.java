package com.warma.timed_task.mapper;

import com.warma.timed_task.module.Emp;
import com.warma.timed_task.module.QQEmp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select * from cloudlearning")
    List<Emp> findAllEmp();

    @Select("select * from qq")
    List<QQEmp> findCookiesByQQ();

    @Insert("insert into qq (name,myqq,cookies) values(#{name},#{myqq},#{cookies}")
    int insertQQCookies(QQEmp qqEmp);

    @Delete("delete from qq where myqq=#{myqq}")
    int deleteQQCookies(QQEmp qqEmp);

}
