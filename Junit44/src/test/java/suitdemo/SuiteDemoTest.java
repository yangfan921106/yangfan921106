package suitdemo;

import com.course.junit4.BuyTest;
import com.course.junit4.LoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @ClassName SuiteDemoTest
 * @Description TODO
 * @Author yangfan
 * @Date 2021/12/30 15:19
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        BuyTest.class
})
public class SuiteDemoTest {
}
