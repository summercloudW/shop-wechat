package com.wy.shop.autotask;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author : WangYB
 * @time: 2020/11/21  16:27
 */
@Service
public class OrderScheduler {

    public static final Integer COUNT=0;

    public void doScheduleTask() throws SchedulerException {
        //利用工厂创建一个任务调度器
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        //构建一个job
        JobDetail job = JobBuilder.newJob(CancelledOrderTask.class)
                .withIdentity("cancelledOrder", "CancelledOrderGroup")
                .build();
        //构建一个trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("cancelledOrderTrigger", "cancelledOrderTriggerGroup")
                .startAt(new Date(new Date().getTime() + 18000))
//                .withSchedule(SimpleScheduleBuilder
//                        .simpleSchedule()
//                        .withIntervalInSeconds(2)
//                        .withRepeatCount(COUNT))
                .build();

//        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
//                .usingJobData("trigger1", "这是jobDetail1的trigger")
//                .startNow()//立即生效
//                .startAt(startDate)
//                .endAt(endDate)
//                .withSchedule(CronScheduleBuilder.cronSchedule("* 30 10 ? * 1/5 2018"))
//                .build();

        scheduler.scheduleJob(job,trigger);
        scheduler.start();
    }

}
