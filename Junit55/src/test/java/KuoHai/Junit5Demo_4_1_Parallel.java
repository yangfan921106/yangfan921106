package KuoHai;

import com.util.Calculator;
import org.junit.jupiter.api.RepeatedTest;

/**
 * @ClassName Junit5Demo_4_1_Parallel
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/12 12:36
 */
public class Junit5Demo_4_1_Parallel {
    @RepeatedTest(10)
    public void countTest() throws InterruptedException {
        int result = Calculator.count(6);
        System.out.println(result);
    }

    @RepeatedTest(10)
    public void countSynTest() throws InterruptedException {
        int result = Calculator.synCount(6);
        System.out.println(result);
    }
}
