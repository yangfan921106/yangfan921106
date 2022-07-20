package testng;

import org.testng.annotations.*;

/**
 * @ClassName ShunXuExtend
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/14 13:45
 */
public class ShunXuExtend extends ShunXu{

    @BeforeSuite
    public void ChildBeforeSuite(){
        System.out.println("ChildBeforeSuite");
    }

    @AfterSuite
    public void ChildAfterSuite(){
        System.out.println("ChildAfterSuite");
    }

    @BeforeTest
    public void ChildBeforeTest(){
        System.out.println("ChildBeforeTest");
    }

    @AfterTest
    public void ChildAfterTest(){
        System.out.println("ChildAfterTest");
    }

    @BeforeClass
    public void ChildBeforeClass(){
        System.out.println("ChildBeforeClass");
    }

    @AfterClass
    public void ChildAfterClass(){
        System.out.println("ChildAfterClass");
    }

    @BeforeMethod
    public void ChildBeforeMethod(){
        System.out.println("ChildBeforeMethod");
    }

    @AfterMethod
    public void ChildAfterMethod(){
        System.out.println("ChildAfterMethod");
    }

    @Test
    public void ChildTest(){
        System.out.println("ChildTest");
    }

}
