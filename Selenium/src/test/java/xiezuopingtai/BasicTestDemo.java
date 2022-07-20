package xiezuopingtai;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName BasicTestDemo
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/27 12:33
 */
public class BasicTestDemo {
    public static WebDriver driver;


    @BeforeAll
    public static void initData() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void TearDown() {
        driver.quit();
        System.out.println("网站成功退出");
    }

}
