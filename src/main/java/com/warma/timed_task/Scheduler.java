package com.warma.timed_task;

import com.warma.timed_task.app.CloudLearning;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    //实习签到
    @Scheduled(cron = "0 0 9 * * ? ")
    public void cloudLearning(){
        new CloudLearning().start();
    }
}
