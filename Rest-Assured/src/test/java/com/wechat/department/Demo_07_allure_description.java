package com.wechat.department;

import com.wechat.apiobject.DepartMentObject;
import com.wechat.apiobject.TokenHelper;
import com.wechat.task.EvnHelperTask;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.FakerUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

/**
 * 1、基础脚本，分别执行了，创建、修改、查询、删除接口并进行了校验
 * 2、进行了优化，方法间进行解耦，每个方法可以独立行
 * 3、进行了优化，使用时间戳命名法避免入参重复造成的报错。
 * 4、进行了优化，每次方法执行前后都对历史数据进行清理，确保每次执行脚本数据环境一致。
 * 5、进行了优化，对脚本进行了分层，减少了重复代码，提高了代码复用率，并减少了维护成本。
 * 6、进行了优化，因为要覆盖不同的入参组合，以数据驱动的方式将入参从代码剥离。
 * 7、进行了优化，使用Junit5提供的Java 8 lambdas的断言方法，增加了脚本的容错性。
 */

//查看报告的命令 allure serve allure-results/


/**
 * @ClassName Demo_01_base
 * @Description TODO
 * @Author yangfan
 * @Date 2022/5/27 15:39
 * 企业id：wwb7f019af9859b7c1
 * secret：yBfq_D_JIg-5H2ZG2tYQNKoM_03mvH4rPwmbzLkJLUw
 */

@Epic("Epic 企业微信接口测试用例")
@Feature("Feature 部门新增 修改 删除 查询 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Demo_07_allure_description {
    static String access_token;

    @BeforeAll
    public static  void getAccessToken(){
     access_token = TokenHelper.getAccessToken();
    }

    @AfterEach
    @BeforeEach
    void clearDepartment() {
        EvnHelperTask.clearDpartMentTask(access_token);
    }


    @Description("Description 这个测试方法用来测试新增部门")
    @Story("Story 新增部门测试")
    @DisplayName("Displayname 创建部门")
    @RepeatedTest(5)
    @Execution(CONCURRENT)
    @Order(1)
    public void createDepartment(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp()+"1";
        String name = "测试"+backendStr;
        String name_en = "YFF"+backendStr;

        Response createResponse = DepartMentObject.createDepartMent(name, name_en, access_token);
        assertEquals("0", createResponse.path("errcode").toString());


    }

    @Description("Description 这个测试方法会测试修改部门的功能")
    @Story("Story 修改部门测试")
    @DisplayName("Displayname 修改部门")
    @Test
    @Order(2)
    public void updateDepartment(){

        String update_name = "up测试"+ FakerUtils.getTimeStamp()+ Thread.currentThread().getId();
        String update_name_en = "upYFF"+FakerUtils.getTimeStamp()+ Thread.currentThread().getId();

       String departmentId = DepartMentObject.createDepartMent(access_token);
       Response updateResponse = DepartMentObject.updateDepartMent(update_name,update_name_en,departmentId,access_token);
       assertEquals("0",updateResponse.path("errcode").toString());

    }

    @DisplayName("Displayname 获取部门列表")
    @Description("Description 这个测试方法会测试查询部门的功能")
    @Story("Story 查询部门测试")
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

    @DisplayName("Dispalyname 删除部门")
    @Description("Description 这个测试方法会测试删除部门的功能")
    @Story("Story 删除部门测试")
    @Test
    @Order(4)
    public void deleteDepartment(){
       String departmentId = DepartMentObject.createDepartMent(access_token);

       Response deleteresponse = DepartMentObject.deleteDepartMent(departmentId, access_token);
       assertEquals("0", deleteresponse.<Integer>path("errcode").toString());
    }
}
