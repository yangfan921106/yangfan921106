package qiyeweixin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @ClassName LoginTest01
 * @Description TODO
 * @Author yangfan
 * @Date 2022/2/7 18:31
 */
public class LoginTest01 {
    public static WebDriver driver;


    @BeforeAll
    public static void initData() throws IOException, InterruptedException {
        File file = new File("cookies.yaml");
        if (file.exists()) {
            //利用cookie复用session登录
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://work.weixin.qq.com/wework_admin/frame");
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            //下面写的是类型转换，注意一定要使用jacson的
            com.fasterxml.jackson.core.type.TypeReference typeReference = new com.fasterxml.jackson.core.type.TypeReference<List<HashMap<String, Object>>>() {
            };
            //将文件里面的内容读到cookies里面
            //选中点击refactor，变成一个变量  va什么的那个
            List<HashMap<String, Object>> cookies = mapper.readValue(file, typeReference);
            System.out.println(cookies);
            //因为addCookie是一个一个添加，所以写了一个foreach
            cookies.forEach(cookieMap -> {
                driver.manage().addCookie(new Cookie(cookieMap.get("name").toString(), cookieMap.get("value").toString()));
            });
            //刷新界面
            driver.navigate().refresh();
            //为了查看效果强行等待三秒钟
            Thread.sleep(3000);
        } else {
            needlogin();
        }
    }

    //这个方法是用来获取企业微信登录的cookies的
    //扫码登录的
    public static void needlogin() throws InterruptedException, IOException {
        //打开网站，此时会强制等待十五秒，需要用手机扫码登录一下
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        Thread.sleep(15000);
        //获取cookies，并将其写到一个yaml文件里面
        Set<Cookie> cookies = driver.manage().getCookies();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("cookies.yaml"), cookies);
        System.exit(0);
    }

    /*
    @Test
    public void contackAdd() {
        //使用cssselector进行定位
        //driver.findElement(By.cssSelector("[node-type=addmember]")).click();
        //使用linktest
        driver.findElement(By.linkText("添加成员")).click();
        driver.findElement(By.name("username")).sendKeys("杨凡9211062626");
        driver.findElement(By.name("acctid")).sendKeys("yangfan9211062626");
        driver.findElement(By.name("mobile")).sendKeys("14569874456");
        driver.findElement(By.linkText("保存")).click();
    }
     */

    @Test
    public void contackAdd02() {
        //使用cssselector进行定位
        //driver.findElement(By.cssSelector("[node-type=addmember]")).click();
        //使用linktest
        //driver.findElement(By.linkText("添加成员")).click();
        click(By.linkText("添加成员"));
        //driver.findElement(By.name("username")).sendKeys("杨凡9211062626");
        sendkeys(By.name("username"), "jiayangbaobao01");
        //driver.findElement(By.name("acctid")).sendKeys("yangfan9211062626");

        sendkeys(By.name("acctid"), "jiayangbaobao01");
        //driver.findElement(By.name("mobile")).sendKeys("14569874457");
        sendkeys(By.name("mobile"), "17481062256");
        //driver.findElement(By.linkText("保存")).click();
        click(By.linkText("保存"));
    }

    @Test
    public void departmentSearch() {
        //点击通讯录
        click(By.id("menu_contacts"));
        //在搜索框内搜索 北京测试部
        sendkeys(By.id("memberSearchInput"), "北京测试部");
        //查看是否跳转到搜索出来的界面
        String content = driver.findElement(By.cssSelector(".js_party_info")).getText();
        System.out.println(content);
        //这个点击是担心界面没有被加载出来导致断言失败，加个点击，利用隐式等待机制，一定会被加载出来
        click(By.cssSelector(".ww_icon_AddMember"));
        content = driver.findElement(By.cssSelector(".js_party_info")).getText();
        System.out.println(content);
        //断言一下是否存在当前部门无任何成员
        assertTrue(content.contains("当前部门无任何成员"));


    }

    //将鼠标点击封装为一个方法，避免敲太多样本代码
    public void click(By by) {
        driver.findElement(by).click();
    }

    //将传值封装为一个方法
    public void sendkeys(By by, String content) {
        driver.findElement(by).sendKeys(content);
    }


}

