package xiezuopingtai;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

/**
 * @ClassName T8805LoginTest
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/26 15:06
 */
public class T8805LoginTest extends BasicTestDemo {


    @Test
    public void LoginTest() {
        try {
            //给一个网址
            driver.get("http://h128.ad99.cc:8805/#/login");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            //登陆操作
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys("admin");
            System.out.println("输入用户名成功");
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("Aden2021");
            System.out.println("输入密码成功");
            driver.findElement(By.xpath("//button")).click();
            System.out.println("点击登录按钮");
            String one = driver.getWindowHandle();


            //点击首页的 结算清单质控
            Thread.sleep(3000);
            //*[@id="container"]/div[3]/div[1]/div[3]/div[2]
            driver.findElement(By.xpath("//div[@name=\"flip-list\"]//div[3]//div[1]//div[2]")).click();
            System.out.println("点击  结算清单质控");
            driver.manage().window().maximize();
            System.out.println("将页面开到最大尺寸");

            //切换到结算清单的页面进行操作
            Set<String> windowHandles = driver.getWindowHandles();
            Object[] objects = windowHandles.toArray();
            driver.switchTo().window(objects[1].toString());

            //点击某一个月份的总病案，进入清单列表
            driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div/a")).click();
            /*for (String win:driver.getWindowHandles()) {
                if (!win.equals(one)) {
                    driver.switchTo().window(win);
                    driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div/a")).click();
                    Thread.sleep(3000);
                }
            }*/


            Thread.sleep(3000);

            //点击一个清单号进入清单详情页面
            driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[4]/div[2]/table/tbody/tr[2]/td[2]/div/span")).click();
            System.out.println("点击一个病案号进入清单详情页面");
            Thread.sleep(3000);
            //*[@id="insurance-detail"]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]
            //System.out.println(driver.findElement(By.xpath("//*[@id=\"insurance-detail\"]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]")).getText());

           // LinkedHashMap<String, Object> stringObjectLinkedHashMap = DButils.excuteQuery("SELECT caseNumber FROM `dlcms_hospital`.`t_medical_record_main`where dischargeDate > date '2023-06-30' and dischargeDate < date '2023-08-01' and reviewStatus = '0' LIMIT 0,1").get(0);
           // String case_number = stringObjectLinkedHashMap.get("caseNumber").toString();
           // System.out.println(case_number);

          //  driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div/div[2]/div/div[1]/div[1]/div/div[1]/input")).sendKeys(case_number);
          //  Thread.sleep(3000);

            //driver.findElement(By.xpath("//*[@id=\"el-autocomplete-1052-item-0\"]")).click();

            //Thread.sleep(3000);

           // driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div/div[2]/div/div[1]/div[1]/div/div/span/span/i")).click();

            //String style = driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div/div[2]/div/div[1]/div[5]/div/div[4]/div")).getAttribute("style");
           // if ("cursor: pointer;".equalsIgnoreCase(style)){

            //点击存疑按钮
                driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div/div[2]/div/div[1]/div[5]/div/div[4]/div")).click();
                System.out.println("点击  存疑 按钮");
                Thread.sleep(3000);
                //点击问题类型的下拉箭头
                driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div/div[2]/div/div[3]/div[2]/div[1]/div[1]/form/div[1]/div/div/div/div/input")).click();
                Thread.sleep(3000);
                //选择一个类型
                driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[1]/span")).click();
                Thread.sleep(3000);
                //输入调整建议
                driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div/div[2]/div/div[3]/div[2]/div[1]/div[1]/form/div[2]/div/div[1]/div/textarea")).sendKeys("11111");
                Thread.sleep(3000);
                //点击住院医师的下拉箭头
                driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div/div[2]/div/div[3]/div[2]/div[1]/form/div[2]/div/div/div[1]/input")).click();
                Thread.sleep(3000);
                //输入过滤文字
                driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div/div[2]/div/div[3]/div[2]/div[1]/form/div[2]/div/div/div[1]/input")).sendKeys("132");
                Thread.sleep(3000);
                //选中一个医师
                driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div/div[2]/div/div[3]/div[2]/div[1]/form/div[2]/div/div/div[2]/div[1]/div[1]/ul/li[98]/span")).click();
                Thread.sleep(3000);
                //点击确认审核详情页面的  确定  按钮
                driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div/div[2]/div/div[3]/div[2]/div[2]/button[2]")).click();
                Thread.sleep(3000);
                //点击审核存疑成功的  确认  按钮
                driver.findElement(By.xpath("//div[@class=\"el-message-box\"]//div[3]//button")).click();
                System.out.println("存疑成功");
                Thread.sleep(3000);
            //点击取消存疑  按钮
                driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div/div[2]/div/div[1]/div[5]/div/div[4]/div")).click();
                Thread.sleep(3000);
                //确认取消存疑
                driver.findElement(By.xpath("//div[@class=\"el-message-box__btns\"]//button[2]")).click();
                System.out.println("取消存疑成功");

            //}else if ("".equalsIgnoreCase(style)){
               // driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div/div[2]/div/div[1]/div[4]/i[2]")).click();

            //}

            Thread.sleep(5000);


          /*  for(int i = 0;i < 40;i++) {
                driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div/div[2]/div/div[1]/div[4]/i[2]")).click();
                Thread.sleep(2000);
            }*/

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }





}
