package KuoHai;

import com.util.Calculator;
import org.testng.annotations.Test;

/**
 * @ClassName TestNgDemo_5_1_Parrallel
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/14 13:53
 */
public class TestNgDemo_5_1_Parrallel {


    //多线程
    @Test(threadPoolSize = 3,invocationCount = 21,timeOut = 100000)
    public void countTest() throws InterruptedException {
        int result = Calculator.count(5);
        System.out.println("计算出的结果为：  "+result);
    }

    @Test(threadPoolSize = 3,invocationCount = 21,timeOut = 100000)
    public void synccountTest() throws InterruptedException {
        int result = Calculator.syncount(5);
        System.out.println("计算出的结果为：  "+result);
    }
}
