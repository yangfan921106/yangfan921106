package selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName SwitchWindowTest
 * @Description 这个是用来处理多窗口的
 * @Author yangfan
 * @Date 2022/1/26 13:48
 */
public class SwitchWindowTest {
    public static WebDriver driver;

    @BeforeAll
    public static void initData() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    public void switchWindowTest(){
        try {
            //给一个网址
        driver.get("http://www.baidu.com");
            System.out.println("打开百度网站");


        //为了避免找不到按钮的情况，将窗口开到最大
        driver.manage().window().maximize();
            System.out.println("将窗口开到最大");
        //获取到  登录 的信息，点击一下
        driver.findElement(By.xpath("//*[@id=\"s-top-loginbtn\"]")).click();
            System.out.println("点击第一个窗口的  登录 按钮");
        //获取当前窗口的页柄
        String baiduWin = driver.getWindowHandle();
            System.out.println("获取第一个页面的页柄");
        Thread.sleep(3000);

        //获取 立即注册 的信息，点击一下
        driver.findElement(By.xpath("//*[@id=\"TANGRAM__PSP_11__regLink\"]")).click();
            System.out.println("点击第一个页面的 立即注册 按钮");
            Thread.sleep(3000);

            //点击了立即注册之后就会又打开一个窗口，此时获取的页柄会有多个，写一个for循环，去跟第一个窗口做比较，如果等于第一个窗口那么不执行下面的内容，不等于第一个窗口才去执行下面的内容
            for (String win:driver.getWindowHandles()){
                if(!win.equals(baiduWin)){
                    //切换到第二个窗口
                    driver.switchTo().window(win);
                    System.out.println("切换到第二个窗口");
                    //找到用户名并输入信息
                    driver.findElement(By.id("TANGRAM__PSP_4__userName")).sendKeys("yangfan");
                    System.out.println("向 用户名 输入信息");
                    Thread.sleep(3000);
                    //找到手机号并输入信息
                    driver.findElement(By.id("TANGRAM__PSP_4__phone")).sendKeys("13281062255");
                    System.out.println("向 手机号 输入信息");
                    Thread.sleep(3000);

                    //将窗口切回到第一个窗口
                    driver.switchTo().window(baiduWin);
                    System.out.println("切换回第一个窗口");
                    //清空登录第一个输入框的内容
                    driver.findElement(By.id("TANGRAM__PSP_11__userName")).clear();
                    System.out.println("清空第一个输入框内的内容");
                    //向第一个输入框内输入内容
                    driver.findElement(By.id("TANGRAM__PSP_11__userName")).sendKeys("13281062255");
                    System.out.println("向 第一个输入框 输入内容");
                    Thread.sleep(3000);
                    //清空登录第二个输入框的内容
                    driver.findElement(By.id("TANGRAM__PSP_11__password")).clear();
                    System.out.println("清空第二个输入框内的内容");
                    //向第二个输入框内输入内容
                    driver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys("13281062255");
                    System.out.println("向 第二个输入框 输入内容");

                    Thread.sleep(3000);

                }

            }

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
