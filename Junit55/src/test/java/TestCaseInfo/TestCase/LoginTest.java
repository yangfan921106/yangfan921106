package TestCaseInfo.TestCase;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @ClassName LoginTest
 * @Description 通过NESTED这个东西可以在一个类里面写业务流的操作。 加了nested会从下面往上执行，是有执行顺序的。
 * @Author yangfan
 * @Date 2022/1/5 14:00
 */
public class LoginTest {
    private static HashMap<String,Object>dataMap=new HashMap<String, Object>();

    @Test
    void loginTest(){
        dataMap.put("login","登录成功");
        System.out.println(dataMap.get("login"));
    }

    @Nested
    class Buy{
        @Test
        void Pay(){
            if(null!=dataMap.get("login")){
                System.out.println("正在支付中，请稍等");
                System.out.println(dataMap.get("buy"));
            }else
            {
                System.out.println("您还没有购买任何东西，请选购！");
            }
        }
    }

    @Nested
    class BuyTest{

        @Test
        void ButTest(){
            if(dataMap.get("login").equals("登录成功")){
                System.out.println("登录成功，可以购买东西了");
                dataMap.put("buy","买了一个粉底液");
            }else
            {
                System.out.println("登录失败，请重新登录！");
            }
        }
    }
}
