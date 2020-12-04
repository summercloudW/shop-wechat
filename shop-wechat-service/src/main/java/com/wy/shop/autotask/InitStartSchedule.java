package com.wy.shop.autotask;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author : WangYB
 * @time: 2020/12/2  11:01
 */
@Component
public class InitStartSchedule implements CommandLineRunner {



    @Autowired
    private MyJobFactory myJobFactory;

    @Override
    public void run(String... args) throws Exception {

        /**
         * 用于程序启动时加载定时任务，并执行已启动的定时任务(只会执行一次，在程序启动完执行)
         */
        //查询job状态为启用的
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("jobStatus", "1");
        // 对 scheduler  注入 myJobFactory ，让我们的job能调度 service 方法
        // 通过SchedulerFactory获取一个调度器实例
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        // 如果不设置JobFactory，Service注入到Job会报空指针
        scheduler.setJobFactory(myJobFactory);    //  *********************  一定要注入我们的bean，才能调用到spring的bean。
        // 启动调度器
        scheduler.start();

        //构建一个job
        JobDetail job = JobBuilder.newJob(CancelledOrderTask.class)
                .withIdentity("cancelledOrder", "CancelledOrderGroup")
                .build();

        //构建一个trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("cancelledOrderTrigger", "cancelledOrderTriggerGroup")
                .startNow()
                .withSchedule(SimpleScheduleBuilder
                        .repeatMinutelyForever(1)
                )
                .build();

        scheduler.scheduleJob(job,trigger);

    }


}
