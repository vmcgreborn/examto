package com.app.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
   
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.app.controller"))
                .paths(PathSelectors.any())
                .build()

                ;
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Transactio Service API",
                "Transaction Service API Description",
                "1.0",
                "http://codmind.com/terms",
                new Contact("Codmind", "http://MyPage.com", "vmcgreborn@gmail.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }

     

}
