package br.com.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info =
  @Info(title = "Cambium Service", version = "v1", description = "Documentation of cambium service API")
)

public class OpenApiConfiguration {

  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI()
      .components(new Components())
      .info(new io.swagger.v3.oas.models.info.Info()
              .title("Book Service API")
              .version("v1")
              .license(new License()
                         .name("Distributed Service")
                         .url("http://springdoc.org")
              )
      );
  }
}
