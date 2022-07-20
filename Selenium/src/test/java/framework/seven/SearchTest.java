package framework.seven;

/**
 * @ClassName SearchTest
 * @Description TODO
 * @Author yangfan
 * @Date 2022/4/15 10:34
 */
import org.junit.jupiter.api.Test;

public class SearchTest {
    @Test
    void search(){
        MainPage main = new MainPage();
        SearchPage searchPage=main.search();
        searchPage.search("selenium");
    }
}

