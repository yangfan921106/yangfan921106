package selenium.tools;

import java.util.LinkedHashMap;

/**
 * @ClassName tester1
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/26 19:49
 */
public class TesterSQL {
    public static void main(String[] args) {
     //  List<LinkedHashMap<String, Object>> linkedHashMaps = DButils.excuteQuery("SELECT * FROM `dlcms_hospital`.`t_dip_result` LIMIT 0,1").get(1);
        LinkedHashMap<String, Object> stringObjectLinkedHashMap = DButils.excuteQuery("SELECT case_number FROM `dlcms_hospital`.`t_dip_result` LIMIT 0,1").get(0);
        System.out.println(stringObjectLinkedHashMap);
//        for (LinkedHashMap<String, Object> hashMap : linkedHashMaps) {
//            System.out.println(hashMap.get("case_number"));
//        }
    }
}