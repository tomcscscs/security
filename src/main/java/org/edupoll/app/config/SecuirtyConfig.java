package org.edupoll.app.config;

import java.util.List;

import javax.sql.DataSource;

import org.edupoll.app.common.CustomUserDetailsService;
import org.edupoll.app.repository.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecuirtyConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 0. csrf turn on / off configuration
		// http.csrf(t -> t.disable());

		// 1. restricting access configuration
		http.authorizeHttpRequests(t -> 
			t.requestMatchers("/", "/index").permitAll()
				.requestMatchers("/register").permitAll()
				.anyRequest().authenticated());
		http.anonymous(t -> t.disable());
		// 2 .custom login form configuration
		http.formLogin(t -> t.loginPage("/login").permitAll());
//		http.formLogin(t -> t.loginPage("/login").permitAll().usernameParameter("id").passwordParameter("pass"));
//		http.formLogin(t -> t.loginPage("/login").loginProcessingUrl("/login/proceed").permitAll());
//		 http.formLogin(Customizer.withDefaults());
		// http.logout(t-> t.);
		return http.build();
	}

	@Bean
	public UserDetailsService jpaUsers(AccountRepository accountRepository) {
		return new CustomUserDetailsService(accountRepository);
	}
	
	
	// 3. password storage configuration
	public UserDetailsService jdbcUsers(DataSource dataSorurce) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSorurce);
		
		return jdbcUserDetailsManager;
	}

	public UserDetailsService inMemeoryUsers() {
		UserDetails one = User.builder().username("te0506").password("{noop}1q2w3e4r").roles("TEACHER").build();
		UserDetails another = User.builder().username("totoro")
				.password("{bcrypt}$2a$12$0ICRxAnQ2uGdSUBSNCZ8b./IF5kXJ3s3hWPrT9ycPloAbdrewES8C").roles("STUDENT")
				.build();

		UserDetails other = User.builder().username("master")
				.password("{noop}$2a$12$0ICRxAnQ2uGdSUBSNCZ8b./IF5kXJ3s3hWPrT9ycPloAbdrewES8C")
				.roles("TEACHER", "STUDENT").build();
		List<UserDetails> users = List.of(one, another, other);
		// return new InMemoryUserDetailsManager(one, another, other);
		return new InMemoryUserDetailsManager(users);
	}

	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://database-free.cmdtqgkgbzj1.ap-northeast-2.rds.amazonaws.com:3306/tutorial");
		dataSource.setUsername("admin");
		dataSource.setPassword("1q2w3e4r");
		return dataSource;
	}
}
