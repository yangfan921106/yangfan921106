package WeixinPOTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MainPage
 * @Description TODO
 * @Author yangfan
 * @Date 2022/2/10 11:42
 */
public class MainPage extends BasePage {
    void needlogin() throws InterruptedException, IOException {
        //打开网站，此时会强制等待十五秒，需要用手机扫码登录一下
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        Thread.sleep(15000);
        //获取cookies，并将其写到一个yaml文件里面
        Set<Cookie> cookies = driver.manage().getCookies();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("cookies.yaml"), cookies);
        System.exit(0);
    }

    void beforeAll() throws IOException, InterruptedException {
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

    public MainPage() throws IOException, InterruptedException {
        this.beforeAll();
    }

    public ContactPage contact(){
        return new ContactPage(driver);
    }

}
