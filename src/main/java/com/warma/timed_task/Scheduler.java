package com.warma.timed_task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    @Scheduled(cron = "0 45 5 * * ? ")
    public void cloudLearning(){
        System.out.println("哈哈哈哈哈哈哈");
    }
}
