package selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


/**
 * @ClassName KeyBoardTestDemo
 * @Description 针对键盘的一些操作，只有火狐浏览器才可以，谷歌不支持。
 * @Author yangfan
 * @Date 2022/1/25 14:26
 */
public class KeyBoardTestDemo {

    public static WebDriver driver;
    public static Actions actions;

    @BeforeAll
    public static void initData(){
        driver = new FirefoxDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void keyBoarTest(){
        try {
            //给一个网址
        driver.get("http://sahitest.com/demo/label.htm");
            driver.manage().window().maximize();

            System.out.println("进入网站成功");
            //向输入框输入内容
        driver.findElements(By.xpath("//*[@type=\"textbox\"]")).get(0).sendKeys("yangfan");
            System.out.println("向输入框输入内容");
            //全选  ctrl+a
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
            System.out.println("全选");
            //复制  ctrl+c
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
            System.out.println("复制");
            //粘贴到具体的输入框
        actions.keyDown(driver.findElements(By.xpath("//*[@type=\"textbox\"]")).get(1),Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
            System.out.println("粘贴");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @AfterAll
    public static void TearDown(){
        driver.quit();
        System.out.println("网站成功退出");
    }
}
