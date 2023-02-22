package ua.dehtiar.hillel.javapro_hm_25_springdata.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yaroslav Dehtiar on 10.02.2023
 */
@Configuration
public class AppConfiguration {

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

}
