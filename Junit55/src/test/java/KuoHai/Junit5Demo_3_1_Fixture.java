package KuoHai;

import org.junit.jupiter.api.*;

/**
 * @ClassName Junit5Demo_3_1_Fixture
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/11 16:51
 */
public class Junit5Demo_3_1_Fixture {
    @BeforeAll
    public static void beforeall(){
        System.out.println("beforeall 执行 ");
    }

    @AfterAll
    public static void afterall(){
        System.out.println("afterall 执行");
    }

    @BeforeEach
    public void beforeeach(){
        System.out.println("beforeeach 执行");
    }

    @AfterEach
    public void aftereach(){
        System.out.println("aftereach 执行");
    }

    @Test
    public void test01(){
        System.out.println("methodtest01 执行");
    }

    @Test
    public void test02(){
        System.out.println("methodtest02 执行");
    }

    @Test
    public void test03(){
        System.out.println("methodtest03 执行");
    }
}
