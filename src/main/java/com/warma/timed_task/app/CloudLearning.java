package com.warma.timed_task.app;

import com.warma.timed_task.module.Emp;
import com.warma.timed_task.service.EmpService;
import com.warma.timed_task.utils.Mail;
import com.warma.timed_task.utils.Warma;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.List;

@Component
public class CloudLearning {

    @Resource(name = "empServiceImple")
    EmpService empService;

    public static CloudLearning cloudLearning;

    @PostConstruct
    public void init() {
        cloudLearning = this;
    }

    public void start(){
        StringBuilder str=new StringBuilder();
        List<Emp> allEmp = cloudLearning.empService.findAllEmp();
        for (Emp emp : allEmp) {
            String result = run(emp);
            str.append(result).append("\n\n").append("-----------------------------------------\n\n");
        }
        Mail.sendEmail("2453885428@qq.com","实习签到结果",str.toString());
    }
    public static String run(Emp emp){

        String account=emp.getAccount();
        String passwrod=emp.getPassword();
        String name=emp.getName();

        String address=Warma.urlEncoder(emp.getAddress());

        String path="C:/wwwroot/SpringBootApplication/TimedTask/imageFiles";
        File[] files = new File(path).listFiles();
        int random = Warma.Random(0, files.length);
        File file = files[random];

        String image=Warma.imageToBase64(file.getPath());
        image=Warma.urlEncoder(image);

        String url_login="http://sx.lcvc.cn/mobile/common/login.xhtml";
        String str_login="account="+account+"&apassword="+ Warma.getMD5String(passwrod)+"&atype=2";

        HashMap<String,String> ret= Warma.post(url_login,str_login,new HashMap<>());
        if(ret.get("result").contains("-2")){
            return "登录失败:"+name+" "+account;
        }else{

            JSONObject json = new JSONObject(ret.get("result"));

            String luid = json.getString("luid");
            String ltoken = json.getString("ltoken");

            HashMap<String, String> getPid = Warma.post("http://sx.lcvc.cn/mobile/training/s_practice.xhtml", "uid=" + luid + "&token=" + ltoken, new HashMap<>());

            String pid = Warma.regex("\"id\":([^\"]+),",getPid.get("result")).trim();

            String str_qd="pid="+pid+"&uid="+luid+"&token="+ltoken+"&action=qdadd&address="+address+"&jd=108.28913"+Warma.Random(0, 9)+"&wd=22.86930"+Warma.Random(0, 9)+"&acontent="+image;

            String url_qd="http://sx.lcvc.cn/mobile/training/s_practice_qd.xhtml";

            HashMap<Object, Object> map = new HashMap<>();
            map.put("Accept","application/json");
            map.put("X-Requested-With","XMLHttpRequest");
            map.put("Content-Type","application/x-www-form-urlencoded");
            map.put("Cookie","");

            HashMap<String,String> result= Warma.post(url_qd,str_qd,new HashMap<>());
            assert result != null;
            if(result.get("result").contains("1")){
                return "签到完成:"+name+" "+account;
            }else{
                return "签到失败："+name+" "+account+"\n错误："+result.get("result");
            }
        }
    }
}
