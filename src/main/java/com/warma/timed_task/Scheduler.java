package com.warma.timed_task;

import com.warma.timed_task.app.CloudLearning;
import com.warma.timed_task.app.QQSignIn;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    //实习签到
    @Scheduled(cron = "0 0 9 * * ? ")
    public void cloudLearning(){
        new CloudLearning().start();
    }
    //QQ签到
    @Scheduled(cron = "0 5 0 * * ? ")
    public void qq(){
        new QQSignIn().start();
    }
}
