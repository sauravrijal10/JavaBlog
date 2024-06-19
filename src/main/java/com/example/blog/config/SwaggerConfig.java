package com.example.blog.config;


// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spring.web.plugins.Docket;
// import springfox.documentation.swagger2.annotations.EnableSwagger2;

// @Configuration
// @EnableSwagger2
// public class SwaggerConfig{
//     @Bean
//     public Docket api(){
//         return new Docket(DocumentationType.SWAGGER_2)
//             .select()
//             .apis(RequestHandlerSelectors.basePackage("com.example.blog.controller"))
//             .paths(PathSelectors.any())
//             .build();

//     }
// }

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Blog API")
                        .description("Blog application API")
                        .version("v1.0"));
    }
}