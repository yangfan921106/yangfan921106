package framework.six;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName MainPage
 * @Description TODO
 * @Author yangfan
 * @Date 2022/4/14 19:12
 */
public class MainPage extends BasePage{
    public MainPage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ceshiren.com");
    }



    public SearchPage search(){
        return new SearchPage(driver);
    }
}
