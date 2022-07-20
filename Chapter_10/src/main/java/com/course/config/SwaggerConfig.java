package com.course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Author yangfan
 * @Date 2021/12/14 16:52
 */

@Configuration
//这个是专门加载配置文件的
@EnableSwagger2
public class SwaggerConfig {
    //里面基本是固定写法

    //访问的路径：localhost:8888/swagger-ui.html

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("杨凡的接口文档")
                .contact(new Contact("杨凡","","291057964@qq.com"))
                .description("这是杨凡的swaggerui生成的接口文档")
                .version("1.0.0.1")
                .build();

    }
}
