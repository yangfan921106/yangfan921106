package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass2 {
    public void stu3(){
        System.out.println("GroupsOnClass2中的stu3执行");
    }

    public void stu4(){
        System.out.println("GroupsOnClass2中的stu4执行");
    }
}
