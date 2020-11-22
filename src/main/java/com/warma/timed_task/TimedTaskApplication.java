package com.warma.timed_task;

import com.warma.timed_task.app.CloudLearning;
import com.warma.timed_task.app.QQSignIn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TimedTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(TimedTaskApplication.class, args);
        //new QQSignIn().start();
        new CloudLearning().start();
    }
}
