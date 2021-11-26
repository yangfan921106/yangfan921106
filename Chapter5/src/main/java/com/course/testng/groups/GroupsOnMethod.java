package groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
            public void stest1(){
        System.out.println("这是服务端组的测试方法1");
    }

    @Test(groups = "server")
    public void stest2(){
        System.out.println("这是服务端组的测试方法2");
    }

    @Test(groups = "client")
    public void ctest1(){
        System.out.println("这是客户端组的测试方法1");
    }

    @Test(groups = "client")
    public void ctest2(){
        System.out.println("这是客户端组的测试方法2");
    }

    @BeforeGroups("server")
    public void sgroupmethod1(){
        System.out.println("这是服务端组运行之前的方法");
    }

    @AfterGroups("server")
    public void sgroupmethod2(){
        System.out.println("这是服务端组运行之后的方法");
    }

    @BeforeGroups("client")
    public void cgroupmethod1(){
        System.out.println("这是客户端组运行之前的方法");
    }

    @AfterGroups("client")
    public void cgroupmethod2(){
        System.out.println("这是客户端组运行之后的方法");
    }
}
