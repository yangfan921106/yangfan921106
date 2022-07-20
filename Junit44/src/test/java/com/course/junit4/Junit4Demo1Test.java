package com.course.junit4;

import org.junit.*;

/**
 * @ClassName Junit4Demo1Test
 * @Description junit的注解
 * @Author yangfan
 * @Date 2021/12/29 20:22
 */
public class Junit4Demo1Test {

    @BeforeClass
    public static void BeforeClass(){
        System.out.println("这是注解beforeclass的输出");
    }

    @Before
    public void Before(){
        System.out.println("这是注解before的输出");
    }

    @Test
    public void fun1(){
        System.out.println("注解test的输出111");
    }

    @Test
    public void fun2(){
        System.out.println("注解test的输出222");
    }


    //加了ignore的话，单独跑这个方法是可以执行的，跑一整个类的话这里就会被忽略掉，不跑。
    @Test
    public void fun3(){
        System.out.println("注解test的输出333");
    }

    @After
    public void After(){
        System.out.println("这是after的输出");
    }

    @AfterClass
    public static void AfterClass(){
        System.out.println("这是注解afterclass的输出");
    }
}
