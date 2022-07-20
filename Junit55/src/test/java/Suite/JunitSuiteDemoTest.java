package Suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * @ClassName JunitSuiteDemoTest
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/5 14:47
 */
@RunWith(JUnitPlatform.class)
@SelectPackages({"TestCaseInfo.TestCase1", "TestCaseInfo.TestCase2"})
@IncludePackages("TestCaseInfo")
//selectpackage和includepackages是搭配着使用的，select自己可以单独使用
public class JunitSuiteDemoTest {
}
