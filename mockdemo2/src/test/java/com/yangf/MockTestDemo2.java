package com.yangf;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;


/**
 * @ClassName MockTestDemo
 * @Description TODO
 * @Author yangfan
 * @Date 2022/5/12 16:12
 */
public class MockTestDemo2 {
    static WireMockServer wireMockServer;

    @BeforeAll
    public static void initData() {
        wireMockServer = new WireMockServer(wireMockConfig().port(8091));
        wireMockServer.start();
        configureFor("localhost", 8091);
    }

    @Test
    //stub  每次都给一个固定的返回值
    public void stubMock() {
        try {
            stubFor(get(urlEqualTo("/some/thing"))
                    .withHeader("Accept", equalTo("text/xml"))
                    // 配置返回的body，header，statusCode
                    .willReturn(
                            aResponse()
                                    .withStatus(200)
                                    .withHeader("content-Type", "text/xml")
                                    .withBody("this is my first wiremock demo!")));

            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Test
    //reset之后会指向到另外一个返回值。
    public void easy_mock() {
        try {
            stubFor(get(urlEqualTo("/some/thing"))
                    .withHeader("Accept", equalTo("text/xml"))
                    // 配置返回的body，header，statusCode
                    .willReturn(
                            aResponse()
                                    .withStatus(200)
                                    .withHeader("content-Type", "text/xml")
                                    .withBody("this is my first wiremock demo!")));
            Thread.sleep(10000);


            reset();
            stubFor(get(urlEqualTo("/some/thing"))
                    .withHeader("Accept", equalTo("text/xml"))
                    // 配置返回的body，header，statusCode
                    .willReturn(
                            aResponse()
                                    .withStatus(200)
                                    .withHeader("content-Type", "text/xml")
                                    .withBody("AAAA!")));
            Thread.sleep(10000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    //重新指向到另外一个网址
    //将本地存的body内容返回
    public void proxyMockTest() {
        try {
            stubFor(get(urlMatching(".*")).atPriority(10)
                    .willReturn(aResponse().proxiedFrom("https://ceshiren.com")));

            stubFor(get(urlEqualTo("/categories_and_top")).atPriority(10).
                   willReturn(aResponse().
                           withBody(Files.readAllBytes(Paths.get("D://yangfan921106//mockdemo2//target//classes//mock.json")))));

            Thread.sleep(500000);
        } catch (Exception  e) {
            e.printStackTrace();
        }

    }


}
