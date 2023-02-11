package sia.tacocloud.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class IntegrationConfig {

    /*
    * This is just a bean for a RestTemplate future use*/
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
