package selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName InteractiveTestDemo
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/25 11:29
 */
public class InteractiveTestDemo {

    public static WebDriver driver;
    public static Actions actions;

    @BeforeAll
    public static void initData() {
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void clickTest() {
        try {
            driver.get("http://sahitest.com/demo/clicks.htm");
            //单击
            actions.click(driver.findElement(By.xpath("//input[@value='click me']")));
            //双击
            actions.doubleClick(driver.findElement(By.xpath("//input[@value='dbl click me']")));
            //右键
            actions.contextClick(driver.findElement(By.xpath("//input[@value='right click me']")));
            actions.perform();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void moveTest() {
        try {
            driver.get("http://baidu.com.cn");
            //将鼠标挪动到某个元素上
            actions.moveToElement(driver.findElement(By.id("s-usersetting-top")));
            actions.perform();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void dragTest() {
        try {
            driver.get("http://sahitest.com/demo/dragDropMooTools.htm");
            //将一个元素拖拽到另外一个元素上
            //actions.dragAndDrop(driver.findElement(By.id("dragger")),driver.findElement(By.xpath("//*[@class=\"item\"][1]")));
            //actions.dragAndDrop(driver.findElement(By.id("dragger")),driver.findElement(By.xpath("//*[@class=\"item\"][2]")));
            // actions.dragAndDrop(driver.findElement(By.id("dragger")),driver.findElement(By.xpath("//*[@class=\"item\"][3]")));
            actions.dragAndDrop(driver.findElement(By.id("dragger")), driver.findElement(By.xpath("//*[@class=\"item\"][4]")));
            actions.perform();


            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Test
    //做的操作是打开网址，输入内容，点击百度一下，下滑到页面的最下方，点击下一页
    public void scorllTest() {
        try {
            driver.get("https://www.baidu.com/");
            driver.manage().window().maximize();

            System.out.println("进入网址");
            driver.findElement(By.id("kw")).sendKeys("霍格沃兹测试学院");
            Thread.sleep(4000);
            System.out.println("输入内容");

//这一步老是失败，不晓得啥原因
            TouchActions actions = new TouchActions(driver);
            actions.click(driver.findElement(By.id("su")));
            System.out.println("点击百度一下");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            Thread.sleep(4000);
            System.out.println("滑动到底部");

            driver.findElement(By.xpath("//a [@class = \"n\"]")).click();
            System.out.println("点击下一页");
            Thread.sleep(4000);

            for (int i=0;i<5;i++) {
                js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
                Thread.sleep(4000);
                driver.findElements(By.xpath("//a [@class = \"n\"]")).get(1).click();
            }

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @AfterAll
    public static void TearDown() {
        driver.quit();
        System.out.println("网站成功退出");
    }


}
