package KuoHai;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @ClassName EvnTest
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/13 20:42
 */
public class EvnTest {
    @Test
    public void testIntAdd(){
        System.out.println("测试两个int类的和是否正确");
        Assert.assertEquals(2, 3);
    }

}
