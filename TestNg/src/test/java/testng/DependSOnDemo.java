package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @ClassName DependSOnDemo
 * @Description TODO
 * @Author yangfan
 * @Date 2021/12/31 12:20
 */
public class DependSOnDemo {

    @Test
    public void fun1() {
        System.out.println("坚果A装配成功 \n");
    }

    @Test(dependsOnMethods = {"fun1"})
    public void fun2() throws Exception{
        System.out.println("坚果B装配成功 \n");
        Assert.fail("装配发生错误！");
    }

    @Test(dependsOnMethods = {"fun2"})
    public void fun3() throws Exception{
        System.out.println("坚果C装配成功 \n");
    }
}
