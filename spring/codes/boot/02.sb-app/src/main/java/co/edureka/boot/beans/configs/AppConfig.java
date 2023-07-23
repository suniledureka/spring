package co.edureka.boot.beans.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edureka.boot.utils.PasswordEncoder;

@Configuration
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig :: Constructor");
	}

	//@Bean
	@Bean(name = {"security", "encryptor"})
	public PasswordEncoder getEncoder() {
		return new PasswordEncoder();
	}
}
