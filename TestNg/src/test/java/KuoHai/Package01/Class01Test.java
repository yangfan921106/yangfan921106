package KuoHai.Package01;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

/**
 * @ClassName Class01Test
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/17 15:45
 */
public class Class01Test {
    @Test(groups = {"group01"})
    @Description("01包内的01类的1号方法")
    public void test01(){
        System.out.println("01包内的01类的1号方法");
    }

    @Test(groups = {"group02"})
    @Description("01包内的02类的2号方法")
    public void test02(){

        System.out.println("01包内的02类的2号方法");
    }

    @Test(groups = {"group03"})
    @Description("01包内的03类的3号方法")
    public void test03(){

        System.out.println("01包内的03类的3号方法");
    }




}
