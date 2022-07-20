package selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName UploadTest
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/27 16:08
 */
public class UploadTest {
    public static WebDriver driver;
    @BeforeAll
    public static void initData() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void uploadTest(){
        try {
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        //点击照相机
        driver.findElement(By.xpath("//span[@class=\"soutu-btn\"]")).click();
        Thread.sleep(3000);
        //这个写的是上传文件的操作
        driver.findElement(By.xpath("//input[@class=\"upload-pic\"]")).sendKeys("C:\\Users\\hp\\Pictures\\1643271503(1).jpg");
        Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void TearDown() {
        driver.quit();System.out.println("网站成功退出");
    }
}
