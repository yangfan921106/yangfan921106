package KuoHai;

import com.util.Calculator;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName Junit5Demo_4_2_MixParallel
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/13 15:41
 */
public class Junit5Demo_4_2_MixParallel {
    @RepeatedTest(10)
    public void addTest(){
        int result = Calculator.add(2,4);
        System.out.println(result);
        assertEquals(6,result,"实际值与预期值不符！");
    }
    @RepeatedTest(10)
    public void subTest(){
        int result = Calculator.sub(4,2);
        System.out.println(result);
        assertEquals(2,result,"实际值与预期值不符！");
    }
}
