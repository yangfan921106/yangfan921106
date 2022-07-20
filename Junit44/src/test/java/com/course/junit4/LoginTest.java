package com.course.junit4;

import org.junit.Test;

/**
 * @ClassName LoginTest
 * @Description TODO
 * @Author yangfan
 * @Date 2021/12/30 15:22
 */
public class LoginTest extends BaseTest{
    @Test
    public void login(){
        dataMap.put("login","登录成功");
        System.out.println(dataMap.get("login"));

    }


}
