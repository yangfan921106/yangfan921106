package com.wechat.department;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1.基础脚本，执行了创建，修改，查询
 */



/**
 * @ClassName Demo_01_base
 * @Description TODO
 * @Author yangfan
 * @Date 2022/5/27 15:39
 * 企业id：wwb7f019af9859b7c1
 * secret：yBfq_D_JIg-5H2ZG2tYQNKoM_03mvH4rPwmbzLkJLUw
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Demo_01_base {
    static String access_token;
    static String departmentId;

    @BeforeAll
    public static  void getAccessToken(){
     access_token =   given().log().all()
                .when()
                .params("corpid","wwb7f019af9859b7c1")
                .params("corpsecret","yBfq_D_JIg-5H2ZG2tYQNKoM_03mvH4rPwmbzLkJLUw")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                .log().all()
                .extract().response().path("access_token");

        System.out.println(access_token);
    }


    @DisplayName("创建部门")
    @Order(1)
    @Test
    public void createDepartment(){
        String body = "{\n" +
                "   \"name\": \"广州研发中心2\",\n" +
                "   \"name_en\": \"RDGZ2\",\n" +
                "   \"parentid\": 1,\n" +
                "   \"order\": 2,\n" +
                "}\n";

       Response response = given().log().all()
               .contentType("application/json")
                .body(body)
               .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+access_token)
                .then()
                .log().all()
                .extract().response();

        departmentId = response.path("id").toString();
        System.out.println(departmentId);
    }

    @DisplayName("修改部门")
    @Test
    @Order(2)
    public void updateDepartment(){
        String body ="{\n" +
                "   \"id\": "+departmentId+",\n" +
                "   \"name\": \"根部门ID1\",\n" +
                "   \"name_en\": \"ROOT1\",\n" +
                "   \"order\": 1\n" +
                "}\n";
        Response response = given().log().all()
                .contentType("application/json")
                .body(body)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token="+access_token+"")
                .then()
                .log().all()
                .extract().response();
        assertEquals("0", response.path("errcode").toString());

    }

    @DisplayName("获取部门列表")
    @Test
    @Order(3)
    public void listDepartment(){
        Response response = given().log().all()
                .when()
                .params("id",departmentId)
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token="+access_token)
                .then()
                .log().all()
                .extract()
                .response();

        assertEquals("0", response.path("errcode").toString());
        assertEquals(departmentId, response.<Integer>path("department.id[0]").toString());
    }

    @DisplayName("删除部门")
    @Test
    @Order(4)
    public void deleteDepartment(){
        Response response = given().log().all()
                .params("access_token",access_token)
                .contentType("appication/json")
                .params("id",departmentId)
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then()
                .log().body()
                .extract().response();

        assertEquals("0", response.<Integer>path("errcode").toString());
    }



}
