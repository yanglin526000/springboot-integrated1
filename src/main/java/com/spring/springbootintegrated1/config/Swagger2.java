package com.spring.springbootintegrated1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * <p>
 * 描述: Swagger2配置文件
 * </p>
 * <p>
 * 创建时间: 2019-11-15 09:50
 * </p>
 * 
 * @author yanglin
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Value("${swagger.enable:true}")
    private Boolean enable;

    /**
     * <p>
     * 描述: Docket
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:53
     * </p>
     * 
     * @return Docket
     * 
     * @author yanglin
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).enable(enable).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
                .build().securitySchemes(securitySchemes()).securityContexts(securityContexts());
    }

    /**
     * <p>
     * 描述: Swagger2主信息
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:53
     * </p>
     * 
     * @return ApiInfo
     * 
     * @author yanglin
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("wonders-pathology-server").description("springboot利用swagger构建api文档")
                .termsOfServiceUrl("").version("1.0").build();
    }

    /**
     * <p>
     * 描述: 配置了哪些操作与SecuritySchemes相关联的配置
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:53
     * </p>
     * 
     * @return List<ApiKey>
     * 
     * @author yanglin
     */
    private List<ApiKey> securitySchemes() {
        return newArrayList(new ApiKey("token", "token", "header"));
    }

    /**
     * <p>
     * 描述: 配置api操作（通过正则表达式模式）和HTTP方法将安全上下文应用于apis
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:54
     * </p>
     * 
     * @return List<SecurityContext>
     * 
     * @author yanglin
     */
    private List<SecurityContext> securityContexts() {
        return newArrayList(SecurityContext.builder().securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$")).build());
    }

    /**
     * <p>
     * 描述: List<SecurityReference>
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:54
     * </p>
     * 
     * @return List<SecurityReference>
     * 
     * @author yanglin
     */
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(new SecurityReference("token", authorizationScopes));
    }
}
