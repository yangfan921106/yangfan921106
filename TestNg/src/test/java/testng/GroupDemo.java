package testng;

import org.testng.annotations.Test;

/**
 * @ClassName GroupDemo
 * @Description TODO
 * @Author yangfan
 * @Date 2021/12/30 17:52
 */
public class GroupDemo {
    @Test(groups = {"group1"})
    public void fun1(){
        System.out.println("组装坚果1号");
    }

    @Test(groups = {"group1"})
    public void fun2(){
        System.out.println("组装坚果2号");
    }

    @Test(groups = {"group1","group2"})
    public void fun3(){
        System.out.println("组装坚果3号");
    }

    @Test(groups = {"group2"})
    public void fun4(){
        System.out.println("组装坚果4号");
    }

    @Test(groups = {"group2"})
    public void fun5(){
        System.out.println("组装坚果5号");
    }
}
