package testng;

import org.testng.annotations.Test;

/**
 * @ClassName MultiThreadDemo
 * @Description TODO
 * @Author yangfan
 * @Date 2021/12/31 12:30
 */
public class MultiThreadDemo {

    @Test
    public void funA() throws Exception {
        Thread.sleep(1000);
        System.out.println("装入坚果A \n");
    }

    @Test
    public void funB() throws Exception {
        Thread.sleep(1000);
        System.out.println("装入坚果B\n");
    }

    @Test(threadPoolSize = 5,invocationCount = 5,timeOut = 60000)
    public void funC() throws Exception {
        Thread.sleep(1000);
        long id = Thread.currentThread().getId();
        System.out.println("线程号" + id + "装入坚果C \n");
    }

    @Test
    public void funD() throws Exception {
        Thread.sleep(1000);
        System.out.println("装入坚果D\n");
    }

    @Test
    public void funE() throws Exception {
        Thread.sleep(1000);
        System.out.println("装入坚果E\n");
    }

}
