package com.zhipingok.skatch.serverhi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceHiController {

    private static Logger log = LoggerFactory.getLogger(ServiceHiController.class);
    @Value("${server.port}")
    String port;


    @RequestMapping("/hi")
    public String home(@RequestParam String name) {

        log.info("invoke hi fun");

        return "hi "+name+",i am from port:" +port;
    }

}
