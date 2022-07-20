package xueqiu;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName BaseTest
 * @Description TODO
 * @Author yangfan
 * @Date 2022/3/25 10:46
 */
public class BaseTest {
    private static AppiumDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    public static void setUp(){
        try {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName","Android");
        caps.setCapability("udid","emulator-5554");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appPakage", "com.xueqiu.android");
        caps.setCapability("noReset", "true");
        caps.setCapability("appActivity", ".view.WelcomeActivityAlias");


            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void fun() {
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.view.View/android.view.View/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.ImageView");
        el1.click();
    }



}
