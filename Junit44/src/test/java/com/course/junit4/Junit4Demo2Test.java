package com.course.junit4;

import org.junit.Test;

/**
 * @ClassName Junit4Demo2Test
 * @Description TODO
 * @Author yangfan
 * @Date 2021/12/30 10:45
 */


public class Junit4Demo2Test {
    @Test
    public void fun4(){
        System.out.println("注解test的输出444");
    }

    @Test
    public void fun5(){
        System.out.println("注解test的输出555");
    }


    //加了ignore的话，单独跑这个方法是可以执行的，跑一整个类的话这里就会被忽略掉，不跑。
    @Test
    public void fun6(){
        System.out.println("注解test的输出666");
    }




}
