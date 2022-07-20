package com.wechat.apiobject;

import static io.restassured.RestAssured.given;

/**
 * @ClassName TokenHelper
 * @Description TODO
 * @Author yangfan
 * @Date 2022/6/15 11:18
 */
public class TokenHelper {

    public static String getAccessToken() {
        String access_token = given().log().all()
                .when()
                .params("corpid", "wwb7f019af9859b7c1")
                .params("corpsecret", "yBfq_D_JIg-5H2ZG2tYQNKoM_03mvH4rPwmbzLkJLUw")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                .log().all()
                .extract().response().path("access_token");

        return access_token;
    }

}
