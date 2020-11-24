package com.warma.timed_task;

import com.warma.timed_task.app.CloudLearning;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan
public class TimedTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(TimedTaskApplication.class, args);
        new CloudLearning().start();
    }
}
