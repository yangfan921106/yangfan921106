package framework.five;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import framework.one.OneParamsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


import java.io.IOException;
import java.util.List;

/**
 * @ClassName ParamterTest5
 * @Description TODO
 * @Author yangfan
 * @Date 2022/4/14 11:37
 */
public class FiveParamterTest {

    @ParameterizedTest
    @MethodSource()
    void search(FiveTestCase testCase){
        System.out.println(testCase);
        testCase.run();
    }

    static List<FiveTestCase> search() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        FiveTestCase testCase = mapper.readValue(
                FiveParamterTest.class.getResourceAsStream("/framework/search_step.yaml"),
                FiveTestCase.class);
        return testCase.testcaseGenerate();
    }


}
