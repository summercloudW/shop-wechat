package com.wy.shop.autotask;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.annotation.Bean;

/**
 * @author : WangYB
 * @time: 2020/11/21  16:31
 *
 */
public class CancelledOrderTask implements Job {

    public void sendEmail() {
        System.out.println("发送了一封邮件");
    }


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        sendEmail();
    }


//    @Bean
//    public com.wy.shop.service.quartz.MyTask getTask() {
//        return new com.wy.shop.service.quartz.MyTask();
//    }
//

}
