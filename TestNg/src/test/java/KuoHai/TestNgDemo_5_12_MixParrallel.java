package KuoHai;

import com.util.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @ClassName TestNgDemo_5_12_MixParrallel
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/17 12:09
 */
public class TestNgDemo_5_12_MixParrallel {

    //多线程
    @Test(threadPoolSize = 3,invocationCount = 15,timeOut = 100000)
    public void addTest() throws InterruptedException {
       int  result = Calculator.add(1, 2);
        System.out.println("计算出的结果为：  "+result);
        Assert.assertEquals(3, result,"与期望结果不一致");

    }

    //多线程
    @Test(threadPoolSize = 3,invocationCount = 15,timeOut = 100000)
    public void subTest() throws InterruptedException {
       int  result = Calculator.sub(6, 2);
        System.out.println("计算出的结果为：  "+result);
        Assert.assertEquals(4, result,"与期望结果不一致");

    }


}
