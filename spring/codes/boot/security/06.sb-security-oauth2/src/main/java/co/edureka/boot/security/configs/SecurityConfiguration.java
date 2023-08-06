package co.edureka.boot.security.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
 @Bean
 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
   http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
   http.oauth2Login(Customizer.withDefaults()); //http.oauth2Login()
   return http.build();
 }
}
