package com.wy.shop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author : WangYB
 * @time: 2020/12/2  10:22
 */
@WebListener
public class AutoTaskListener implements ServletContextListener {



    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("OneListener init ...");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
