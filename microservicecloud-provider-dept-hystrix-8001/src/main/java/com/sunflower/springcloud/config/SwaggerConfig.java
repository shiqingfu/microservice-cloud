package com.sunflower.springcloud.config;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @author: ShiQingFu
 * @description:  swagger配置类
 * @date: 2019/1/12 22:12
 */
@Configuration
@EnableSwagger2
//@Profile({"dev", "test"})
@ConfigurationProperties(prefix = "swagger")
@Data
public class SwaggerConfig {

    private String basePackage;
    private String title;
    private String description;
    private String serviceUrl;
    private String contactName;
    private String contactUrl;
    private String contactEmail;
    private String version;


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(this.basePackage))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    /**
     * 该API的基本信息（展现在文档页面中）
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(this.title)
                .description(this.description)
                .termsOfServiceUrl(this.serviceUrl)
                .contact(new Contact(this.contactName, this.contactUrl, this.contactEmail))
                .version(this.version)
                .build();
    }

    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeyList = Lists.newArrayList();
        apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
        return apiKeyList;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = Lists.newArrayList();;
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build());
        return securityContexts;
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = Lists.newArrayList();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }
}
