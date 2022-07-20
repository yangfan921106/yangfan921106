package com.util;

/**
 * @ClassName Calculator
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/13 20:41
 */
public class Calculator {
    public static int result = 0;

    public static int add(int x,int y){
        int result = x+y;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Float fadd(float x,float y){
        Float result = x+y;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int count(int x) throws InterruptedException {
        int i = result;
        Thread.sleep(1000);
        result = i+x;
        return result;

    }

    public synchronized static int syncount(int x) throws InterruptedException {
        int i = result;
        Thread.sleep(1000);
        result = i+x;
        return result;

    }

    //跟上面的内容相比加了一个代码锁，这样子可以避免脏读的问题，分布式线程的脏读。
    public synchronized static int synCount(int x) throws InterruptedException {
        int i = result;
        Thread.sleep(1000);
        result = i+x;
        return result;

    }

    public static int sub(int x,int y){
        //将result定义为自己方法内部的局部变量，可以解决多线程都用result相互干扰的问题
        int result = x-y;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static int mul(int x,int y){
        result = x*y;
        return result;
    }
    public static int div(int x,int y){
        result = x/y;
        return result;
    }

    public static void clear(){
        result = 0;
        System.out.println("当前结果已清零！");
    }
}
