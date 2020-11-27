package com.warma.timed_task.controllers;

import com.warma.timed_task.utils.Mail;
import com.warma.timed_task.utils.Warma;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

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

    @RequestMapping("getBase64")
    public Object getBase64(){
        String path="/www/wwwroot/SpringBootApplication/TimedTask/imageFiles";
        File[] files = new File(path).listFiles();
        assert files != null;
        int random = Warma.Random(0, files.length);
        File file = files[random];

        String image=Warma.ImageToBase64(file.getPath());
        //image=Warma.urlEncoder(image);
        return image;
    }
}
