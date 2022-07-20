package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/19 9:58
 */
public class TestDemo {

        public static void main(String[] args) {
            WebDriver driver = new ChromeDriver();

            driver.get("https://www.baidu.com");

            driver.quit();
        }

}
