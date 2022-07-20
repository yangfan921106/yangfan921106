package com.yangf;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;


/**
 * @ClassName MockTestDemo
 * @Description TODO
 * @Author yangfan
 * @Date 2022/5/12 16:12
 */
public class MockTestDemo {
    static WireMockServer wireMockServer;

    @BeforeAll
    public static void initData(){
         wireMockServer = new WireMockServer(wireMockConfig().port(8089));
         wireMockServer.start();
         configureFor("localhost", 8089);
    }

    @Test
    public void stubMock(){
        try {
        stubFor(post("/my/resource")
                .withHeader("Content-Type", containing("xml"))
                .willReturn(ok()
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>SUCCESS</response>")));


            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
