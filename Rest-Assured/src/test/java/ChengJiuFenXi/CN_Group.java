package ChengJiuFenXi;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.FakerUtils;


import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;


/**
 * @ClassName bingan
 * @Description TODO
 * @Author yangfan
 * @Date 2022/5/27 16:57
 */
public class CN_Group {

    //CN 低风险死亡  入组EX-15
    @RepeatedTest(50)
    @Execution(CONCURRENT)
    public void CN_DI_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-DI-SW-"+backendStr;
        ChengJiuObject.createObject(name,"支气管哮喘(急性发作期)","J45.900x021","9123.4315","5","","");
    }

    //CN 低风险未死亡
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CN_DI_no_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-DI-NSW-"+backendStr;
        ChengJiuObject.createObject(name,"支气管哮喘(急性发作期)","J45.900x021","9123.4315","2","","");
    }

    //一开始是低风险死亡，修改为正常病案
    @ParameterizedTest
    @CsvFileSource(resources = "/data/binganhao.csv",numLinesToSkip = 1)
    public void CN_DI_death_normal(String name){
        //死亡
        ChengJiuObject.createObject(name,"支气管哮喘(急性发作期)","J45.900x021","9123.4315","5","","");
        //正常
        //ChengJiuObject.createObject(name,"支气管哮喘(急性发作期)","J45.900x021","9123.4315","2","","");

    }


    //CN 费用极低  入组GU15
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CN_FEI_low(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIDI-"+backendStr;
        ChengJiuObject.createObject(name,"结肠炎","A09.902","2933.0602","2","","");
    }

    //CN 费用极低  对应的  正常
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CN_FEI_low_normal(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-NJIDI-"+backendStr;
        ChengJiuObject.createObject(name,"结肠炎","A09.902","5866.1203","2","","");
    }


    //针对费用极低  修改为正常
    @ParameterizedTest
    @CsvFileSource(resources = "/data/binganhao.csv",numLinesToSkip = 1)
    public void CN_FEI_low_to_normal(String name){
        //正常
        //ChengJiuObject.createObject(name,"结肠炎","A09.902","5866.1203","2","","");
        //极低
       ChengJiuObject.createObject(name,"结肠炎","A09.902","2933.0602","2","","");

    }

    //CN 费用极高  入组FZ15
    @RepeatedTest(150)
    @Execution(CONCURRENT)
    public void CN_FEI_high(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-"+backendStr;
        ChengJiuObject.createObject(name,"心肌病","I42.900","7546.33","2","","");
    }

    //CN 费用极高  对应的  正常
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CN_FEI_high_normal(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-NJIGAO-"+backendStr;
        ChengJiuObject.createObject(name,"心肌病","I42.900","7472.3468","2","","");
    }

    //针对费用极高  修改为正常
    @ParameterizedTest
    @CsvFileSource(resources = "/data/binganhao.csv",numLinesToSkip = 1)
    public void CN_FEI_high_to_normal(String name){
        //正常
        //ChengJiuObject.createObject(name,"心肌病","I42.900","7472.3468","2","","");
        //极高
        ChengJiuObject.createObject(name,"心肌病","I42.900","7546.33","2","","");

    }

    //CN 未入组
    @RepeatedTest(200)
    @Execution(CONCURRENT)
    public void CN_Not_InGroup(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-WRZ-"+backendStr;
        ChengJiuObject.createObject(name,"","","2933.0602","2","","");
    }

    //CN 入组
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CN_InGroup(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-NWRZ-"+backendStr;
        ChengJiuObject.createObject(name,"结肠炎","A09.902","5866.1203","2","","");
    }

    //CN 未入组 修改为 入组+费用极低风险 入组加正常  入组加费用极高
    @ParameterizedTest
    @CsvFileSource(resources = "/data/binganhao.csv",numLinesToSkip = 1)
    public void CN_Not_InGroup_in_di(String name){
        //以下三种情况选一种来跑
        //入组加费用极低
        //ChengJiuObject.createObject(name,"结肠炎","A09.902","2933.0602","2","","");
        //入组加费用正常
        ChengJiuObject.createObject(name,"结肠炎","A09.902","5566.1203","2","","");
        //入组加费用极高
        //ChengJiuObject.createObject(name,"结肠炎","A09.902","100000.00","2","","");
        //未入组
        //ChengJiuObject.createObject(name,"","","2933.0602","2","","");

    }




}
