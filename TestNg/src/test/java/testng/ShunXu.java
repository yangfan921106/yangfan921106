package testng;

import org.testng.annotations.*;

/**
 * @ClassName ShunXu
 * @Description TODO
 * @Author yangfan
 * @Date 2021/12/30 17:02
 */
public class ShunXu {
    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("BeforeTest");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest");
    }

    @BeforeClass
    public void BeforeClass(){
        System.out.println("BeforeClass");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("AfterClass");
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("BeforeMethod");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("AfterMethod");
    }

    @Test
    public void Test(){
        System.out.println("Test");
    }


}
