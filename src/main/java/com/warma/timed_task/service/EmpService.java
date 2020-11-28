package com.warma.timed_task.service;

import com.warma.timed_task.module.Emp;
import com.warma.timed_task.module.QQEmp;

import java.util.List;

public interface EmpService {
    List<Emp> findAllEmp();

    List<QQEmp> findCookiesByQQ();

    int insertQQCookies(QQEmp qqEmp);

    int deleteQQCookies(QQEmp qqEmp);
}
