package DemoTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * @ClassName DemoTest
 * @Description TODO
 * @Author yangfan
 * @Date 2022/5/19 16:45
 */
public class DemoTest {

    @Test
    void fun(){
        given()
               .get("https://www.baidu.com")
                .then()
                .statusCode(200)
                .log().all();
    }


}
