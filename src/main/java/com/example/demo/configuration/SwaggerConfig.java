package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;


/**
 * Created by neowiztomato on 2017-09-07.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket restApi() {
        // @formatter:off
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,
                        Arrays.asList(
                                new ResponseMessageBuilder()
                                        .code(500)
                                        .message("server error")
                                        .responseModel(
                                                new ModelRef("Error")
                                        ).build()
                        )
                );
        // @formatter:on
    }

    private ApiInfo apiInfo() {
        // @formatter:off
        return new ApiInfoBuilder()
                .title("Spring boot Swagger")
                .description("api list")
                .contact(new Contact("wonwoo", "wonwoo.ml", "test@test.com"))
                .version("1.0.0")
                .build();
        // @formatter:on
    }

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
////                .apis(RequestHandlerSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
//                .paths(PathSelectors.any())
//                .build();
//    }

//    private ApiInfo getApiInfo() {
//
//        String title = "PmangAd Sampme Microservice API Documentation";
//        String desc = "";
//        String version = "1.0.0";
//        String termsOfServiceUrl = "http://www.neowizplaystudio.co.kr";
//        String license = "Neowiz Play Studio";
//        String licenseUrl = "http://www.neowizplaystudio.co.kr";
//        Contact contact = new Contact("PmangAd Developers", "http://www.neowizplaystudio.co.kr", "nw_003803_153@neowiz.com");
//        ApiInfo apiInfo = new ApiInfo(title, desc, version, termsOfServiceUrl, contact, license, licenseUrl);
//
//        return apiInfo;
//    }
//
//    @Bean
//    public UiConfiguration uiConfig() {
//        return new UiConfiguration(null);
//    }
//
//    @Bean
//    public Docket allDocket() {
//        List<ResponseMessage> responseMessage = Arrays.asList(
//                new ResponseMessageBuilder()
//                        .code(200)
//                        .message("The reqeuest was successful.")
//                        .build()
//        );
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
////                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .useDefaultResponseMessages(false)
//                .groupName("ALL")
//                .globalResponseMessage(RequestMethod.POST, responseMessage)
//                .globalOperationParameters(
//                        Arrays.asList(
//                                new ParameterBuilder()
//                                        .name("Authorization")
//                                        .description("Bearer authentication. testToken or testToken:{mediaId}:{udid} is allowed in non-production environment.")
//                                        .modelRef(new ModelRef("string"))
//                                        .parameterType("header")
//                                        .defaultValue("Bearer testToken")
//                                        .required(true)
//                                        .build()
//                        )
//                )
//                .apiInfo(getApiInfo()).directModelSubstitute(ZonedDateTime.class, Long.class); // ZonedDateTime을 Long 타입으로 노출되도록 한다;
//    }

}
