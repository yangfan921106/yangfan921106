package WeixinPOTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @ClassName ContactPage
 * @Description TODO
 * @Author yangfan
 * @Date 2022/2/10 11:46
 */
public class ContactPage extends BasePage{
    private By parterInfo = By.cssSelector(".js_party_info");

    public ContactPage(WebDriver driver){
        super(driver);
    }

    public ContactPage addMember(String username,String acctid,String mobile){
        click(By.linkText("添加成员"));
        sendkeys(By.name("username"), username);
        sendkeys(By.name("acctid"), acctid);
        sendkeys(By.name("mobile"), mobile);
        click(By.linkText("保存"));
        return this;
    }

    public ContactPage searchDepart(String departName){
        //点击通讯录
        click(By.id("menu_contacts"));
        //在搜索框内搜索 北京测试部
        sendkeys(By.id("memberSearchInput"), departName);
        //查看是否跳转到搜索出来的界面
        String content = driver.findElement(parterInfo).getText();
        System.out.println(content);
        //这个点击是担心界面没有被加载出来导致断言失败，加个点击，利用隐式等待机制，一定会被加载出来
        click(By.cssSelector(".ww_icon_AddMember"));
        return this;

    }

    public String getParyInfo(){
        String content = driver.findElement(parterInfo).getText();
        System.out.println(content);
        return content;
    }

    public ContactPage addDepart(String departName){
        //点击通讯录
        click(By.id("menu_contacts"));
        click(By.linkText("添加"));
        click(By.linkText("添加部门"));
        sendkeys(By.name("name"), departName);
        click(By.linkText("选择所属部门"));
        driver.findElements(By.linkText("测试部")).get(1).click();

        click(By.linkText("确定"));
        return this;
    }

    public void clearAllDeparts(){
        driver.findElement(By.cssSelector(".member_colRight_memberTable_th_Checkbox > .ww_checkbox")).click();
        driver.findElement(By.cssSelector(".js_operationBar_footer > .js_delete")).click();
        driver.findElement(By.linkText("确认")).click();
    }

}
