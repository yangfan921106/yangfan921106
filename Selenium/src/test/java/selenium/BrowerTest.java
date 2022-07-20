package selenium;

import org.junit.jupiter.api.Test;

/**
 * @ClassName BrowerTest
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/27 15:25
 */
public class BrowerTest extends BaseTestDemo{
    @Test
    public void BrowerTest(){
        driver.get("https://www.baidu.com/");
    }

}
