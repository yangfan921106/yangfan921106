package qiyeweixin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName LoginTest
 * @Description TODO
 * @Author yangfan
 * @Date 2022/2/7 14:40
 */
public class LoginTest {
    public static WebDriver driver;


    @BeforeAll
    public static void initData() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    //这个方法是用来获取企业微信登录的cookies的
    public void testlogin() throws InterruptedException, IOException {
        //打开网站，此时会强制等待十五秒，需要用手机扫码登录一下
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        Thread.sleep(15000);
        //获取cookies，并将其写到一个yaml文件里面
        Set<Cookie> cookies = driver.manage().getCookies();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("cookies.yaml"), cookies);

    }

    @Test
    //这个方法写的是反向获取到cookies给到浏览器，不用扫码直接打开企业微信
    public void testLogined() throws IOException, InterruptedException {
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        //下面写的是类型转换，注意一定要使用jacson的
        com.fasterxml.jackson.core.type.TypeReference typeReference = new com.fasterxml.jackson.core.type.TypeReference<List<HashMap<String, Object>>>() {
        };
        //将文件里面的内容读到cookies里面
        List<HashMap<String, Object>> cookies = mapper.readValue(new File("cookies.yaml"), typeReference);
        System.out.println(cookies);
        //因为addCookie是一个一个添加，所以写了一个foreach
        cookies.forEach(cookieMap -> {
            driver.manage().addCookie(new Cookie(cookieMap.get("name").toString(), cookieMap.get("value").toString()));
        });
        //刷新界面
        driver.navigate().refresh();
        //为了查看效果强行等待三秒钟
        Thread.sleep(3000);

    }


}
