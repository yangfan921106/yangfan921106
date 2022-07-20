package framework.one;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ParamsTest
 * @Description 这个是最简单的参数化
 * @Author yangfan
 * @Date 2022/4/13 14:06
 */
public class OneParamsTest {

    @ParameterizedTest
    @ValueSource(strings = {"apple","banana","orange"})
    void search(String keyword){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://ceshiren.com");
        driver.findElement(By.id("search-button")).click();
        driver.findElement(By.id("search-term")).sendKeys(keyword);

    }

}
