package com.wechat.department;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import utils.FakerUtils;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1、基础脚本，分别执行了，创建、修改、查询、删除接口并进行了校验
 * 2、进行了优化，方法间进行解耦，每个方法可以独立行
 * 3、使用时间戳命名法避免入参重复造成的报错。
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
public class Demo_03_01_repeat_timestamp {
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
        String name = "测试"+ FakerUtils.getTimeStamp();
        String name_en = "YFF"+FakerUtils.getTimeStamp();

        String body = "{\n" +
                "   \"name\": \""+name+"\",\n" +
                "   \"name_en\": \""+name_en+"\",\n" +
                "   \"parentid\": 1,\n" +
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
        String name = "测试"+ FakerUtils.getTimeStamp();
        String name_en = "YFF"+FakerUtils.getTimeStamp();

        String createbody = "{\n" +
                "   \"name\": \""+name+"\",\n" +
                "   \"name_en\": \""+name_en+"\",\n" +
                "   \"parentid\": 1,\n" +
                "   \"order\": 1,\n" +
                "}\n";

        Response createresponse = given().log().all()
                .contentType("application/json")
                .body(createbody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+access_token)
                .then()
                .log().all()
                .extract().response();

       String departmentId = createresponse.path("id").toString();
        System.out.println(departmentId);

        String update_name = "up测试"+ FakerUtils.getTimeStamp();
        String update_name_en = "upYFF"+FakerUtils.getTimeStamp();

        String updatebody ="{\n" +
                "   \"id\": "+departmentId+",\n" +
                "   \"name\": \""+update_name+"\",\n" +
                "   \"name_en\": \""+update_name_en+"\",\n" +
                "}\n";
        Response updateresponse = given().log().all()
                .contentType("application/json")
                .body(updatebody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token="+access_token+"")
                .then()
                .log().all()
                .extract().response();
        assertEquals("0", updateresponse.path("errcode").toString());

    }

    @DisplayName("获取部门列表")
    @Test
    @Order(3)
    public void listDepartment(){

        String name = "测试"+ FakerUtils.getTimeStamp();
        String name_en = "YFF"+FakerUtils.getTimeStamp();

        String createbody = "{\n" +
                "   \"name\": \""+name+"\",\n" +
                "   \"name_en\": \""+name_en+"\",\n" +
                "   \"parentid\": 1,\n" +
                "   \"order\": 3,\n" +
                "}\n";

        Response createresponse = given().log().all()
                .contentType("application/json")
                .body(createbody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+access_token)
                .then()
                .log().all()
                .extract().response();

        String departmentId = createresponse.path("id").toString();
        System.out.println(departmentId);

        Response queryresponse = given().log().all()
                .when()
                .params("id",departmentId)
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token="+access_token)
                .then()
                .log().all()
                .extract()
                .response();

        assertEquals("0", queryresponse.path("errcode").toString());
        assertEquals(departmentId, queryresponse.<Integer>path("department.id[0]").toString());
    }

    @DisplayName("删除部门")
    @Test
    @Order(4)
    public void deleteDepartment(){
        String name = "测试"+ FakerUtils.getTimeStamp();
        String name_en = "YFF"+FakerUtils.getTimeStamp();

        String createbody = "{\n" +
                "   \"name\": \""+name+"\",\n" +
                "   \"name_en\": \""+name_en+"\",\n" +
                "   \"parentid\": 1,\n" +
                "   \"order\": 4,\n" +
                "}\n";

        Response createresponse = given().log().all()
                .contentType("application/json")
                .body(createbody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+access_token)
                .then()
                .log().all()
                .extract().response();

        String departmentId = createresponse.path("id").toString();
        System.out.println(departmentId);


        Response deleteresponse = given().log().all()
                .params("access_token",access_token)
                .contentType("appication/json")
                .params("id",departmentId)
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then()
                .log().body()
                .extract().response();

        assertEquals("0", deleteresponse.<Integer>path("errcode").toString());
    }



}
