package com.oracle.appliaction.mobile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-root.xml");
        ((ClassPathXmlApplicationContext) ac).start();
    }
}
