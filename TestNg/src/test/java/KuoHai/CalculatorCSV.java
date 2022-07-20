package KuoHai;

/**
 * @ClassName CalculatorCSV
 * @Description TODO
 * @Author yangfan
 * @Date 2022/1/18 12:30
 */

import com.util.CSVData;
import com.util.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


public class CalculatorCSV {

    @DataProvider(name="num")
    public Iterator<Object[]> Numbers() throws IOException{
        return (Iterator<Object[]>)new CSVData("add.csv");
    }
    @Test(dataProvider="num")
    public void testAdd(Map<String, String> data){
        float num1=Float.parseFloat(data.get("n1"));
        float num2=Float.parseFloat(data.get("n2"));
        float expectedResult=Float.parseFloat(data.get("r1"));
        float actual=Calculator.fadd(num1, num2);
        System.out.print("实际计算出来的值为："+actual);
        System.out.println("，期望计算出来的值为："+expectedResult);
        Assert.assertEquals(actual, expectedResult);
    }
}