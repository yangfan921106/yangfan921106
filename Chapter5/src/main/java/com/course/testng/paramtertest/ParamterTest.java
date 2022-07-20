package com.course.testng.paramtertest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterTest {

    @Test
    @Parameters({"name","age"})
    public void paramtertest(String name,int age){
        System.out.println("name = "+ name + "; age = " + age);

    }

    @Test
    @Parameters({"name1","age1"})
    public void paramtertest2(String name1,int age1){
        System.out.println("name1 = " + name1 + "; age1 = " + age1);
    }
}
