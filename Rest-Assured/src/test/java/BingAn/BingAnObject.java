package BingAn;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import utils.FakerUtils;


import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

/**
 * @ClassName BingAnObject
 * @Description TODO
 * @Author yangfan
 * @Date 2022/6/14 16:17
 */
public class BingAnObject {

    static String backendStr = Thread.currentThread().getId()+ FakerUtils.getTimeStamp();
    static String name = "YFF-"+backendStr;

    static String healthCardNum = "card"+FakerUtils.getTimeStamp();
    static String patientName = "YFF-"+backendStr;
    static String fileSrc = "YFF-"+backendStr;

    static String dischargeDate = "2021-04-02 13:51:00";
    static String admissionDate = "2021-03-13 13:51:00";
    static String hospitalizationDays = "20";


    public static void createBingAnObject(String name,String ZYZD,String JBDM,String ZFY,String LYFS,String SSJCZBM1,String SSJCZMC1) {
        String body =" [ {\n" +
                "        \"uniqField\": \""+name+"\",\n" +
                "        \"relationField\": \""+name+"\",\n" +
                "        \"caseNumber\": \""+name+"\",\n" +
                "        \"hospitalName\": \"运维测试机构\",\n" +
                "        \"hospitalCode\": \"20200928\",\n" +
                "        \"paymentMethod\": \"1\",\n" +
                "        \"healthCardNum\": \""+healthCardNum+"\",\n" +
                "        \"hospitalizedTimes\": \"1\",\n" +
                "        \"admissionRoute\": \"1\",\n" +
                "        \"admissionDate\": \""+admissionDate+"\",\n" +
                "        \"admissionDeptName\": \"A01\",\n" +
                "        \"admissionDeptCode\": \"A02\",\n" +
                "        \"transferDeptCode\": \"A03\",\n" +
                "        \"dischargeDate\": \""+dischargeDate+"\",\n" +
                "        \"dischargeDeptName\": \"呼吸内科\",\n" +
                "        \"dischargeDeptCode\": \"A01\",\n" +
                "        \"hospitalizationDays\": \""+hospitalizationDays+"\",\n" +
                "        \"outPatientDiagnosis\": \"胆囊结石伴胆囊炎\",\n" +
                "        \"outPatientDiagnosisICDCode\": \"K80.100x001\",\n" +
                "        \"externalCause\": \"1\",\n" +
                "        \"externalCauseICDCode\": \"2\",\n" +
                "        \"pathologicalDiagnosis\": \"3\",\n" +
                "        \"pathologicalDiagnosisICDCode\": \"4\",\n" +
                "        \"pathologicalDiagnosisNum\": \"5\",\n" +
                "        \"drugAllergyFlag\": \"1\",\n" +
                "        \"allergicDrugs\": \"\",\n" +
                "        \"autoPsyFlag\": \"\",\n" +
                "        \"bloodType\": \"1\",\n" +
                "        \"bloodRHType\": \"2\",\n" +
                "        \"caseQuality\": \"1\",\n" +
                "        \"qcDate\": \"2018-02-28\",\n" +
                "        \"leaveWay\": \""+LYFS+"\",\n" +
                "        \"hospitalNameTransferredFirst\": \"\",\n" +
                "        \"hospitalNameTransferredSecond\": \"\",\n" +
                "        \"reHospitalizationPlan\": \"1\",\n" +
                "        \"reHospitalizationPurpose\": \"\",\n" +
                "        \"daysOfComaDurationBeforeHospitalized\": \"0\",\n" +
                "        \"hoursOfComaDurationBeforeHospitalized\": \"0\",\n" +
                "        \"minutesOfComaDurationBeforeHospitalized\": \"0\",\n" +
                "        \"daysOfComaDurationAfterHospitalized\": \"0\",\n" +
                "        \"hoursOfComaDurationAfterHospitalized\": \"0\",\n" +
                "        \"minutesOfComaDurationAfterHospitalized\": \"0\",\n" +
                "        \"diagnoseNameOnAdmission\": \"\",\n" +
                "        \"diagnoseICDCodeOnAdmission\": \"\",\n" +
                "        \"diagnosisDate\": \"2018-02-22\",\n" +
                "        \"hospitalizationType\": \"\",\n" +
                "        \"diagnoseConditionOnAdmission\": \"\",\n" +
                "        \"transferredFromHospType\": \"\",\n" +
                "        \"transferredFromHospNameFirst\": \"\",\n" +
                "        \"transferredFromHospNameSecond\": \"\",\n" +
                "        \"transferredFromHospNameOther\": \"\",\n" +
                "        \"transferredToHospType\": \"\",\n" +
                "        \"transferredToHospNameFirst\": \"\",\n" +
                "        \"transferredToHospNameSecond\": \"\",\n" +
                "        \"admissionLifeAbilityScore\": \"\",\n" +
                "        \"dischargeLifeAbilityScore\": \"\",\n" +
                "        \"useClinicalPathWay\": \"2\",\n" +
                "        \"ifUseAntibiotics\": \"\",\n" +
                "        \"purposeOfUseAntibiotics\": \"\",\n" +
                "        \"schemeOfUseAntibiotics\": \"\",\n" +
                "        \"daysOfUseAntibiotics\": \"\",\n" +
                "        \"infectiousDiseaseReport\": \"\",\n" +
                "        \"intensiveCareDays\": \"\",\n" +
                "        \"primaryCareDays\": \"10\",\n" +
                "        \"secondaryCareDays\": \"20\",\n" +
                "        \"tertiaryCareDays\": \"30\",\n" +
                "        \"criticallyIllFlag\": \"\",\n" +
                "        \"unplannedSecondarySurgeryFlag\": \"\",\n" +
                "        \"noniVentilatorDuration\": \"\",\n" +
                "        \"inICUTotalCount\": null,\n" +
                "        \"transfusionRBCVolume\": \"\",\n" +
                "        \"transfusionPLTVolume\": \"\",\n" +
                "        \"transfusionPlasmaVolume\": \"\",\n" +
                "        \"transfusionWholeBloodVolume\": \"\",\n" +
                "        \"transfusionAutologousBloodVolume\": \"\",\n" +
                "        \"transfusionReactions\": \"\",\n" +
                "        \"consistentDiagBeforeAndAfterAdmission\": \"\",\n" +
                "        \"consistentDiagBeforeAndAfterSurgery\": \"\",\n" +
                "        \"consistentDiagBetweenClinicalAndPathological\": \"\",\n" +
                "        \"resuscitateFlag\": null,\n" +
                "        \"rescueTimes\": \"0\",\n" +
                "        \"succeedingRescueTimes\": \"0\",\n" +
                "        \"groupedCondition\": null,\n" +
                "        \"completion\": null,\n" +
                "        \"iVentilatorDuration\": \"\",\n" +
                "        \"ICUFlag\": \"\",\n" +
                "        \"HBsAg\": \"\",\n" +
                "        \"HCVAb\": \"\",\n" +
                "        \"HIVAb\": \"\",\n" +
                "        \"patientName\": \""+patientName+"\",\n" +
                "        \"gender\": \"1\",\n" +
                "        \"birthDate\": \"1992-08-06\",\n" +
                "        \"age\": \"30\",\n" +
                "        \"country\": \"中国\",\n" +
                "        \"newbornAge\": \"\",\n" +
                "        \"newbornStartWeight\": \"\",\n" +
                "        \"newbornStartWeight_2\": \"\",\n" +
                "        \"newbornStartWeight_3\": \"\",\n" +
                "        \"newbornStartWeight_4\": \"\",\n" +
                "        \"newbornStartWeight_5\": \"\",\n" +
                "        \"newbornWeightOnAdmission\": \"\",\n" +
                "        \"birthPlaceDetail\": \"重庆市\",\n" +
                "        \"nativePlace\": \"23\",\n" +
                "        \"nation\": \"01\",\n" +
                "        \"identityCard\": \"142623199211052525\",\n" +
                "        \"identityCardType\": \"1\",\n" +
                "        \"occupation\": \"24\",\n" +
                "        \"maritalStatus\": \"20\",\n" +
                "        \"presentAddressDetail\": \"重庆市南岸区后堡玛瑙花园15号楼6单元\",\n" +
                "        \"presentAddressPhone\": \"15178849186\",\n" +
                "        \"presentAddressPostcode\": \"400060\",\n" +
                "        \"householdRegistryDetail\": \"重庆市南岸区后堡玛瑙花园15号楼6单元南岸区\",\n" +
                "        \"householdRegistryPostcode\": \"400060\",\n" +
                "        \"orgNameAndAddress\": \"重庆市南岸区后堡玛瑙花园15号楼6单元\",\n" +
                "        \"orgPhone\": \"11\",\n" +
                "        \"orgPostcode\": \"30000015\",\n" +
                "        \"contactsName\": \"张年云\",\n" +
                "        \"contactsRelation\": \"8\",\n" +
                "        \"contactsAddressDetail\": \"重庆市南岸区后堡玛瑙花园15号楼6单元\",\n" +
                "        \"contactsPhone\": \"18375790258\",\n" +
                "        \"deptDirectorName\": \"刘桦\",\n" +
                "        \"deptDirectorCode\": \"\",\n" +
                "        \"deptDirectorLicenseCode\": \"\",\n" +
                "        \"chiefPhysicianName\": \"陈元文\",\n" +
                "        \"chiefPhysicianCode\": \"\",\n" +
                "        \"chiefPhysicianLicenseCode\": \"\",\n" +
                "        \"attendingDrName\": \"drname\",\n" +
                "        \"attendingDrCode\": \"drcode\",\n" +
                "        \"attendingDrLicenseCode\": \"\",\n" +
                "        \"residentDrName\": \"123456\",\n" +
                "        \"residentDrCode\": \"\",\n" +
                "        \"residentDrLicenseCode\": \"\",\n" +
                "        \"primaryNurseName\": \"nursename\",\n" +
                "        \"primaryNurseCode\": \"123456\",\n" +
                "        \"primaryNurseLicenseCode\": \"\",\n" +
                "        \"traineeDrName\": \"-\",\n" +
                "        \"internDrName\": \"-\",\n" +
                "        \"medicalCoderName\": \"编码员\",\n" +
                "        \"qcDrName\": \"陈元文\",\n" +
                "        \"qcNurseName\": \"张静\",\n" +
                "        \"westDiagnose\": [\n" +
                "            {\n" +
                "                \"diagnosisName\": \""+ZYZD+"\",\n" +
                "                \"diagnosisICDCode\": \""+JBDM+"\",\n" +
                "                \"situationAtDischarge\": \"2\",\n" +
                "                \"conditionOnAdmission\": \"2\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"diagnosisName\": \"\",\n" +
                "                \"diagnosisICDCode\": \"\",\n" +
                "                \"situationAtDischarge\": \"2\",\n" +
                "                \"conditionOnAdmission\": \"\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"eastDiagnose\": [\n" +
                "            {\n" +
                "                \"diagnosisName\": \"不寐病\",\n" +
                "                \"diagnosisICDCode\": \"A04.01.13\",\n" +
                "                \"situationAtDischarge\": \"900001\",\n" +
                "                \"conditionOnAdmission\": \"900002\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"diagnosisName\": \"绦虫病\",\n" +
                "                \"diagnosisICDCode\": \"A02.02\",\n" +
                "                \"situationAtDischarge\": \"\",\n" +
                "                \"conditionOnAdmission\": \"900003\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"diagnosisName\": \"绦虫病\",\n" +
                "                \"diagnosisICDCode\": \"A02.02\",\n" +
                "                \"situationAtDischarge\": \"2\",\n" +
                "                \"conditionOnAdmission\": \"900004\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"westOperation\": [\n" +
                "            {\n" +
                "                \"operationICDCode\": \""+SSJCZBM1+"\",\n" +
                "                \"operationDate\": \"2021-12-16 10:10:10 \",\n" +
                "                \"operationLevel\": \"4\",\n" +
                "                \"operationName\": \""+SSJCZMC1+"\",\n" +
                "                \"operationDrName\": \"医生名儿\",\n" +
                "                \"firstAssistantName\": \"吴念\",\n" +
                "                \"secondAssistantName\": \"\",\n" +
                "                \"incisionClass\": \"3\",\n" +
                "                \"healing\": \"1\",\n" +
                "                \"anesthesiaType\": \"1\",\n" +
                "                \"assistantLevel\": \"\",\n" +
                "                \"operationDuration\": \"\",\n" +
                "                \"anesthesiaDrName\": \"张雪飞\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"eastOperation\": [\n" +
                "            {\n" +
                "                \"operationICDCode\": \"51.2300\",\n" +
                "                \"operationDate\": \"2018-02-24 15:15:15\",\n" +
                "                \"operationLevel\": \"2\",\n" +
                "                \"operationName\": \"腹腔镜下胆囊切除术-中\",\n" +
                "                \"operationDrName\": \"曹阳\",\n" +
                "                \"firstAssistantName\": \"吴念\",\n" +
                "                \"secondAssistantName\": \"\",\n" +
                "                \"incisionClass\": \"3\",\n" +
                "                \"healing\": \"1\",\n" +
                "                \"anesthesiaType\": \"1\",\n" +
                "                \"assistantLevel\": \"\",\n" +
                "                \"operationDuration\": \"\",\n" +
                "                \"anesthesiaDrName\": \"张雪飞\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"feeDetail\": [\n" +
                "            {\n" +
                "                \"feeCode\": \"0001\",\n" +
                "                \"fee\": \""+ZFY+"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0002\",\n" +
                "                \"fee\": 3173.25\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0003\",\n" +
                "                \"fee\": 907\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0004\",\n" +
                "                \"fee\": 10\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0005\",\n" +
                "                \"fee\": 20\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0006\",\n" +
                "                \"fee\": 30\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0007\",\n" +
                "                \"fee\": 40\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0008\",\n" +
                "                \"fee\": 50\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0009\",\n" +
                "                \"fee\": 60\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0010\",\n" +
                "                \"fee\": 70.8\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0011\",\n" +
                "                \"fee\": 80.1\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0012\",\n" +
                "                \"fee\": 90.56\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0013\",\n" +
                "                \"fee\": 100.2\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0014\",\n" +
                "                \"fee\": 110\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0015\",\n" +
                "                \"fee\": 120\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0016\",\n" +
                "                \"fee\": 130\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0017\",\n" +
                "                \"fee\": 140\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0018\",\n" +
                "                \"fee\": 150\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0019\",\n" +
                "                \"fee\": 160\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0020\",\n" +
                "                \"fee\": 170\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0021\",\n" +
                "                \"fee\": 180\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0022\",\n" +
                "                \"fee\": 190\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0023\",\n" +
                "                \"fee\": 200\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0024\",\n" +
                "                \"fee\": 210\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0025\",\n" +
                "                \"fee\": 220\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0026\",\n" +
                "                \"fee\": 230\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0027\",\n" +
                "                \"fee\": 240\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0028\",\n" +
                "                \"fee\": 250\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0029\",\n" +
                "                \"fee\": 260\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0030\",\n" +
                "                \"fee\": 27068\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0031\",\n" +
                "                \"fee\": 280.92\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0032\",\n" +
                "                \"fee\": 290\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0033\",\n" +
                "                \"fee\": 300\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0034\",\n" +
                "                \"fee\": 310\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0035\",\n" +
                "                \"fee\": 320\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0036\",\n" +
                "                \"fee\": 330\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0037\",\n" +
                "                \"fee\": 340\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0038\",\n" +
                "                \"fee\": 350\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0039\",\n" +
                "                \"fee\": 360\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0040\",\n" +
                "                \"fee\": 370.22\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0041\",\n" +
                "                \"fee\": 380.24\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0042\",\n" +
                "                \"fee\": 390\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0043\",\n" +
                "                \"fee\": 400\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0044\",\n" +
                "                \"fee\": 410\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0045\",\n" +
                "                \"fee\": 420\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0046\",\n" +
                "                \"fee\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0047\",\n" +
                "                \"fee\": 430\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0048\",\n" +
                "                \"fee\": 440\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0049\",\n" +
                "                \"fee\": 450\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0050\",\n" +
                "                \"fee\": 460\n" +
                "            },\n" +
                "            {\n" +
                "                \"feeCode\": \"0051\",\n" +
                "                \"fee\": 1000\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]";

        String url = "http://h128.ad99.cc:8803/dl/api/v1/data/jsonUpload?fileSrc=";
        String nurl = url+name;



        Response response = given().log().all()
                .contentType("application/json")
                .body(body)
                .post(nurl)
                .then()
                .log().body()
                .extract().response();

        assertEquals("0", response.path("code").toString());
    }
}
