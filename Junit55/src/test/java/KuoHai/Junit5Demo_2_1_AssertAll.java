package KuoHai;

import com.util.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 优化断言，之前的单个断言，在一个方法里面，只要有一个失败了，后面的代码将不会被执行；优化后使用assertall，所有代码都会被执行，可以打印出所有断言不对的数据。
 *
 */

/**
 * @ClassName Junit5Demo_2_1_AssertAll
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/11 14:28
 */
public class Junit5Demo_2_1_AssertAll {

    //优化前的效果：只要有一个断言失败了，后面的代码就不会被执行了。
    /*@Test
    public void addTest(){
        int result01 = Calculator.add(2,4);
        System.out.println(result01);
        assertEquals(6,result01,"实际值与预期值不符！");


        int result02 = Calculator.add(2,5);
        System.out.println(result02);
        assertEquals(6,result02,"实际值与预期值不符！");


        int result03 = Calculator.add(2,6);
        System.out.println(result03);
        assertEquals(6,result03,"实际值与预期值不符！");
    }
    */



    //优化之后的断言，之前是只要有一个断言失败了，后面的代码就不会被执行了
    @Test
    @Order(1)
    public void addTest02(){
        final int result01 = Calculator.add(2,4);
        System.out.println(result01);

        final int result02 = Calculator.add(2,5);
        System.out.println(result02);

        final int result03 = Calculator.add(2,6);
        System.out.println(result03);

        assertAll(
                "计算结果校验：",
        ()-> assertEquals(6,result01),
            ()-> assertEquals(6,result02),
            ()-> assertEquals(6,result03)
        );
    }

    @Test
    @Order(2)
    public void subTest(){
        int result = Calculator.sub(4,2);
        System.out.println(result);
        assertEquals(2,result,"实际值与预期值不符！");
    }
    @Test
    @Order(3)
    public void mulTest(){
        int result = Calculator.mul(3,5);
        System.out.println(result);
        assertEquals(15,result,"实际值与预期值不符！");
    }
    @Test
    @Order(4)
    public void divTest(){
        int result = Calculator.div(8,2);
        System.out.println(result);
        assertEquals(4,result,"实际值与预期值不符！");
    }


    //避免重复写代码，可以加一个beforeeach的注解
    /*@Test
    @Order(5)
    public void clear(){
        Calculator.clear();
    }*/

    @BeforeEach
    public void clear(){
        Calculator.clear();
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
