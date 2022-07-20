package TestCaseInfo.TestCase;

import org.junit.jupiter.api.*;

/**
 * @ClassName Junit5TestDemo1
 * @Description 在junit5里面写方法的时候是不需要加public的
 * @Author yangfan
 * @Date 2022/1/5 12:31
 */
@DisplayName("junit5演示类的名字")
public class Junit5TestDemo1 {

    @BeforeAll
    public static void BeforeAll(){
        System.out.println("BeforeAll");
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("AfterAll");
    }

    @BeforeEach
    public void BeforeEach(){
        System.out.println("BeforeEach");
    }

    @AfterEach
    public void AfterEach(){
        System.out.println("AfterEach");
    }

    @Test
    @DisplayName("fun1的名字")
    @RepeatedTest(5)
    void fun1(){
        System.out.println("fun1的输出");
    }

    @Test
    @Disabled
    @DisplayName("fun2的名字")
    void fun2(){
        System.out.println("fun2的输出");
    }

    @Test
    @Tag("test11")
    void fun3(){
        System.out.println("fun3的输出");
    }

    @Test
    @Tag("test11")
    void fun4(){
        System.out.println("fun4的输出");
    }

    @Test
    @Tag("test22")
    void fun5(){
        System.out.println("fun5的输出");
    }
}
