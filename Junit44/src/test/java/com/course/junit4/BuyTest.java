package com.course.junit4;

import org.junit.Test;

/**
 * @ClassName BuyTest
 * @Description TODO
 * @Author yangfan
 * @Date 2021/12/30 15:22
 */
public class BuyTest extends BaseTest{

    @Test
    public void buy(){
        if(dataMap.get("login").equals("登录成功")){
            System.out.println("登录成功，可以购物");
        }
        else {
            System.out.println("请登录后再试！");
        }
    }
}
