package com.atletasbr.olimpiadas.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(info = @Info(title = "API dos Jogos Olímpicos de Paris",
                                description = "API responsável por fornecer informações de cada atleta registrado " +
                                              "na base de dados assim como sua participação nos Jogos Olímpicos",
                                version = "1.0.1"),
                   servers = { @Server(url = "/", description = "Default Server URL")})
public class OpenApiConfig {
}
