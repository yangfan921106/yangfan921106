package framework.seven;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * @ClassName TestCase
 * @Description 这个里面存的是一些共用的东西 potestcase和seleniumtestcase继承于testcase
 * case的生成和变量的替换也可以放在这里
 * @Author yangfan
 * @Date 2022/4/14 20:42
 */
public class TestCase {
    public List<String> data;
    public List<HashMap<String, Object>> steps;
    public int index = 0;


    /**
     * 测试用例裂变，基于数据自动生成多份测试用例
     * @return
     */
    public List<TestCase> testcaseGenerate() {
        List<TestCase> testCaseList=new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            POTestCase testcaseNew = new POTestCase();
            testcaseNew.index=i;
            testcaseNew.steps=steps;
            testcaseNew.data=data;
            testCaseList.add(testcaseNew);
        }
        return testCaseList;

    }

    //getvalue改成一个公共方法。大家都可以访问
    public Object getValue(HashMap<String, Object> step, String key, Object defaultValue) {
        return step.getOrDefault(key, defaultValue);
    }

    /**
     * 替换yaml中的一些变量，复杂结构需要用递归
     * @param step
     * @param key
     * @return
     */
    public Object getValue(HashMap<String, Object> step, String key) {
        Object value=step.get(key);
        if (value instanceof String){
            //进行替换 todo：复杂结构支持
            return ((String) value).replace("${data}", data.get(index));
        }else{
            return value;
        }
    }

    //在这里实现一个空的方法
    public void run(){

    }

}
