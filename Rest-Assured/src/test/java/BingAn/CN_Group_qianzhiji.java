package BingAn;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.Execution;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

/**
 * @ClassName Group
 * @Description 数据通过8803的接口上传
 * @Author yangfan
 * @Date 2022/6/14 16:40
 */
public class CN_Group_qianzhiji {

    //------------------非病组结算-----------------
    //非病组结算  住院天数大于100  或者 住院天数小于2
    //住院天数等于100   这个应该纳入结算   测试边界值50
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_Feibingzujiesuan_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-FBZJS01-"+backendStr;

        BingAnObject.createBingAnObject(name,"胎膜早破","O42.900","3500","2","","");
    }

    //住院天数小于100   这个应该纳入结算
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_Feibingzujiesuan_2(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-FBZJS02-"+backendStr;

        BingAnObject.createBingAnObject(name,"胎膜早破","O42.900","3500","2","","");
    }

    //住院天数大于100   这个不应该纳入结算
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_Feibingzujiesuan_3(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-FBZJS03-"+backendStr;

        BingAnObject.createBingAnObject(name,"胎膜早破","O42.900","3500","2","","");
    }

    //住院天数小于2   这个不应该纳入结算
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_Feibingzujiesuan_4(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-FBZJS04-"+backendStr;

        BingAnObject.createBingAnObject(name,"胎膜早破","O42.900","3500","2","","");
    }

    //住院天数等于2   这个应该纳入结算
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_Feibingzujiesuan_5(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-FBZJS05-"+backendStr;

        BingAnObject.createBingAnObject(name,"胎膜早破","O42.900","3500","2","","");
    }

    //住院天数大于2   这个应该纳入结算
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_Feibingzujiesuan_6(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-FBZJS06-"+backendStr;

        BingAnObject.createBingAnObject(name,"胎膜早破","O42.900","3500","2","","");
    }


    //住院天数为空  这个应该纳入结算
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_Feibingzujiesuan_7(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-FBZJS07-"+backendStr;

        BingAnObject.createBingAnObject(name,"胎膜早破","O42.900","3500","2","","");
    }


    //------------------非病组结算   结束-----------------




    //CN 结余预测
    //入组 OZ15    标杆是2657.4725  结余预测=标杆-zfy
   /*
    select drg,ybfkfs,(sum_zyl_fy+xyf_fy)/fy_avg  'yaozhanbi',hcl_fy/fy_avg,fy_avg from t_benchmark_payment where bg_id='1640314175'
    and drg='OZ15';
    */
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_JieYuYuCe_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-77JYYC-"+backendStr;
        BingAnObject.createBingAnObject(name,"胎膜早破","O42.900","1657.4725","2","","");
    }




    //---------------------------死亡病案开始-----------------------------
    //死亡病案
    //CN 低风险死亡  入组OB19
    /*
select fxdj,drg,ds_fz,qz,fy_avg FROM dlcms_hospital.t_benchmark_avg WHERE bg_id='1640314175' AND drg='OB25';
UPDATE dlcms_hospital.t_benchmark_avg SET fxdj = '1' WHERE  bg_id='1640314175' AND drg='OB25';
     */
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_DI_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-DI-SW-"+backendStr;
        BingAnObject.createBingAnObject(name,"胎膜早破","O42.900","25226.67","5","74.1x01","剖宫产术，子宫下段横切口");
    }

    //CN 低风险未死亡
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_DI_no_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-DI-NSW-"+backendStr;
        BingAnObject.createBingAnObject(name,"胎膜早破","O42.900","25226.67","2","74.1x01","剖宫产术，子宫下段横切口");
    }



    //无风险死亡   入组为KS15
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_01_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-01-SW-"+backendStr;
        BingAnObject.createBingAnObject(name,"2型糖尿病伴多个并发症","E11.700x033","19056.93","5","","");
    }

    //中低风险死亡   入组为GS15
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_02_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-02-SW-"+backendStr;
        BingAnObject.createBingAnObject(name,"胃癌伴出血","K92.800x002","106644.51","5","44.1300x001","胃镜检查");
    }

    //中高风险死亡 入组为FZ15
    /*
    select fxdj,drg,ds_fz,qz,fy_avg FROM dlcms_hospital.t_benchmark_avg WHERE bg_id='1640314175' AND drg='FZ15';
UPDATE dlcms_hospital.t_benchmark_avg SET fxdj = '3' WHERE  bg_id='1640314175' AND drg='FZ15';
     */
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_03_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-03-SW-"+backendStr;
        BingAnObject.createBingAnObject(name,"心肌病","I42.900","72114.48","5","","");
    }

    //高风险死亡  入组为EX15
    /*
select fxdj,drg,ds_fz,qz,fy_avg FROM dlcms_hospital.t_benchmark_avg WHERE bg_id='1640314175' AND drg='EX15';
UPDATE dlcms_hospital.t_benchmark_avg SET fxdj = '4' WHERE  bg_id='1640314175' AND drg='EX15';
     */
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_04_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-04-SW-"+backendStr;
        BingAnObject.createBingAnObject(name,"支气管哮喘(急性发作期)","J45.900x021","49851.99","5","","");
    }

    //无风险死亡  入组为LJ15
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_05_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-05-SW-"+backendStr;
        BingAnObject.createBingAnObject(name,"前列腺恶性肿瘤","C61.x00","16766.2300","5","60.2902","经尿道前列腺切除术（TURP）");
    }

    //未入组死亡
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_06_death_1(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-06-SW-"+backendStr;
        BingAnObject.createBingAnObject(name,"胃静脉曲张AAA","AAA","5948.66","5","","");
    }


    //--------------------------------死亡病案结束-------------------------------------------------------------


    //-------------------------------费用极低开始-------------------------------------------------------------
    //费用极低的病案

    //CN 费用极低  入组 LJ15    14912.8978
    /*
    点值小于0.8  0.5  费用倍率小于0.99  0.5  标注极低
    点值小于0.8  0.5  费用倍率等于0.99    0.99  标注极低
    点值小于0.8  0.5  费用倍率大于0.99  1  正常
     */
    //    点值小于0.8  0.5  费用倍率小于0.99  0.5  标注极低
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_01(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIDI-01-"+backendStr;
        BingAnObject.createBingAnObject(name,"前列腺恶性肿瘤","C61.x00","7456.4489","2","60.2902","经尿道前列腺切除术（TURP）");
    }

    //   点值小于0.8  0.5  费用倍率等于0.99    0.99  标注极低
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_02(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIDI-02-"+backendStr;
        BingAnObject.createBingAnObject(name,"前列腺恶性肿瘤","C61.x00","14763.7688","2","60.2902","经尿道前列腺切除术（TURP）");
    }





    //点值小于0.8  0.5  费用倍率大于0.99  1  正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_03(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIDI-03-"+backendStr;
        BingAnObject.createBingAnObject(name,"前列腺恶性肿瘤","C61.x00","14912.8978","2","60.2902","经尿道前列腺切除术（TURP）");
    }

    //OB25   9229.6337
    /*
    点值等于0.8   0.8  费用倍率 小于0.4  0.3  标注极低
    点值等于0.8  0.8  费用倍率  等于0.4  0.4  正常
    点值等于0.8  0.8  费用倍率  大于0.4  0.5  正常
     */
    //    点值等于0.8   0.8  费用倍率 小于0.4  0.3  标注极低
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_04(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIDI-04-"+backendStr;
        BingAnObject.createBingAnObject(name,"胎膜早破","O42.900","2768.8901","2","74.1x01","剖宫产术，子宫下段横切口");
    }

    //        点值等于0.8  0.8  费用倍率  等于0.4  0.4  正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_05(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIDI-05-"+backendStr;
        BingAnObject.createBingAnObject(name,"胎膜早破","O42.900","3691.8535","2","74.1x01","剖宫产术，子宫下段横切口");
    }

    //            点值等于0.8  0.8  费用倍率  大于0.4  0.5  正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_06(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIDI-06-"+backendStr;
        BingAnObject.createBingAnObject(name,"胎膜早破","O42.900","4614.8169","2","74.1x01","剖宫产术，子宫下段横切口");
    }

    /*
    点值大于0.8小于2  1.5  费用倍率  小于0.4  0.3  标注极低
    点值大于0.8小于2  1.5  费用倍率  等于0.4  0.4  正常
    点值大于0.8小于2   1.5  费用倍率 大于0.4  0.5  正常
     */
    //EX15  7387.9591
    //    点值大于0.8小于2  1.5  费用倍率  小于0.4  0.3  标注极低
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_07(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIDI-07-"+backendStr;
        BingAnObject.createBingAnObject(name,"支气管哮喘(急性发作期)","J45.900x021","2216.3877","2","","");
    }

    //        点值大于0.8小于2  1.5  费用倍率  等于0.4  0.4  正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_08(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIDI-08-"+backendStr;
        BingAnObject.createBingAnObject(name,"支气管哮喘(急性发作期)","J45.900x021","2955.1836","2","","");
    }

    //    点值大于0.8小于2   1.5  费用倍率 大于0.4  0.5  正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_09(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIDI-09-"+backendStr;
        BingAnObject.createBingAnObject(name,"支气管哮喘(急性发作期)","J45.900x021","3693.9796","5","","");
    }

    /*
    点值等于2  2  费用倍率小于0.4  0.3  标注极低
    点值等于2  2  费用倍率等于0.4  0.4  正常
    点值等于2  2  费用倍率大于0.4  0.5  正常
     */
    //    点值等于2  2  费用倍率小于0.4  0.3  标注极低
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_10(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIDI-10-"+backendStr;
        BingAnObject.createBingAnObject(name,"2型糖尿病伴多个并发症","E11.700x033","1925.9493","2","","");
    }

    //    点值等于2  2  费用倍率等于0.4  0.4  正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_11(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIDI-11-"+backendStr;
        BingAnObject.createBingAnObject(name,"2型糖尿病伴多个并发症","E11.700x033","2567.9324","2","","");
    }

    //    点值等于2  2  费用倍率大于0.4  0.5  正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_12(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIDI-12-"+backendStr;
        BingAnObject.createBingAnObject(name,"2型糖尿病伴多个并发症","E11.700x033","3209.9156","2","","");
    }


    /*
    点值大于2  3  费用倍率小于0.6  0.5  标注极低
    点值大于2  3  费用倍率等于0.6  0.6  标注极低
    点值大于2  3  费用倍率大于0.6  0.7  正常
     */
    //     点值大于2  3  费用倍率小于0.6  0.5  标注极低
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_13(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIDI-13-"+backendStr;
        BingAnObject.createBingAnObject(name,"胃癌伴出血","K92.800x002","4880.2268","2","44.1300x001","胃镜检查");
    }
    //        点值大于2  3  费用倍率等于0.6  0.6  标注极低
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_14(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIDI-14-"+backendStr;
        BingAnObject.createBingAnObject(name,"胃癌伴出血","K92.800x002","5856.2721","2","44.1300x001","胃镜检查");
    }

    //        点值大于2  3  费用倍率大于0.6  0.7  正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_15(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIDI-15-"+backendStr;
        BingAnObject.createBingAnObject(name,"胃癌伴出血","K92.800x002","6832.3175","2","44.1300x001","胃镜检查");
    }


    //-----------------费用极低结束-----------------------------------------



    //------------------费用极高开始-----------------------
    //CN 费用极高
    //CN 费用极高  入组 LJ15    14912.8978
    /*
点值小于0.8   0.5  费用倍率 大于 1.01   1.02    标注极高
点值小于0.8   0.5  费用倍率  等于  1.01   1.01   正常
点值小于0.8    0.5   费用倍率  小于 1.01   1   正常
     */
    //    点值小于0.8   0.5  费用倍率 大于 1.01   1.02    标注极高
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_High_01(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-01-"+backendStr;
        BingAnObject.createBingAnObject(name,"前列腺恶性肿瘤","C61.x00","15211.1558","2","60.2902","经尿道前列腺切除术（TURP）");
    }

    //    点值小于0.8   0.5  费用倍率  等于  1.01   1.01   正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_High_02(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-02-"+backendStr;
        BingAnObject.createBingAnObject(name,"前列腺恶性肿瘤","C61.x00","15062.0268","2","60.2902","经尿道前列腺切除术（TURP）");
    }

    //    点值小于0.8    0.5   费用倍率  小于 1.01   1   正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_High_03(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-03-"+backendStr;
        BingAnObject.createBingAnObject(name,"前列腺恶性肿瘤","C61.x00","14912.8978","2","60.2902","经尿道前列腺切除术（TURP）");
    }


    //OB25   9229.6337
    /*
点值等于0.8   0.8   费用倍率 小于1.5   1.4    正常
点值等于0.8  0.8   费用倍率  等于1.5    1.5  标注极高
点值等于0.8  0.8   费用倍率  大于1.5   1.6   标注极高
     */
    //    点值等于0.8   0.8   费用倍率 小于1.5   1.4    正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_High_04(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-04-"+backendStr;
        BingAnObject.createBingAnObject(name,"胎膜早破","O42.900","12921.4872","2","74.1x01","剖宫产术，子宫下段横切口");
    }

    //    点值等于0.8  0.8   费用倍率  等于1.5    1.5  标注极高
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_High_05(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-05-"+backendStr;
        BingAnObject.createBingAnObject(name,"胎膜早破","O42.900","13844.4506","2","74.1x01","剖宫产术，子宫下段横切口");
    }

    //    点值等于0.8  0.8   费用倍率  大于1.5   1.6   标注极高
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_High_06(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-06-"+backendStr;
        BingAnObject.createBingAnObject(name,"胎膜早破","O42.900","14767.4139","2","74.1x01","剖宫产术，子宫下段横切口");
    }

    /*
点值大于0.8小于2   1.5   费用倍率  小于1.5   1.4  正常
点值大于0.8小于2   1.5   费用倍率  等于1.5    1.5  标注极高
点值大于0.8小于2   1.5   费用倍率  大于1.5   1.6   标注极高
 */
    //EX15  7387.9591
    //    点值大于0.8小于2   1.5   费用倍率  小于1.5   1.4  正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_High_07(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-07-"+backendStr;
        BingAnObject.createBingAnObject(name,"支气管哮喘(急性发作期)","J45.900x021","10343.1427","2","","");
    }

    //    点值大于0.8小于2   1.5   费用倍率  等于1.5    1.5  标注极高
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_High_08(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-08-"+backendStr;
        BingAnObject.createBingAnObject(name,"支气管哮喘(急性发作期)","J45.900x021","11081.9387","2","","");
    }

    //    点值大于0.8小于2   1.5   费用倍率  大于1.5   1.6   标注极高
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_High_09(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-09-"+backendStr;
        BingAnObject.createBingAnObject(name,"支气管哮喘(急性发作期)","J45.900x021","11820.7346","2","","");
    }

    /*
点值等于2   2   费用倍率 小于 2  1.5   正常
点值等于2   2   费用倍率  等于2  2    正常
点值等于2   2   费用倍率  大于2  2.1  标注极高
 */
    //KS15  6419.8311
    //    点值等于2   2   费用倍率 小于 2  1.5   正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_High_10(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-10-"+backendStr;
        BingAnObject.createBingAnObject(name,"2型糖尿病伴多个并发症","E11.700x033","9629.7467","2","","");
    }

    //    点值等于2   2   费用倍率  等于2  2    正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_High_11(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-11-"+backendStr;
        BingAnObject.createBingAnObject(name,"2型糖尿病伴多个并发症","E11.700x033","12839.6622","2","","");
    }

    //    点值等于2   2   费用倍率  大于2  2.1  标注极高
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_High_12(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-12-"+backendStr;
        BingAnObject.createBingAnObject(name,"2型糖尿病伴多个并发症","E11.700x033","13481.6453","2","","");
    }

    /*
点值大于2小于3  2.5  费用倍率 小于2  正常
点值大于2小于3  2.5  费用倍率 等于2  正常
点值大于2小于3  2.5  费用倍率 大于2  2.1 标注极高
*/
    //FZ15  8093.4953
    //    点值大于2小于3  2.5  费用倍率 小于2  正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_High_13(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-13-"+backendStr;
        BingAnObject.createBingAnObject(name,"心肌病","I42.900","12140.243","2","","");
    }

    //    点值大于2小于3  2.5  费用倍率 等于2  正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_High_14(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-14-"+backendStr;
        BingAnObject.createBingAnObject(name,"心肌病","I42.900","16186.9906","2","","");
    }

    //    点值大于2小于3  2.5  费用倍率 大于2  2.1 标注极高    8093.4953
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_High_15(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-15-"+backendStr;
        BingAnObject.createBingAnObject(name,"心肌病","I42.900","16996.3401","2","","");
    }

    /*
点值等于3  3  费用倍率小于3  正常
点值等于3  3  费用倍率等于3  3  标注极高
点值等于3  3  费用倍率大于3   标注极高
 */
    //GS15  9760.4535
    //     点值等于3  3  费用倍率小于3  正常
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_16(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-16-"+backendStr;
        BingAnObject.createBingAnObject(name,"胃癌伴出血","K92.800x002","24401.1338","2","44.1300x001","胃镜检查");
    }

    //     点值等于3  3  费用倍率等于3  3  标注极高
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_17(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-17-"+backendStr;
        BingAnObject.createBingAnObject(name,"胃癌伴出血","K92.800x002","29281.3605","2","44.1300x001","胃镜检查");
    }

    //     点值等于3  3  费用倍率大于3   标注极高
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_FEI_low_18(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CN-JIGAO-18-"+backendStr;
        BingAnObject.createBingAnObject(name,"胃癌伴出血","K92.800x002","30257.4059","2","44.1300x001","胃镜检查");
    }


    //-------------------费用极高结束----------------------------------



    //----------------------未入组开始-------------------------------
    //CN 未入组
    //未入组清单  	‘未入组-编码未识别‘，‘未入组-歧义病案‘，‘未入组-住院天数>60‘，‘未入组-总费用<5元‘，‘未入组-住院天数>60且总费用<5‘；‘其他原因未入组’；‘死亡未分组’
    /*未入组-编码未识别	‘drg.drgStatus' = '2’
    未入组-歧义病案	‘drg.drgStatus' = '9’
    未入组-住院天数>60	‘drg.drgStatus' = '3’
    未入组-总费用<5元	‘drg.drgStatus' = '4’
    未入组-住院天数>60且总费用<5	‘drg.drgStatus' = '5’
    其他原因未入组	‘drg.drgStatus' = '10’
    //CN 未入组  其他原因未入组*/
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_Not_InGroup_01(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CNWRZ-01-"+backendStr;
        BingAnObject.createBingAnObject(name,"","","118493.9","2","","");
    }

    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_Not_InGroup_02(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CNWRZ-02-"+backendStr;
        BingAnObject.createBingAnObject(name,"慢性胃窦炎","K29.501","118493.9","2","74.1x01","剖宫产术，子宫下段横切口");
    }

    //CN 正常入组
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_InGroup(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-NCNWRZ-"+backendStr;
        BingAnObject.createBingAnObject(name,"胃癌伴出血","K92.800x002","106644.51","2","44.1300x001","胃镜检查");
    }



    //CN 未入组  歧义病案
    @RepeatedTest(1)
    @Execution(CONCURRENT)
    public void CN_Not_InGroup_03(){
        String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
        String name = "YFF-CNWRZ-03-"+backendStr;
        BingAnObject.createBingAnObject(name,"胫骨骨折","S82.202","118493.9","2","01.1800x002","脊髓神经刺激器置入术");
    }

    //----------------------未入组结束-------------------------------



}
