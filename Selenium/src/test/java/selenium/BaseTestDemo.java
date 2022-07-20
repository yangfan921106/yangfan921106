package selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @ClassName BaseTestDemo
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/27 15:07
 */
public class BaseTestDemo {
    public static WebDriver driver;


    @BeforeAll
    public static void initData(){
        String browserName = System.getenv("brower");

        if("chrome".equals(browserName)){
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application");
            driver = new ChromeDriver();
        }else if("firefox".equals(browserName)){
            driver = new FirefoxDriver();
        }else if("safari".equals(browserName)){
            driver = new SafariDriver();
        }

    }

    @AfterAll
    public static void TearDown() {
        driver.quit();
        System.out.println("网站成功退出");
    }
}
