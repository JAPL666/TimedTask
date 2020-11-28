package com.warma.timed_task.controllers;

import com.warma.timed_task.utils.Mail;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @RequestMapping("sendEmail")
    public Object sendEmail(String email,String title,String str){
        boolean b = Mail.sendEmail(email, title, str);
        if(b){
            return "发送成功！";
        }
        return "发送失败！";
    }
}
