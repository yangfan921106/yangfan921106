package DemoTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * @ClassName GetMethod
 * @Description TODO
 * @Author yangfan
 * @Date 2022/5/19 17:26
 */
public class GetMethod {

    public static String access_token;
    @BeforeAll
    public static void getMethod(){
         access_token =
        given()
                .params("corpid","wwb7f019af9859b7c1","corpsecret","rAKhZBmUcN51xvA_u-5Fo1kT4_Iiq_k8SXS7_dzz8-o")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                .extract().response().path("access_token");
        System.out.println(access_token);
    }

    @Test
    void postMethod(){
        given()
                .contentType("application/json;charset=utf-8")
                .body("{\n" +
                        "   \"touser\" : \"@all\",\n" +
                        "   \"msgtype\" : \"text\",\n" +
                        "   \"agentid\" : 1000002,\n" +
                        "   \"text\" : {\n" +
                        "       \"content\" : \"测试消息发送。\\n点击链接测试<a href=\\\"https://baidu.com\\\">百度</a>，发送咯。\"\n" +
                        "   },\n" +
                        "}")
                .queryParam("access_token", access_token)
                .post("https://qyapi.weixin.qq.com/cgi-bin/message/send")
                .then()
                .log().all();
    }
}
