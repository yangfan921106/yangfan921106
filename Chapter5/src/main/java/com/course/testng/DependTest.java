package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {

    @Test
    public void test1(){
        System.out.println("test1 run");
    }

    //2依赖于1,1成功了，所以2也跟着执行了
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");
    }

    @Test
    public void test3(){
        System.out.println("test3 run failed");
        throw new RuntimeException();
    }

    //4依赖于3,3失败了，所以4被忽略了
    @Test(dependsOnMethods = {"test3"})
    public void test4(){
        System.out.println("test4 run");
    }
}
