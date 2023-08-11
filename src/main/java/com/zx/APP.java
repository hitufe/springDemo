package com.zx;

import com.alibaba.fastjson.JSON;
import com.zx.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class APP {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        MyService myService = (MyService) context.getBean("myService");
        Object testObj = myService.getData(12, "sds");
        String testString = JSON.toJSONString(testObj);
        log.info(testString);
    }
}
