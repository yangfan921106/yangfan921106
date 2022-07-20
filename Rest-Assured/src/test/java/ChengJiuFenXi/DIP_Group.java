package ChengJiuFenXi;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.FakerUtils;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

/**
 * @ClassName DIP_Group
 * @Description TODO
 * @Author yangfan
 * @Date 2022/6/9 10:15
 */
public class DIP_Group {
    //DIP 费用极低  入组CE00941-99-9
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void DIP_FEI_Low(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-DIP-JIDI-"+backendStr;
        ChengJiuObject.createObject(name,"心肌病","I42.900","3000.00","2","","");
    }

    //DIP 费用极低  对应的  正常
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CN_FEI_high_normal(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-DIP-NJIDI-"+backendStr;
        ChengJiuObject.createObject(name,"心肌病","I42.900","10000.00","2","","");
    }

    //针对费用极低  修改为正常
    @ParameterizedTest
    @CsvFileSource(resources = "/data/binganhao.csv",numLinesToSkip = 1)
    public void DIP_FEI_low_to_normal(String name){
        //正常
        //ChengJiuObject.createObject(name,"心肌病","I42.900","10000","2","","");
        //极低
        ChengJiuObject.createObject(name,"心肌病","I42.900","3000","2","","");

    }

    //DIP 费用极高  入组CE00941-99-9
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void DIP_FEI_High(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-DIP-JIGAO-"+backendStr;
        ChengJiuObject.createObject(name,"心肌病","I42.900","100000.00","2","","");
    }

    //DIP 费用极高  对应的  正常
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CN_FEI_low_normal(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-DIP-NJIGAO-"+backendStr;
        ChengJiuObject.createObject(name,"心肌病","I42.900","10000.00","2","","");
    }

    //针对费用极高  修改为正常
    @ParameterizedTest
    @CsvFileSource(resources = "/data/binganhao.csv",numLinesToSkip = 1)
    public void DIP_FEI_high_to_normal(String name){
        //正常
        //ChengJiuObject.createObject(name,"心肌病","I42.900","10000","2","","");
        //极高
        ChengJiuObject.createObject(name,"心肌病","I42.900","100000","2","","");

    }


    //DIP 未入组
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void DIP_ungroup(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-DIP-WRZ-"+backendStr;
        ChengJiuObject.createObject(name,"","","100000.00","2","","");
    }

    //DIP 未入组  对应的  正常
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CN_ingroup(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-DIP-NWRZ-"+backendStr;
        ChengJiuObject.createObject(name,"心肌病","I42.900","10000.00","2","","");
    }

    //针对费用极高  修改为正常
    @ParameterizedTest
    @CsvFileSource(resources = "/data/binganhao.csv",numLinesToSkip = 1)
    public void DIP_ungroup_to_normal(String name){
        //正常
       // ChengJiuObject.createObject(name,"心肌病","I42.900","10000","2","","");
        //未入组
        ChengJiuObject.createObject(name,"","","100000","2","","");

    }



}
