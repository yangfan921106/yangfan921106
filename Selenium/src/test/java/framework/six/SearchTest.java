package framework.six;

import org.junit.jupiter.api.Test;

import java.sql.Driver;

/**
 * @ClassName SearchTest
 * @Description TODO
 * @Author yangfan
 * @Date 2022/4/14 19:17
 */
public class SearchTest {

    @Test
    void search(){
        MainPage main = new MainPage();
        SearchPage searchPage= main.search();
        searchPage.search("lala");
    }
}


