package com.hospital_vm_cl.hospital_vm.Config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
            .info(new Info()
                .title("Api 2026 Hospital Vm")
                .version("1.0")
                .description("Documentacion de la Api para el sistema del hospital vm"));
    }
}
