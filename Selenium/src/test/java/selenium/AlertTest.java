package selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName AlertTest
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/27 16:34
 */
public class AlertTest {
    public static WebDriver driver;
    @BeforeAll
    public static void initData() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void frameTest(){
        try {
        driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
        driver.manage().window().maximize();
        System.out.println("打开网站");
        Thread.sleep(3000);

        //切换到iframe
        driver.switchTo().frame("iframeResult");
        Actions actions = new Actions(driver);
        //将一个元素拖拽到另外一个元素上
        actions.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).perform();
        Thread.sleep(3000);
        //允许弹窗
        driver.switchTo().alert().accept();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //切换到父级框架
        driver.switchTo().parentFrame();
        //找到 点击运行，并将按钮的文字打印出来
        System.out.println(driver.findElement(By.id("submitBTN")).getText());

    }

    @AfterAll
    public static void TearDown() {
        driver.quit();System.out.println("网站成功退出");
    }
}
