package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * @ClassName AfterMethod
 * @Description TODO
 * @Author yangfan
 * @Date 2021/12/30 17:11
 */
public class AfterMethod1 {

    @Test
    public void fun1(){
        System.out.println("组装坚果1号");
    }

    @Test
    public void fun2(){
        System.out.println("组装坚果2号");
    }

    @Test
    public void fun3(){
        System.out.println("组装坚果3号");
    }

    @Test
    public void fun4(){
        System.out.println("组装坚果4号");
    }

    @Test
    public void fun5(){
        System.out.println("组装坚果5号");
    }

    @AfterMethod
    public void fun6(){
        System.out.println("质检员检查");
    }





}
