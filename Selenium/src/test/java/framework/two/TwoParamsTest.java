package framework.two;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @ClassName ParamsTest2
 * @Description TODO
 * @Author yangfan
 * @Date 2022/4/13 14:13
 */
public class TwoParamsTest {

    @ParameterizedTest
    @MethodSource()
    void search(String keyword){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://ceshiren.com");
        driver.findElement(By.id("search-button")).click();
        driver.findElement(By.id("search-term")).sendKeys(keyword);
    }

    static Stream<String> search(){
        return Stream.of("apple","banana","orange");
    }
}
