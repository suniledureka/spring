package co.edureka.boot.security.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicSecurityConfiguration {
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		System.out.println("---- inside filterChain(HttpSecurity) ----");
		/*
		//--- default configuration
		httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		httpSecurity.httpBasic(Customizer.withDefaults());
		return httpSecurity.build();
		*/
		
		httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		httpSecurity.csrf(csrf -> csrf.disable());
		httpSecurity.httpBasic(Customizer.withDefaults());
		return httpSecurity.build();
	}
	
	@Bean
	public UserDetailsService userDetails() {
		System.out.println("---- inside userDetails ----");
		var admin = User.withUsername("admin")
						//.password("{noop}12345")
						.password(pwdEncoder.encode("12345"))
						.roles("ADMIN") //ROLE_ADMIN
						.build();
		
		var manager = User.withUsername("sanjay")
						//.password("{noop}12345")
						.password(pwdEncoder.encode("12345"))
						.roles("MANAGER")
						.build();

		var user = User.withUsername("sunil")
					   //.password("{noop}12345")
						.password(pwdEncoder.encode("12345"))
					    .roles("USER")
					    .build();
		
		UserDetailsService users =  new InMemoryUserDetailsManager(admin, manager, user);
		return users;
	}
}
