package com.wechat.apiobject;

import BingAn.FakerUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


/**
 * @ClassName DepartMentObject
 * @Description TODO
 * @Author yangfan
 * @Date 2022/6/15 11:21
 */
public class DepartMentObject {
    public static Response createDepartMent(String createName, String createEnName, String accessToken){
        String createBody = "{\n" +
                "   \"name\": \""+createName+"\",\n" +
                "   \"name_en\": \""+createEnName+"\",\n" +
                "   \"parentid\": 1}";

        Response createResponse = given().log().all().
                contentType("application/json")
                .body(createBody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+accessToken+"")
                .then().log().body()
                .extract().response();

        return createResponse;
    }

    public static String createDepartMent(String accessToken){
        String creatName = "测试"+ FakerUtils.getTimeStamp();
        String creatEnName = "YFF"+ FakerUtils.getTimeStamp();
        Response createResponse = createDepartMent(creatName, creatEnName, accessToken);
        String departmentId = createResponse.path("id")!=null ? createResponse.path("id").toString():null;

        return departmentId;

    }

    public static String creatDepartMentByRandomInt(String accessToken){
        String creatName= "name"+ FakerUtils.getRandomInt(1000);
        String creatEnName="en_name"+ FakerUtils.getRandomInt(1000);
        String creatBody ="{\n" +
                "   \"name\": \""+creatName+"\",\n" +
                "   \"name_en\": \""+creatEnName+"\",\n" +
                "   \"parentid\": 1}";
        Response creatResponse=given().log().all()
                .contentType("application/json")
                .body(creatBody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+accessToken+"")
                .then()
                .log().body()
                .extract()
                .response()
                ;
        String departmentId= creatResponse.path("id")!=null ? creatResponse.path("id").toString():null;

        return departmentId;
    }

    public static Response updateDepartMent(String updateName,String updateEnName,String departmentId,String accessToken){
        String updateBody = "{\n" +
                "   \"id\": "+departmentId+",\n" +
                "   \"name\": \""+updateName+"\",\n" +
                "   \"name_en\": \""+updateEnName+"\",\n" +
                "   \"order\": 1\n" +
                "}\n";

        Response updateResponse = given().log().all()
                .contentType("application/json")
                .body(updateBody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token="+accessToken+"")
                .then()
                .log().body()
                .extract().response();
        return updateResponse;
    }

    public static Response listDepartMent(String departmentId,String accessToken){
        Response listReponse = given().log().all()
                .when()
                .param("id", departmentId)
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token="+accessToken)
                .then()
                .log().body()
                .extract()
                .response();

        return listReponse;
    }

    public static Response deleteDepartMent(String departmentId,String accessToken){
        Response deleteResponse = given().log().all()
                .contentType("application/json")
                .param("access_token",accessToken)
                .param("id",departmentId)
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then().log().body().extract().response();
        return deleteResponse;
    }

}
