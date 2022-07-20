package KuoHai;

import org.junit.jupiter.api.*;

/**
 * @ClassName Junit5Demo_3_2_FixtureExtend
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/11 17:00
 */
public class Junit5Demo_3_1_FixtureExtend extends Junit5Demo_3_1_Fixture {
    @BeforeAll
    public static void child_beforeall(){
        System.out.println("child_beforeall 执行 ");
    }

    @AfterAll
    public static void child_afterall(){
        System.out.println("child_afterall 执行");
    }

    @BeforeEach
    public void child_beforeeach(){
        System.out.println("child_beforeeach 执行");
    }

    @AfterEach
    public void child_aftereach(){
        System.out.println("child_aftereach 执行");
    }

    @Test
    public void child_test01(){
        System.out.println("child_methodtest01 执行");
    }

    @Test
    public void child_test02(){
        System.out.println("child_methodtest02 执行");
    }

    @Test
    public void child_est03(){
        System.out.println("child_methodtest03 执行");
    }
}
