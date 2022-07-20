package selenium;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
/** @ClassName JsTestDemo @Description TODO @Author yangfan @Date 2022/1/27 15:47 */
public class JsTestDemo {
    public static WebDriver driver;
    @BeforeAll
    public static void initData() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void jsTest(){
        try {
            driver.get("http://www.12306.cn/index/");
            JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
            //将时间控件的值置为2021-12-30
            jsDriver.executeScript("document.getElementById('train_date').value='2021-12-30'");
            Thread.sleep(3000);
            //将当前时间控件的值打印出来
            Object date = jsDriver.executeScript("return document.getElementById('train_date').value");
            System.out.println(date);
        } catch (InterruptedException e) { e.printStackTrace();
        }
    }
    @AfterAll
    public static void TearDown() {
        driver.quit();System.out.println("网站成功退出");
    }
}
