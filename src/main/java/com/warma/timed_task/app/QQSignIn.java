package com.warma.timed_task.app;

import com.warma.timed_task.utils.Warma;

import java.util.Base64;
import java.util.HashMap;

public class QQSignIn {
    public String start(){
        //QQ签到
        String url="https://ti.qq.com/hybrid-h5/api/json/daily_attendance/SignIn";
        String base64="eyJ1aW4iOiIyNDUzODg1NDI4IiwidHlwZSI6MSwic0lkIjoiIiwicXVhIjoiVjFfQU5EX1NRXzguNC4xOF8xNTU4X1lZQl9EIiwibXBFeHRlbmQiOnsiMV9kYWlseUdkdERldmljZV9pbmZvIjoie1wiYWlkX3RpY2tldFwiOlwiMDFFMDZFQjQzNjBENzY0NzZBQkEwMkFDMUFDNkUwOEIwRjYwMUQ0Q0IwMDZEQTRFNjZcIixcImFwcF92ZXJzaW9uX2lkXCI6NTM3MDY2NDIzLFwiYnJhbmRcIjpcIlhpYW9taVwiLFwiY2Fycmllcl9jb2RlXCI6NDYwMDEsXCJjbGllbnRfaXB2NFwiOlwiMTcxLjM2LjE2LjE1NVwiLFwiY29ublwiOjEsXCJkZXZpY2VfYnJhbmRfYW5kX21vZGVsXCI6XCJNSSA4IFVEXCIsXCJkZXZpY2VfZXh0XCI6XCJ7XFxcIndlY2hhdF9pbnN0YWxsZWRfaW5mb1xcXCI6e1xcXCJoYXNfdW5pdmVyc2FsX2xpbmtcXFwiOmZhbHNlLFxcXCJhcGlfdmVyXFxcIjpcXFwiNjU0MzE2NjAwXFxcIixcXFwiaW5zdGFsbGVkXFxcIjpmYWxzZX0sXFxcImF0dHJpX2luZm9cXFwiOntcXFwidWFcXFwiOlxcXCJEYWx2aWtcXFxcLzIuMS4wIChMaW51eDsgVTsgQW5kcm9pZCAxMDsgTUkgOCBVRCBNSVVJXFxcXC8yMC45LjQpXFxcIixcXFwidXVpZFxcXCI6e1xcXCJtXFxcIjpcXFwiNjg2QUU1OTkzQ0Y4MjA2MEYxQzU2RkRBQzA5OTZDRDJcXFwiLFxcXCJ2XFxcIjoxLFxcXCJ0XFxcIjpcXFwiMTU5ODE5OTI4MzI1MlxcXCIsXFxcInVcXFwiOlxcXCIyZWE1YmRhZi03Mzk4LTQ1YjQtYmM1Ni00MGZiMmFjM2YyMDlcXFwifX0sXFxcIm1xcV9jb25maWdfc3RhdHVzXFxcIjoxLFxcXCJhcHBfc3RhdHVzXFxcIjp7fSxcXFwicWFpZF9pbmZvXFxcIjp7fX1cIixcImlzX2dvb2dsZXBsYXlfdmVyc2lvblwiOmZhbHNlLFwibG9jYXRpb25cIjp7fSxcIm1hbnVmYWN0dXJlclwiOlwiWGlhb21pXCIsXCJtZDVfYW5kcm9pZF9pZFwiOlwiOTAzYjhjZjNjNTM5NjQ4OTE2YjQxYjg5NzQwODNhZTBcIixcIm11aWRfdHlwZVwiOjAsXCJvcmlnaW5fbmV0d29ya190eXBlXCI6MTMsXCJvc190eXBlXCI6MixcIm9zX3ZlclwiOlwiMTBcIixcInFxX3ZlclwiOlwiOC40LjE4XCIsXCJ0YWlkX3RpY2tldFwiOlwiMDEwMTg2OUY2REQwQkU5MjUyNEVBOEExRTg0RTM3RUZBMjk4NzEyQjA3QzY2ODdGNkM0QTk3MzkzRUNGQ0QyQjBBNTc1REM4RURDMUQzQTY1Q0RCRDA4QlwifSIsInRpYW5zaHVBZHNSZXEiOiJ7XCJhcHBcIjpcIlFRXCIsXCJvc1wiOlwiQU5EXCIsXCJ2ZXJzaW9uXCI6XCI4LjQuMTguNDk0NVwiLFwiaW1laVwiOlwiODY5Nzg1MDM1MjY3MDE4XCJ9In19";
        String str=new String(Base64.getDecoder().decode(base64));

        HashMap<String,String>map=new HashMap<>();
        map.put("Connection","keep-alive");
        map.put("Content-Length","1272");
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

        map.put("Cookie","uin=o2453885428; skey=MvmUjKDmW1; p_uin=o2453885428; qq_locale_id=2052; p_skey=YaJXigHt-sFHRfzIVggSJX7LZU9oi7nelXMw0nVPL2s_; a2=EABEEE1E531CC0389227836954BDC71989D9A54D20C2B03AFC51BBDBC83EB3262FB289F1AA0400CA547ADA2828183C0B369CD7BACE8A17E752D53EE92389C21C31E112EAFD0E59AD");
        map.put("Q-UA2","QV=3&PL=ADR&PR=QQ&PP=com.tencent.mobileqq&PPVN=8.4.10&TBSVC=43957&CO=BK&COVC=045410&PB=GE&VE=GA&DE=PHONE&CHID=0&LCID=9422&MO= MI8UD &RL=1080*2029&OS=10&API=29");
        map.put("Q-GUID","5caf654cd868c033862b06fc13b788cb");
        map.put("Q-QIMEI","869785035267018");
        map.put("Q-Auth","31045b957cf33acf31e40be2f3e71c5217597676a9729f1b");
        HashMap<String, String> result = Warma.post(url, str, map);
        System.out.println(result.get("result"));
        if(result.get("result").contains("\"retCode\":0")){
            return "QQ:签到成功！";
        }else if(result.get("result").contains("\"retCode\":1")){
            return "QQ:已经签到过了！";
        }else{
            return "QQ:签到失败!";
        }
    }
}
