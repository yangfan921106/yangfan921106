package KuoHai;

import com.util.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @ClassName TestNgDemo_1_1_Base
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/14 9:44
 */
public class TestNgDemo_1_1_Base {

    @BeforeMethod
    public void Clear(){
        Calculator.clear();
    }

    @Test
    public void AddTest(){
        int result = Calculator.add(2, 4);
        System.out.println(result);
        Assert.assertEquals(6, result,"与期望结果不一致");
    }

    @Test
    public void SubTest(){
        int result = Calculator.sub(6, 2);
        System.out.println(result);
        Assert.assertEquals(4, result,"与期望结果不一致");
    }

    @Test
    public void MulTest(){
        int result = Calculator.mul(3, 5);
        System.out.println(result);
        Assert.assertEquals(15, result,"与期望结果不一致");
    }

    @Test
    public void DivTest(){
        int result =Calculator.div(15, 3);
        System.out.println(result);
        Assert.assertEquals(5, result,"与期望结果不一致");
    }

    @Test
    public void CountTest() throws InterruptedException {
        int result = Calculator.count(5);
        result = Calculator.count(5);
        result = Calculator.count(5);
        result = Calculator.count(5);
        result = Calculator.count(5);
        System.out.println(result);
        Assert.assertEquals(25, result,"与期望结果不一致");

    }
}
