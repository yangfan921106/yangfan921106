package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @ClassName MycookiesForGet
 * @Description TODO
 * @Author yangfan
 * @Date 2021/12/10 16:37
 */
public class MycookiesForGet {

    private String url;
    private ResourceBundle bundle ;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {

        //从配置文件中拼接测试的url
        String result;
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url+uri;

        //测试逻辑代码书写
        HttpGet get = new HttpGet(testUrl);
        HttpClient client = HttpClientBuilder.create().build();//获取DefaultHttpClient请求

        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);


        //获取cookies信息
      /*  CookieStore store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = "+name+"; value = " +value);
        }
*/

    }




}
