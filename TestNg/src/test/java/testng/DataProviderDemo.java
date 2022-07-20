package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @ClassName DataProviderDemo
 * @Description 这个是用来传递参数的，可以使用Data provider给需要的测试提供参数，所谓数据提供者，就是一个能返回对象数组的方法，并且这个方法被@DataProvider注解标注;
 * @Author yangfan
 * @Date 2021/12/31 13:38
 */
public class DataProviderDemo {
    @DataProvider(name = "putInlist")
    public Object[][] putInlist() {
        Object[][] object;
        return object = new Object[][]{
                {"包裹1",1,0,1,1,1},
                {"包裹2",0,1,1,1,0},
                {"包裹3",1,1,1,1,1}
        };
    }

    @Test(dataProvider = "putInlist")
    public void putIntA(String paKageName,int aNum,int bNum,int cNum,int dNum,int eNum) throws Exception {
        System.out.println("A操作 " + paKageName + "装入坚果A" + aNum + "个！ \n");
        Thread.sleep(1000);
        System.out.println("B操作 " + paKageName + "装入坚果B" + bNum + "个！ \n");
        Thread.sleep(1000);
        System.out.println("C操作 " + paKageName + "装入坚果C" + cNum + "个！ \n");
        Thread.sleep(1000);
        System.out.println("D操作 " + paKageName + "装入坚果D" + dNum + "个！ \n");
        Thread.sleep(1000);
        System.out.println("E操作 " + paKageName + "装入坚果E" + eNum + "个！ \n");
        Thread.sleep(1000);
    }
}
