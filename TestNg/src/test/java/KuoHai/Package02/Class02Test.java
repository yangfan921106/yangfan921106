package KuoHai.Package02;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

/**
 * @ClassName Class02Test
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/17 16:08
 */
public class Class02Test {

    @Test(groups = {"group01"})
    @Description("02包内的01类的1号方法")
    public void test01(){
        System.out.println("02包内的01类的1号方法");
    }

    @Test(groups = {"group02"})
    @Description("02包内的02类的2号方法")
    public void test02(){
        System.out.println("02包内的02类的2号方法");
    }

    @Test(groups = {"group03"})
    @Description("02包内的03类的3号方法")
    public void test03(){
        System.out.println("02包内的03类的3号方法");
    }


}
