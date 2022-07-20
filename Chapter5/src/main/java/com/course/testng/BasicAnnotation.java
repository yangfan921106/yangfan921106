package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
       System.out.println("TEST这是测试用例1");
    }

    @Test
    public void testCase2(){
        System.out.println("TEST这是测试用例2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod这是在方法之前运行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("aftermethod这是在方法之后运行的");
    }

    @BeforeClass
    public void beforeclass(){
        System.out.println("beforeclass这是在类之前运行的");
    }

    @AfterClass
    public void afterclass(){
        System.out.println("afterclass这是在类之后运行的");
    }

    //这是在类之前运行的
    @BeforeSuite
    public void beforesuite(){
        System.out.println("beforesuite测试套件");
    }

    //这是在类之后运行的
    @AfterSuite
    public void aftersuite(){
        System.out.println("aftersuite测试套件");
    }
}
