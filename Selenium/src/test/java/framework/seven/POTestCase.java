package framework.seven;

/**
 * @ClassName POTestCase
 * @Description TODO
 * @Author yangfan
 * @Date 2022/4/14 20:41
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class POTestCase extends TestCase {
    private ChromeDriver driver;
    private WebElement currentElement;
    private MainPage mainPage;

    //po的run方法里面，调用这个run，他会去运行，会分析，读完之后找到其中的steps
    public void run() {
        steps.forEach(step -> {
            System.out.println(step);
            String key = step.keySet().iterator().next();
            System.out.println(key);
            //如果有init，就会调用basepage的实例，完成对po的初始化，给它起一个别名
            if (key.contains("init")) {
//                mainPage = new MainPage()
// yaml里面的小名是方便后面的内容引用的，加一个init关键字，代表需要初始化，允许传两个参数，第一个是小名，第二个大名，大名是class.forname
                // getvalue step  这个值是一个列表，先转成string，value里面的第零个是小名，第二个是全名
                //通过这个办法，poinit就会动态创建出来一个类，同时把这个类以小名存进去，通过这个办法就把一个po创建出来了
                ArrayList<String> value = (ArrayList<String>) getValue(step, "init");
                BasePage.getInstance().poInit(value.get(0), value.get(1));
            }
//            if (step.keySet().contains("SearchPage")) {
//                SearchPage page = new SearchPage(driver);
//            }

            //后面只要有点出现的地方，就会认为是别名加上一个初始化的方法，就会转成对具体方法的调用
            if (key.contains(".")) {
                //mainPage.search

                String[] objectMethod = key.split("\\.");
                System.out.println(objectMethod);
                String object = objectMethod[0];
                String method = objectMethod[1];


//
//                if (method.equals("search")) {
//                    mainPage.search();
//                }

                //解决了找方法的难题
                //getpo找到object对应的名字，接着再调用steprun
                BasePage.getInstance().getPO(object).stepRun(method);
            }

        });
    }
}
