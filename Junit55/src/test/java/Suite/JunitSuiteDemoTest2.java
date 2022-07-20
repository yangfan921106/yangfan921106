package Suite;

import TestCaseInfo.TestCase.Junit5TestDemo1;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * @ClassName JunitSuiteDemoTest2
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/5 15:07
 */
@RunWith(JUnitPlatform.class)
@SelectClasses({
        Junit5TestDemo1.class
})
@IncludeTags({"test11"})
public class JunitSuiteDemoTest2 {
}
