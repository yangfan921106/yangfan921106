package KuoHai;

import com.util.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 2.优化点：添加自动断言，解决了需要人工检查结果的问题。
 *
 */

/**
 * @ClassName Junit5Demo_2_1_Assert
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/11 13:48
 */
public class Junit5Demo_2_1_Assert {
    @Test
    public void addTest(){
        int result = Calculator.add(2,4);
        System.out.println(result);
        assertEquals(6,result,"实际值与预期值不符！");
    }
    @Test
    public void subTest(){
        int result = Calculator.sub(4,2);
        System.out.println(result);
        assertEquals(2,result,"实际值与预期值不符！");
    }
    @Test
    public void mulTest(){
        int result = Calculator.mul(3,5);
        System.out.println(result);
        assertEquals(15,result,"实际值与预期值不符！");
    }
    @Test
    public void divTest(){
        int result = Calculator.div(8,2);
        System.out.println(result);
        assertEquals(4,result,"实际值与预期值不符！");
    }
    @Test
    public void countTest() throws InterruptedException {
        int result = Calculator.count(6);
        result = Calculator.count(6);
        result = Calculator.count(6);
        result = Calculator.count(6);
        System.out.println(result);
        assertEquals(24,result,"实际值与预期值不符！");
    }

}
