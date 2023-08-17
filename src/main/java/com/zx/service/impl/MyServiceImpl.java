package com.zx.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zx.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@Service
public class MyServiceImpl implements MyService {
    @Override
    public Object getData(Number num, String name) {

        String responseString = "你的姓名为： " + name;
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("newNum", num);
        responseMap.put("newName", responseString);
        JSONObject respObj = new JSONObject(responseMap);
        log.info("serviceDone");
        return respObj;
    }
}
