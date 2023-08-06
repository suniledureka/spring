package co.edureka.boot.security.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
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
		//httpSecurity.headers().frameOptions().sameOrigin();
		httpSecurity.headers(header -> header.frameOptions(frame -> frame.sameOrigin()));
		httpSecurity.httpBasic(Customizer.withDefaults());
		return httpSecurity.build();
	}
	
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabase ds = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
				.build();
		
		return ds;	
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
		
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource());
		users.createUser(admin);
		users.createUser(manager);
		users.createUser(user);
		
		return users;
	}
}
