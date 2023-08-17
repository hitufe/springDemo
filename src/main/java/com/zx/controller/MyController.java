package com.zx.controller;

import com.alibaba.fastjson.JSONObject;
import com.zx.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/home")
public class MyController {
    @Autowired
    private MyService myService;
    //添加一个日志器


    //映射一个action
    @RequestMapping("/index")
    public String index(){
        //输出日志文件
//        Logger logger =  LoggerFactory.getLogger(MyController.class);
        log.info("the first jsp pages");
        //返回一个index.jsp这个视图
        return "woshinini";
    }

    @ResponseBody
    @RequestMapping(value = "/zx", produces = {"application/json;charset=UTF-8"})
    public Object getData(Number num, String name){
        JSONObject responseJson = new JSONObject();
        try {
            responseJson = (JSONObject) myService.getData(num, name);

        } catch (Exception e) {
            log.error("e" + e);
            responseJson.put("code", 500);
            responseJson.put("status", "failed");
            return responseJson.toJSONString();
        }
        log.info("controllerDone");
        return responseJson.toJSONString();
    }

}
