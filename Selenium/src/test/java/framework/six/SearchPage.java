package framework.six;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @ClassName SearchPage
 * @Description TODO
 * @Author yangfan
 * @Date 2022/4/14 19:15
 */
public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver){
        super(driver);
    }

    public void search(String keyword){
        click(By.id("search-button"));
        sendKeys(By.id("search-term"), keyword);
    }
}
