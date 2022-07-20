package selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


/**
 * @ClassName Seleniumtest
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/18 19:14
 */
public class Seleniumtest {
    public static WebDriver wd;

    @BeforeAll
    public static void initData(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void startSelenium(){
        System.out.println("即将打开网站");
        wd.get("https://home.testing-studio.com/");

        System.out.println("获取元素");
        //鼠标放在按钮上，右键点击检查
        wd.findElement(By.xpath("//span[contains(text(),'登录')]")).click();

        //同样得将鼠标放在按钮上，点击邮件检查，可以看到id，需要先clear一下将保存得用户名清除掉
        wd.findElement(By.id("login-account-name")).clear();
        //这个是输入用户名得操作
        wd.findElement(By.id("login-account-name")).sendKeys("yangfan");


        //下面两行是针对密码的操作
        wd.findElement(By.id("login-account-password")).clear();
        wd.findElement(By.id("login-account-password")).sendKeys("QAZwsx12345");

        //这一行是点击登录按钮
        wd.findElement(By.id("login-button")).click();
    }

    @Test
    public void timeSleepTest() {
        System.out.println("即将打开网站");
        wd.get("https://home.testing-studio.com/");
        try {
            //这个常用于写一个不熟悉的框架，主要起到观看的一个效果，是不推荐使用的。
            Thread.sleep(5000);
            System.out.println("获取元素");
            //鼠标放在按钮上，右键点击检查
            wd.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void TearDown(){
        wd.quit();
        System.out.println("网站成功退出");
    }

}
