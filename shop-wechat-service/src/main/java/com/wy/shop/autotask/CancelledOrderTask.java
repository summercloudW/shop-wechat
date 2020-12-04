package com.wy.shop.autotask;

import com.wy.shop.service.OrderService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;

/**
 * @author : WangYB
 * @time: 2020/11/21  16:31
 */

public class CancelledOrderTask implements Job {

    public static final Logger log = LoggerFactory.getLogger(CancelledOrderTask.class);
    private ApplicationContext applicationContext;

    @Autowired
    private OrderService orderService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info(">>>>>>>>>开始执行任务");
        orderService.updateOutTimeOrder();
    }


}
