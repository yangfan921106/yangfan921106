package framework.three;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import framework.one.OneParamsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ParamsTest3
 * @Description 这个是读取yaml文件内的内容来实现参数化的
 * @Author yangfan
 * @Date 2022/4/13 14:31
 */
public class ThreeParamsTest {

    @ParameterizedTest
    @MethodSource()
    void search(String keyword){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://ceshiren.com");
        driver.findElement(By.id("search-button")).click();
        driver.findElement(By.id("search-term")).sendKeys(keyword);
    }

    static List<String> search() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference<List<String>> typeReference = new TypeReference<List<String>>() {
        };

        List<String> keyword = mapper.readValue(ThreeParamsTest.class.getResourceAsStream("/framework/search.yaml"), typeReference);
        return keyword;
    }
}
