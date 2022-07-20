import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName application
 * @Description 叫这个名字的类一般是入口的一个类
 * @Author yangfan
 * @Date 2021/12/14 12:15
 */

@SpringBootApplication
@ComponentScan("com.course")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

}
