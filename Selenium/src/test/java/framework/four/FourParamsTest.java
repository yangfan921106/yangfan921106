package framework.four;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import framework.one.OneParamsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * @ClassName ParamsTest4
 * @Description 这个做的是把测试步骤给驱动起来，但是还没有去读取data
 * @Author yangfan
 * @Date 2022/4/13 14:58
 */
public class FourParamsTest {
    @ParameterizedTest
    @MethodSource()
    void search(FourTestCase testCase){
        System.out.println(testCase);
        testCase.run();
    }

    static Stream<FourTestCase> search() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        FourTestCase testCase = mapper.readValue(FourParamsTest.class.getResourceAsStream("/framework/search_step.yaml"),
                FourTestCase.class);
        return Stream.of(testCase);
    }

}
