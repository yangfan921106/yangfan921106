package framework.seven;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
/**
 * @ClassName ParamsTest
 * @Description TODO
 * @Author yangfan
 * @Date 2022/4/14 20:40
 */
public class ParamsTest {
    @ParameterizedTest
    @MethodSource()
    void search(TestCase testCase) {

        System.out.println(testCase);
        //done: runner引擎
        //其实真正运行的是potest的run
        testCase.run();

    }

    static List<TestCase> search() throws IOException {
//        return Stream.of("apple", "banana");
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        TypeReference typeReference = new TypeReference<List<String>>() {
//        };
        //首先读取了po的用例，读取之后进入jackson转成一个标准的测试用例，
        //这个时候读出来的对象其实是po的一个用例，不再是原来的基于selenium的用例，
        TestCase testCase = mapper.readValue(
                ParamsTest.class.getResourceAsStream("/framework/search_po_test.yaml"),
                POTestCase.class);
        //通过testcasegenerate进行case裂变，生成多个测试用例。
        //这一步完成了一拆对，一拆多之后就进入流入每个测试用例，进行参数化。
        return testCase.testcaseGenerate();

    }
}
