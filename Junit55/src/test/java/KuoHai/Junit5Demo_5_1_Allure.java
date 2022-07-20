package KuoHai;

import com.util.Calculator;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName Junit5Demo_5_1_Allure
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/13 17:27
 */

@Epic("Epic  计算器项目")
@Feature("Feature 冒烟测试用例")
public class Junit5Demo_5_1_Allure {
    @Test
    @Order(1)
    @Description("Descriptin  这是一个测试计算器的用例跑批")
    @Story("Story 加法测试")
    @DisplayName("DisplayName  加法测试")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("www.baidu.com")
    @Link(name = "link 社区站",type = "mylink",url="www.baidu.com")
    public void addTest02(){
        final int result01 = Calculator.add(2,4);
        System.out.println(result01);

        final int result02 = Calculator.add(2,5);
        System.out.println(result02);

        final int result03 = Calculator.add(2,6);
        System.out.println(result03);

        assertAll(
                "计算结果校验：",
                ()-> assertEquals(6,result01),
                ()-> assertEquals(6,result02),
                ()-> assertEquals(6,result03)
        );
    }

    @Test
    @Order(2)
    @Description("Descriptin  这是一个测试计算器的用例跑批")
    @Story("Story 减法测试")
    @DisplayName("DisplayName  减法测试")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("www.baidu.com")
    @Link(name = "link 社区站",type = "mylink",url="www.baidu.com")
    public void subTest(){
        int result = Calculator.sub(4,2);
        System.out.println(result);
        //这个是给测试报告加图片的
        Allure.addAttachment("pic", "image/png",this.getClass().getResourceAsStream("/ll.png"),".png");
        assertEquals(2,result,"实际值与预期值不符！");
    }
    @Test
    @Order(3)
    @Description("Descriptin  这是一个测试计算器的用例跑批")
    @Story("Story 乘法测试")
    @DisplayName("DisplayName  乘法测试")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("www.baidu.com")
    @Link(name = "link 社区站",type = "mylink",url="www.baidu.com")
    public void mulTest(){
        int result = Calculator.mul(3,5);
        System.out.println(result);
        assertEquals(15,result,"实际值与预期值不符！");
    }
    @Test
    @Order(4)
    @Description("Descriptin  这是一个测试计算器的用例跑批")
    @Story("Story 除法测试")
    @DisplayName("DisplayName  除法测试")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("www.baidu.com")
    @Link(name = "link 社区站",type = "mylink",url="www.baidu.com")
    public void divTest(){
        int result = Calculator.div(8,2);
        System.out.println(result);
        assertEquals(4,result,"实际值与预期值不符！");
    }


    //避免重复写代码，可以加一个beforeeach的注解
    /*@Test
    @Order(5)
    public void clear(){
        Calculator.clear();
    }*/

    @BeforeEach
    public void clear(){
        Calculator.clear();
    }

    @Test
    @Description("Descriptin  这是一个测试计算器的用例跑批")
    @Story("Story 递加测试")
    @DisplayName("DisplayName  递加测试")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("www.baidu.com")
    @Link(name = "link 社区站",type = "mylink",url="www.baidu.com")
    public void countTest() throws InterruptedException {
        int result = Calculator.count(6);
        result = Calculator.count(6);
        result = Calculator.count(6);
        result = Calculator.count(6);
        System.out.println(result);
        assertEquals(24,result,"实际值与预期值不符！");
    }

}
