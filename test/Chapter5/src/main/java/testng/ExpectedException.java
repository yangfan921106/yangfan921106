package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {

    /*审核时候用到？
    在我们期望结果为某一个异常的时候
    我们传入了某些不合法的参数，程序抛出了异常
    也就是说我的预期结果就是这个异常
     */


    //失败的
    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeExceptionfailed(){
        System.out.println("这是一个失败的异常测试");
    }

    //成功的
    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeExceptionsuccess(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();
    }
}
