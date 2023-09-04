package br.com.fiap.hotelestelar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class DocumentationConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("Hotel Estelar API")
                    .description("Uma API para o sistema de controle de reservas do Hotel Estelar.")
                    .summary("Essa api server para......")
                    .version("V1")
                    .contact(new Contact()
                        .name("Milena Vitoria e Jakeline Santana")
                        .email("rm94305@fiap.com.br e rm96201@fiap.com.br")
                    )
                    .license(new License()
                        .name("MIT Open Soucer")
                        .url("http://hotelestelar.com/licenca")
                    )
                )
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")
                                        .bearerFormat("JWT")));
    }

}
