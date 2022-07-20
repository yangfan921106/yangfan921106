package framework.six;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @ClassName BasePage
 * @Description TODO
 * @Author yangfan
 * @Date 2022/4/14 19:08
 */
public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver diver){
        this.driver = diver;
    }

    public BasePage(){

    }

    void click(By by){
        driver.findElement(by).click();
    }

    void sendKeys(By by,String content){
        driver.findElement(by).sendKeys(content);
    }
}
