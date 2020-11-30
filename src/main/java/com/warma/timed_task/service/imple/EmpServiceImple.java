package com.warma.timed_task.service.imple;

import com.warma.timed_task.mapper.EmpMapper;
import com.warma.timed_task.module.Emp;
import com.warma.timed_task.module.QQEmp;
import com.warma.timed_task.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("empServiceImple")
public class EmpServiceImple implements EmpService {

    @Resource
    EmpMapper empMapper;

    @Override
    public List<Emp> findAllEmp() {
        return empMapper.findAllEmp();
    }

    @Override
    public List<QQEmp> findAllCookies() {
        return empMapper.findAllCookies();
    }

    @Override
    public int insertQQCookies(QQEmp qqEmp) {
        return empMapper.insertQQCookies(qqEmp);
    }

    @Override
    public int deleteQQCookies(QQEmp qqEmp) {
        return empMapper.deleteQQCookies(qqEmp);
    }
}
