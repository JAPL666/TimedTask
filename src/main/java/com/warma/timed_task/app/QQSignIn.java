package com.warma.timed_task.app;

import com.warma.timed_task.module.QQEmp;
import com.warma.timed_task.service.EmpService;
import com.warma.timed_task.utils.Mail;
import com.warma.timed_task.utils.Warma;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Component
public class QQSignIn {

    @Resource(name = "empServiceImple")
    EmpService empService;

    public static QQSignIn qqSignIn;

    @PostConstruct
    public void init() {
        qqSignIn = this;
    }

    public void start(){
        //QQ签到
        StringBuilder str=new StringBuilder();

        List<QQEmp> qqCookies = qqSignIn.empService.findAllCookies();
        for (QQEmp qqCookie : qqCookies) {
            String run = run(qqCookie);
            str.append(run).append("\n\n").append("-----------------------------------------\n\n");
        }
        Mail.sendEmail("2453885428@qq.com","QQ签到结果",str.toString());
    }
    public static String run(QQEmp qqEmp){
        String url="https://ti.qq.com/hybrid-h5/api/json/daily_attendance/SignIn";
        String base64=new String(Base64.encodeBase64(("{\"uin\":\""+qqEmp.getMyqq()).getBytes()))+"IiwidHlwZSI6MSwic0lkIjoiIiwicXVhIjoiVjFfQU5EX1NRXzguNC4xOF8xNTU4X1lZQl9EIiwibXBFeHRlbmQiOnsiMV9kYWlseUdkdERldmljZV9pbmZvIjoie1wiYWlkX3RpY2tldFwiOlwiMDFFMDZFQjQzNjBENzY0NzZBQkEwMkFDMUFDNkUwOEIwRjYwMUQ0Q0IwMDZEQTRFNjZcIixcImFwcF92ZXJzaW9uX2lkXCI6NTM3MDY2NDIzLFwiYnJhbmRcIjpcIlhpYW9taVwiLFwiY2Fycmllcl9jb2RlXCI6NDYwMDEsXCJjbGllbnRfaXB2NFwiOlwiMTcxLjM2LjE4LjIwMVwiLFwiY29ublwiOjEsXCJkZXZpY2VfYnJhbmRfYW5kX21vZGVsXCI6XCJNSSA4IFVEXCIsXCJkZXZpY2VfZXh0XCI6XCJ7XFxcIndlY2hhdF9pbnN0YWxsZWRfaW5mb1xcXCI6e1xcXCJoYXNfdW5pdmVyc2FsX2xpbmtcXFwiOmZhbHNlLFxcXCJhcGlfdmVyXFxcIjpcXFwiNjU0MzE2NjAwXFxcIixcXFwiaW5zdGFsbGVkXFxcIjpmYWxzZX0sXFxcImF0dHJpX2luZm9cXFwiOntcXFwidWFcXFwiOlxcXCJEYWx2aWtcXFxcLzIuMS4wIChMaW51eDsgVTsgQW5kcm9pZCAxMDsgTUkgOCBVRCBNSVVJXFxcXC8yMC45LjQpXFxcIn0sXFxcIm1xcV9jb25maWdfc3RhdHVzXFxcIjoyLFxcXCJhcHBfc3RhdHVzXFxcIjp7fSxcXFwicWFpZF9pbmZvXFxcIjp7fX1cIixcImlzX2dvb2dsZXBsYXlfdmVyc2lvblwiOmZhbHNlLFwibG9jYXRpb25cIjp7fSxcIm1hbnVmYWN0dXJlclwiOlwiWGlhb21pXCIsXCJtZDVfYW5kcm9pZF9pZFwiOlwiOTAzYjhjZjNjNTM5NjQ4OTE2YjQxYjg5NzQwODNhZTBcIixcIm11aWRfdHlwZVwiOjAsXCJvcmlnaW5fbmV0d29ya190eXBlXCI6MTMsXCJvc190eXBlXCI6MixcIm9zX3ZlclwiOlwiMTBcIixcInFxX3ZlclwiOlwiOC40LjE4XCIsXCJ0YWlkX3RpY2tldFwiOlwiMDEwMTg2OUYxN0ZBNDEzNTNERkVFRjg3RThDODlDQTE4RUU4RjVDMTRFNDY1OUVBOUIzRUEyQTVBNzFBOEI5NTc0NjdDRTlCN0Q5RjcwOTI4OUY0RDMwMFwifSIsInRpYW5zaHVBZHNSZXEiOiJ7XCJhcHBcIjpcIlFRXCIsXCJvc1wiOlwiQU5EXCIsXCJ2ZXJzaW9uXCI6XCI4LjQuMTguNDk0NVwiLFwiaW1laVwiOlwiODY5Nzg1MDM1MjY3MDE4XCJ9In19";
        String str=new String(Base64.decodeBase64(base64.getBytes()));

        HashMap<String,String>map=new HashMap<>();
        map.put("Accept","application/json, text/plain, */*");
        map.put("Origin","https://ti.qq.com");
        map.put("User-Agent","Mozilla/5.0 (Linux; Android 10; MI 8 UD Build/QKQ1.190828.002; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/77.0.3865.120 MQQBrowser/6.2 TBS/045410 Mobile Safari/537.36 V1_AND_SQ_8.4.10_1524_YYB_D QQ/8.4.10.4875 NetType/WIFI WebP/0.3.0 Pixel/1080 StatusBarHeight/90 SimpleUISwitch/0 QQTheme/1000 InMagicWin/0");
        map.put("Sec-Fetch-Mode","cors");
        map.put("Content-Type","application/json;charset=UTF-8");
        map.put("X-Requested-With","com.tencent.mobileqq");
        map.put("Sec-Fetch-Site","same-origin");
        map.put("Referer","https://ti.qq.com/signin/public/index.html?_wv=1090528161&_wwv=13");
        map.put("Accept-Encoding","gzip, deflate, br");
        map.put("Accept-Language","zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7");

        map.put("Cookie",qqEmp.getCookies());
        map.put("Q-UA2","QV=3&PL=ADR&PR=QQ&PP=com.tencent.mobileqq&PPVN=8.4.18&TBSVC=43957&CO=BK&COVC=045410&PB=GE&VE=GA&DE=PHONE&CHID=0&LCID=9422&MO= MI8UD &RL=1080*2029&OS=10&API=29");
        map.put("Q-GUID","5caf654cd868c033862b06fc13b788cb");
        map.put("Q-QIMEI","869785035267018");
        map.put("Q-Auth","31045b957cf33acf31e40be2f3e71c5217597676a9729f1b");
        HashMap<String, String> result = Warma.post(url, str, map);

        String res = result.get("result");
        if(res.contains("\"retCode\":0")){
            return qqEmp.getMyqq()+" QQ:签到成功！";
        }else if(res.contains("\"retCode\":1")){
            return qqEmp.getMyqq()+" QQ:已经签到过了！";
        }else{
            return qqEmp.getMyqq()+" QQ:签到失败!\n"+res;
        }
    }
}
