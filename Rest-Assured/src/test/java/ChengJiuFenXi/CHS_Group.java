package ChengJiuFenXi;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.FakerUtils;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

/**
 * @ClassName CHS_Group
 * @Description CHS分组
 * @Author yangfan
 * @Date 2022/6/7 10:46
 */
public class CHS_Group {


    //CHS 结余预测
    //入组 OB19    标杆是4500  结余预测=标杆-zfy
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CHS_JieYuYuCe_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-77JYYC-"+backendStr;
        ChengJiuObject.createObject(name,"胎膜早破","O42.900","3500","2","","");
    }

    //chs 结余预测
    @ParameterizedTest
    @CsvFileSource(resources = "/data/binganhao.csv",numLinesToSkip = 1)
    public void CHS_JieYuYuCe_2(String name){
        ChengJiuObject.createObject(name,"胎膜早破","O42.900","4500","2","","");
    }


    //---------------------------死亡病案开始-----------------------------
    //死亡病案
    //CHS 低风险死亡  入组OB19  这个项目需要展示在看板上，其他死亡情况不需要展示。
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_DI_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-DI-SW-"+backendStr;
        ChengJiuObject.createObject(name,"胎膜早破","O42.900","25226.67","5","74.1x01","剖宫产术，子宫下段横切口");
    }

    //CHS 低风险未死亡
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_DI_no_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-DI-NSW-"+backendStr;
        ChengJiuObject.createObject(name,"胎膜早破","O42.900","25226.67","2","74.1x01","剖宫产术，子宫下段横切口");
    }

    //一开始是低风险死亡，修改为正常病案
    @ParameterizedTest
    @CsvFileSource(resources = "/data/binganhao.csv",numLinesToSkip = 1)
    public void CHS_DI_death_normal(String name){
        //正常
        //ChengJiuObject.createObject(name,"胎膜早破","O42.900","25226.67","2","74.1x01","剖宫产术，子宫下段横切口");
        //低风险死亡
        ChengJiuObject.createObject(name,"胎膜早破","O42.900","25226.67","5","74.1x01","剖宫产术，子宫下段横切口");

    }

    //无风险死亡   入组为KS19
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_01_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-01-SW-"+backendStr;
        ChengJiuObject.createObject(name,"2型糖尿病伴多个并发症","E11.700x033","19056.93","5","","");
    }

    //中低风险死亡   入组为GS19
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_02_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-02-SW-"+backendStr;
        ChengJiuObject.createObject(name,"胃癌伴出血","K92.800x002","106644.51","5","44.1300x001","胃镜检查");
    }

    //中高风险死亡 入组为FT19
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_03_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-03-SW-"+backendStr;
        ChengJiuObject.createObject(name,"心肌病","I42.900","72114.48","5","","");
    }

    //高风险死亡  入组为EX19
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_04_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-04-SW-"+backendStr;
        ChengJiuObject.createObject(name,"支气管哮喘(急性发作期)","J45.900x021","49851.99","5","","");
    }

    //无风险死亡  入组为MB19
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_05_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-05-SW-"+backendStr;
        ChengJiuObject.createObject(name,"前列腺恶性肿瘤","C61.x00","16766.2300","5","60.2902","经尿道前列腺切除术（TURP）");
    }

    //中低风险死亡  入组为GZ19
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_06_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-06-SW-"+backendStr;
        ChengJiuObject.createObject(name,"胃静脉曲张","I86.400","5948.66","5","","");
    }


    //--------------------------------死亡病案结束-------------------------------------------------------------


    //-------------------------------费用极低开始-------------------------------------------------------------
    //费用极低的病案

    //CHS 费用极低  入组 MB19   bgid：6  CHS:MB19  费用极低 （点值 大于 80 费用倍率 小于 0.5）
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_FEI_low(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-JIDI-"+backendStr;
        ChengJiuObject.createObject(name,"前列腺恶性肿瘤","C61.x00","6706.492","2","60.2902","经尿道前列腺切除术（TURP）");
    }

    //CHS 费用极低  对应的  正常
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_FEI_low_normal(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-NJIDI-"+backendStr;
        ChengJiuObject.createObject(name,"前列腺恶性肿瘤","C61.x00","16766.2300","2","60.2902","经尿道前列腺切除术（TURP）");
    }


    //CHS 针对费用极低  修改为正常
    @ParameterizedTest
    @CsvFileSource(resources = "/data/binganhao.csv",numLinesToSkip = 1)
    public void CHS_FEI_low_to_normal(String name){
        //正常
        //ChengJiuObject.createObject(name,"前列腺恶性肿瘤","C61.x00","16766.2300","2","60.2902","经尿道前列腺切除术（TURP）");
        //费用极低
        ChengJiuObject.createObject(name,"前列腺恶性肿瘤","C61.x00","6706.492","2","60.2902","经尿道前列腺切除术（TURP）");

    }


    //bgid：6  CHS:BR29 费用极低 （点值 大于 80 费用倍率 等于 0.5）
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_FEI_low_01(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-JIDI-01-"+backendStr;
        ChengJiuObject.createObject(name,"多发性脑梗死","I63.905","5068.8","2","","");
    }

    //bgid：6  CHS:GZ19  费用极低 （点值 小于 80 费用倍率 小于 0.99）
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_FEI_low_02(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-JIDI-02-"+backendStr;
        ChengJiuObject.createObject(name,"胃静脉曲张","I86.400","4758.928","2","","");
    }

    //-----------------费用极低结束-----------------------------------------

    //------------------费用极高开始-----------------------
    //chs 费用极高

    //CHS 费用极高  入组OB19   bgid：6  CHS:OB19  费用极高  （点值 小于20 费用倍率 大于4）
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_FEI_high(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-JIGAO-"+backendStr;
        ChengJiuObject.createObject(name,"胎膜早破","O42.900","33635.56","2","74.1x01","剖宫产术，子宫下段横切口");
    }

    //CHS 费用极高  对应的  正常
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_FEI_high_normal(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-NJIGAO-"+backendStr;
        ChengJiuObject.createObject(name,"胎膜早破","O42.900","25226.67","2","74.1x01","剖宫产术，子宫下段横切口");
    }

    //CHS 针对费用极高  修改为正常
    @ParameterizedTest
    @CsvFileSource(resources = "/data/binganhao.csv",numLinesToSkip = 1)
    public void CHS_FEI_high_to_normal(String name){
        //正常
        //ChengJiuObject.createObject(name,"胎膜早破","O42.900","25226.67","2","74.1x01","剖宫产术，子宫下段横切口");
        //费用极高
        ChengJiuObject.createObject(name,"胎膜早破","O42.900","33635.56","2","74.1x01","剖宫产术，子宫下段横切口");

    }

    //bgid：6  CHS:KS19  费用极高  （点值 小于20  费用倍率 等于 4）
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_FEI_high_01(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-JIGAO-01-"+backendStr;
        ChengJiuObject.createObject(name,"2型糖尿病伴多个并发症","E11.700x033","25409.24","2","","");
    }

    //bgid：6  CHS:GS19  费用极高  （点值等于20 费用倍率等于10）
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_FEI_high_02(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-JIGAO-02-"+backendStr;
        ChengJiuObject.createObject(name,"胃癌伴出血","K92.800x002","118493.9","2","44.1300x001","胃镜检查");
    }

    //bgid：6  CHS:FT19  费用极高  （点值等于40  费用倍率大于10）
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_FEI_high_03(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-JIGAO-03-"+backendStr;
        ChengJiuObject.createObject(name,"心肌病","I42.900","88139.92","2","","");
    }

    //bgid：6  CHS:EX19  费用极高  （点值等于60  费用倍率大于10）
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_FEI_high_04(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-JIGAO-04-"+backendStr;
        ChengJiuObject.createObject(name,"支气管哮喘(急性发作期)","J45.900x021","60930.21","2","","");
    }

    //bgid：6  CHS:GC19  费用极高  （点值 大于60 费用倍率 等于 20）
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_FEI_high_05(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-JIGAO-05-"+backendStr;
        ChengJiuObject.createObject(name,"胃穿孔","K31.814","786665.2","2","44.6901","胃修补术");
    }

    //bgid：6  CHS:OZ19  费用极高  （点值 大于60 费用倍率 大于 20）
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_FEI_high_06(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHS-JIGAO-06-"+backendStr;
        ChengJiuObject.createObject(name,"妊娠合并子宫瘢痕","O34.201","94500","2","74.1x00","低位子宫下段剖宫产");
    }

    //-------------------费用极高结束----------------------------------



    //----------------------未入组开始-------------------------------
    //CHS 未入组
    //未入组清单  	‘未入组-编码未识别‘，‘未入组-歧义病案‘，‘未入组-住院天数>60‘，‘未入组-总费用<5元‘，‘未入组-住院天数>60且总费用<5‘；‘其他原因未入组’；‘死亡未分组’
    /*未入组-编码未识别	‘drg.drgStatus' = '2’    chs目前没有这个了
    未入组-歧义病案	‘drg.drgStatus' = '9’
    未入组-住院天数>60	‘drg.drgStatus' = '3’   chs目前没有这个了
    未入组-总费用<5元	‘drg.drgStatus' = '4’   chs目前没有这个了
    未入组-住院天数>60且总费用<5	‘drg.drgStatus' = '5’   chs目前没有这个了
    其他原因未入组	‘drg.drgStatus' = '10’
    //CHS 未入组  其他原因未入组*/
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_Not_InGroup_01(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHSWRZ-01-"+backendStr;
        ChengJiuObject.createObject(name,"","","118493.9","2","","");
    }

    //CHS 正常入组
    @RepeatedTest(100)
    @Execution(CONCURRENT)
    public void CHS_InGroup(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-NCHSWRZ-"+backendStr;
        ChengJiuObject.createObject(name,"胃癌伴出血","K92.800x002","106644.51","2","44.1300x001","胃镜检查");
    }

    //CHS 未入组 修改为 入组+费用极低风险 入组加正常  入组加费用极高
    @ParameterizedTest
    @CsvFileSource(resources = "/data/binganhao.csv",numLinesToSkip = 1)
    public void CHS_Not_InGroup_in_di(String name){
        //以下三种情况选一种来跑
        //入组加费用极低
        //ChengJiuObject.createObject(name,"胃癌伴出血","K92.800x002","10.00","2","44.1300x001","胃镜检查");
        //入组加费用正常
        //ChengJiuObject.createObject(name,"胃癌伴出血","K92.800x002","106644.51","2","44.1300x001","胃镜检查");
        //入组加费用极高
        //ChengJiuObject.createObject(name,"胃癌伴出血","K92.800x002","100000.00","2","44.1300x001","胃镜检查");
        //未入组
        ChengJiuObject.createObject(name,"","","118493.9","2","","");

    }

    //CHS 未入组  歧义病案
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CHS_Not_InGroup_02(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CHSWRZ-02-"+backendStr;
        ChengJiuObject.createObject(name,"胫骨骨折","S82.202","118493.9","2","01.1800x002","脊髓神经刺激器置入术");
    }

    //----------------------未入组结束-------------------------------

}
