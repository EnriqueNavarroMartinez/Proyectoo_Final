package com.example.simarropopaccesoadatos.utils;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SimarropopConfig {
        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI()
                    .components(new Components())
                    .info(new Info().title("SimarroPop")
                            .description("API Simarropop del grupo E")
                            .contact(new Contact()
                                    .name("Enrique, Pablo, Arman y Marc")
                                    .email("alumnosGrupoE@edu.gva.es")
                                    .url("https://ieslluissimarro.org/"))
                            .version("1.0"));
        }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
