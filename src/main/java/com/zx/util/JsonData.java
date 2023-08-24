package com.zx.util;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 服务器返回给客户端的JSON格式的数据
 */
@Getter
@Setter
public class JsonData extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = -8855960778711040221L;
    private int code;
    private String msg;
    private Object result;

    public JsonData(int code, String msg, Object result) {
        super();
        this.put("code", code);
        this.put("msg", msg);
        this.put("result", result);
    }

    public JsonData() {
        super();
    }

}