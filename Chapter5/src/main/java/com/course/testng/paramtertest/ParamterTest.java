package paramtertest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterTest {

    @Test
    @Parameters({"name","age"})
    public void paramtertest(String name,int age){
        System.out.println("name = "+ age+"; age = "+age);

    }
}
