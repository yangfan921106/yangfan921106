package selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @ClassName WaitTest
 * @Description 这个里面写的是显示等待的两种实现方法
 * @Author yangfan
 * @Date 2022/1/20 18:29
 */
public class WaitTest {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void initData(){
        driver = new ChromeDriver();
        //需要在这里new一个wait
        wait = new WebDriverWait(driver,5);
        }

    @Test
    public void startSelenium(){
        System.out.println("即将打开网站");
        driver.get("https://home.testing-studio.com/");

        System.out.println("获取元素");


        //第一种写法，直接使用系统带的until来写，一般使用第一种方法来写就可以了，如果有什么定制化的需求可以用第二种。
     // WebElement login =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'登录')]")));
      //login.click();

      //第二种写法
        WebElement login1 = wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.xpath("//span[contains(text(),'登录')]"));
            }
        });

        login1.click();
    }




    @AfterAll
    public static void TearDown(){
        driver.quit();
        System.out.println("网站成功退出");
    }

}
