package com.oracle.listener;

import com.oracle.data.ServiceEntity;
import com.oracle.pojo.NewsCatalog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CommonListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("root",sc.getContextPath());
        sc.setAttribute("css",sc.getContextPath()+"/resources/css");
        sc.setAttribute("js",sc.getContextPath()+"/resources/js");
        sc.setAttribute("img",sc.getContextPath()+"/resources/images");
        sc.setAttribute("kindeditor",sc.getContextPath()+"/resources/kindeditor");
        sc.setAttribute("lib",sc.getContextPath()+"/resources/lib");

        /*ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext-root.xml");
        ServiceEntity<NewsCatalog> serviceEntity = (ServiceEntity<NewsCatalog>) ac.getBean("newsCatalogServiceImpl");
        sc.setAttribute("newsCataList",serviceEntity.getListData());*/

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
