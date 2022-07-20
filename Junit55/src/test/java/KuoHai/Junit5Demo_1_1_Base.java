package KuoHai;

import com.util.Calculator;
import org.junit.jupiter.api.Test;

/**
 * 1.基础脚本分别执行了加减乘除，计数器操作，并打印了结果。
 *
 */

/**
 * @ClassName Junti5Demo_1_1_Base
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/11 11:04
 */
public class Junit5Demo_1_1_Base {
    @Test
    public void addTest(){
            int result = Calculator.add(2,4);
            System.out.println(result);
        }
        @Test
    public void subTest(){
        int result = Calculator.sub(4,2);
            System.out.println(result);
        }
        @Test
    public void mulTest(){
        int result = Calculator.mul(3,5);
            System.out.println(result);
        }
        @Test
    public void divTest(){
        int result = Calculator.div(8,2);
            System.out.println(result);
        }
        @Test
    public void countTest() throws InterruptedException {
        int result = Calculator.count(6);
            result = Calculator.count(6);
            result = Calculator.count(6);
            result = Calculator.count(6);
            System.out.println(result);
        }

    }

