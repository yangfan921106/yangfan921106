package framework.seven;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
/**
 * @ClassName MainPage
 * @Description TODO
 * @Author yangfan
 * @Date 2022/4/14 20:40
 */
public class MainPage extends BasePage {
    public MainPage() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ceshiren.com");
    }
    public SearchPage search(){
        //实现po 可以用java代码，也可以读取main_po.yaml
//mainpage里面，我点击一个search的时候，换成去读yaml文件，我把yanl里面跟我重名的读出来，执行它的每一步
        //执行它就离不开testcase的runner，我们把读出来的数据给到testcase的steps里面
        return new SearchPage(driver);
    }


    /**
     * 注册方法 不建议
     * @param method
     */
    void stepRunDemo(String method){
        if (method.equals("search")){
            this.search();
        }
    }
}
