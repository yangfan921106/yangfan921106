package WeixinPOTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @ClassName BasePage
 * @Description TODO
 * @Author yangfan
 * @Date 2022/2/10 11:35
 */
public class BasePage {

    WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public BasePage(){

    }

    public void click(By by){
        driver.findElement(by).click();
    }

    public void  sendkeys(By by,String content){
        driver.findElement(by).sendKeys(content);
    }

}
