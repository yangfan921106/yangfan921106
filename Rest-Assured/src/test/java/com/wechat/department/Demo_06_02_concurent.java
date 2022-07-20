package com.wechat.department;

import com.wechat.apiobject.DepartMentObject;
import com.wechat.apiobject.TokenHelper;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
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


/**
 * @ClassName Demo_01_base
 * @Description TODO
 * @Author yangfan
 * @Date 2022/5/27 15:39
 * 企业id：wwb7f019af9859b7c1
 * secret：yBfq_D_JIg-5H2ZG2tYQNKoM_03mvH4rPwmbzLkJLUw
 */

/**
 * 对创建部门进行并发测试
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Demo_06_02_concurent {
    static String access_token;

    @BeforeAll
    public static  void getAccessToken(){
     access_token = TokenHelper.getAccessToken();
    }


    @DisplayName("创建部门")
    @RepeatedTest(20)
    @Execution(CONCURRENT)
    public void createDepartment(){

        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp()+"";
        String name = "YFF"+backendStr;
        String name_en = "YFF"+backendStr;

        Response createResponse = DepartMentObject.createDepartMent(name, name_en, access_token);
        assertEquals("0", createResponse.path("errcode").toString());
    }

    @DisplayName("修改部门")
    @RepeatedTest(20)
    @Execution(CONCURRENT)
    public void updateDepartment(){
        String backendStr = Thread.currentThread().getId()+FakerUtils.getTimeStamp()+"";

        String createName = "name"+ backendStr;
        String creatEnName = "en_name"+backendStr;

        Response creatResponse = DepartMentObject.createDepartMent(createName,creatEnName,access_token);
        String departmentId= creatResponse.path("id")!=null ? creatResponse.path("id").toString():null;

        String updateName = "up"+ backendStr;
        String updateEnName = "upp"+backendStr;

        Response updateResponse = DepartMentObject.updateDepartMent(updateName,updateEnName,departmentId,access_token);
        assertEquals("0",updateResponse.path("errcode").toString());

    }


}
