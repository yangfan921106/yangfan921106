package KuoHai;

import com.util.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * @ClassName TestNgDemo_1_1_SoftAssert
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/14 12:35
 */
public class TestNgDemo_1_1_SoftAssert {

    @BeforeMethod
    public void Clear(){
        Calculator.clear();
    }


    @Test
    public void addTest(){
        SoftAssert assertion = new SoftAssert();
        int result01 = Calculator.add(2, 4);
        System.out.println(result01);
        assertion.assertEquals(result01, 8);
        int result02 = Calculator.add(2, 4);
        System.out.println(result01);
        assertion.assertEquals(result02, 9);
        int result03 = Calculator.add(2, 4);
        System.out.println(result01);
        assertion.assertEquals(result03, 6);
        assertion.assertAll();
    }
}
