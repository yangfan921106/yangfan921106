package selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName FrameTest
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/26 14:53
 */
public class FrameTest {
    public static WebDriver driver;

    @BeforeAll
    public static void initData() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    public void frameTest(){
        driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
        System.out.println("打开网站");

        //切换到iframe
        driver.switchTo().frame("iframeResult");
        //找到 请拖拽我，并将按钮的文字打印出来
        System.out.println(driver.findElement(By.id("draggable")).getText());

        //切换到父级框架
        driver.switchTo().parentFrame();
        //找到 点击运行，并将按钮的文字打印出来
        System.out.println(driver.findElement(By.id("submitBTN")).getText());

    }

    @AfterAll
    public static void TearDown() {
        driver.quit();
        System.out.println("网站成功退出");
    }
}
