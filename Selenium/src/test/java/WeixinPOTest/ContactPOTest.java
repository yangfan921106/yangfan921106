package WeixinPOTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @ClassName ContactPOTest
 * @Description TODO
 * @Author yangfan
 * @Date 2022/2/10 13:34
 */
public class ContactPOTest {
    private static MainPage main;

    @BeforeAll
    static void beforeAll() throws IOException, InterruptedException {
        main = new MainPage();
    }

    @Test
    void testAddMember() throws IOException, InterruptedException {
        MainPage mainPage = new MainPage();
        ContactPage contactPage = mainPage.contact();
        contactPage.addMember("xujiayang22", "xuejiayang22", "13289702299");
    }

    @Test
    void testDepartSearchChain() throws IOException, InterruptedException {
        assertTrue(new MainPage().contact().searchDepart("南京测试部").getParyInfo().contains("无任何成员"));
    }

    @Test
    void testDepartAdd(){
        String departName = "广州测试部";
        assertTrue(main.contact().addDepart(departName).searchDepart(departName).getParyInfo().contains(departName));
    }


    @Test
    void testAddMember02() throws IOException, InterruptedException {
        MainPage mainPage = new MainPage();
        ContactPage contactPage = mainPage.contact();
        contactPage.searchDepart("南京测试部");
        contactPage.addMember("xujiayang44", "xuejiayang44", "13289702259");
    }

    @Test
    void clearAllDepartments() throws IOException, InterruptedException {
        MainPage mainPage = new MainPage();
        ContactPage contactPage = mainPage.contact();
        contactPage.searchDepart("南京测试部");
        contactPage.clearAllDeparts();
    }
}
