package com.warma.timed_task.controllers;

import com.warma.timed_task.module.QQEmp;
import com.warma.timed_task.service.EmpService;
import com.warma.timed_task.utils.Mail;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class WarmaController {

    @Resource(name = "empServiceImple")
    EmpService empService;

    @RequestMapping("sendEmail")
    public Object sendEmail(String email,String title,String str){
        boolean b = Mail.sendEmail(email, title, str);
        if(b){
            return "发送成功！";
        }
        return "发送失败！";
    }

    @RequestMapping("setQQCookies")
    public Object setQQCookies(QQEmp qqEmp){
        if(qqEmp==null){
            return "QQCookies保存失败！";
        }
        System.out.println(qqEmp.getMyqq());
        System.out.println(qqEmp.getCookies());
        System.out.println(qqEmp.getName());
        List<QQEmp> cookiesByQQ = empService.findCookiesByQQ();
        for (QQEmp emp : cookiesByQQ) {
            if(emp.getMyqq().equals(qqEmp.getMyqq())){
                empService.deleteQQCookies(qqEmp);
            }
        }
        int result=empService.insertQQCookies(qqEmp);
        if(result==1){
            return "QQCookies保存成功！";
        }
        return "QQCookies保存失败！";
    }
}
