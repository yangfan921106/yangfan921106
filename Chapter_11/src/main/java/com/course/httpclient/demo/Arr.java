package com.course.httpclient.demo;

import lombok.Data;

@Data
public class Arr {


    private String apiName;
    private String apinumber;
// 实体生成get set 方法 用lombok.Data 注解代替
    public void setApiName(String str) {
        apiName = str;
    }
}
