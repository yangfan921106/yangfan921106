package com.wechat.department;

import com.wechat.apiobject.DepartMentObject;
import com.wechat.apiobject.TokenHelper;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.FakerUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1、基础脚本，分别执行了，创建、修改、查询、删除接口并进行了校验
 * 2、进行了优化，方法间进行解耦，每个方法可以独立行
 * 3、进行了优化，使用时间戳命名法避免入参重复造成的报错。
 * 4、进行了优化，每次方法执行前后都对历史数据进行清理，确保每次执行脚本数据环境一致。
 * 5、进行了优化，对脚本进行了分层，减少了重复代码，提高了代码复用率，并减少了维护成本。
 * 6、进行了优化，因为要覆盖不同的入参组合，以数据驱动的方式将入参从代码剥离。
 * 7、进行了优化，使用Junit5提供的Java 8 lambdas的断言方法，增加了脚本的容错性。
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
public class Demo_05_softassert {
    static String access_token;
    static String departmentId;

    @BeforeAll
    public static  void getAccessToken(){
     access_token = TokenHelper.getAccessToken();
    }


    @DisplayName("创建部门")
    @ParameterizedTest
    @CsvFileSource(resources = "/wechatdata/createDepartment.csv",numLinesToSkip = 1)
    public void createDepartment(String name,String name_en,String returnCode){

        Response createResponse = DepartMentObject.createDepartMent(name, name_en, access_token);
        assertEquals(returnCode, createResponse.<Integer>path("errcode").toString());


    }

    @DisplayName("修改部门")
    @Test
    @Order(2)
    public void updateDepartment(){
        String update_name = "up测试"+ FakerUtils.getTimeStamp();
        String update_name_en = "upYFF"+FakerUtils.getTimeStamp();

       String departmentId = DepartMentObject.createDepartMent(access_token);
       Response updateResponse = DepartMentObject.updateDepartMent(update_name,update_name_en,departmentId,access_token);
       assertEquals("0",updateResponse.path("errcode").toString());

    }

    @DisplayName("获取部门列表")
    @Test
    @Order(3)
    public void listDepartment(){

        String creatName= "name"+FakerUtils.getTimeStamp();
        String creatEnName="en_name"+FakerUtils.getTimeStamp();
        Response creatResponse = DepartMentObject.createDepartMent(creatName,creatEnName,access_token);
        String departmentId= creatResponse.path("id")!=null ? creatResponse.path("id").toString():null;
        Response queryresponse = DepartMentObject.listDepartMent(departmentId, access_token);



        Assertions.assertAll("查询返回值校验！",
                ()->assertEquals("0",queryresponse.path("errcode").toString()),
                ()->assertEquals(departmentId,queryresponse.path("department.id[0]").toString()),
                ()->assertEquals(creatName,queryresponse.path("department.name[0]").toString()),
                ()->assertEquals(creatEnName,queryresponse.path("department.name_en[0]").toString())
        );
    }

    @DisplayName("删除部门")
    @Test
    @Order(4)
    public void deleteDepartment(){
       String departmentId = DepartMentObject.createDepartMent(access_token);

       Response deleteresponse = DepartMentObject.deleteDepartMent(departmentId, access_token);
       assertEquals("0", deleteresponse.<Integer>path("errcode").toString());
    }
}
