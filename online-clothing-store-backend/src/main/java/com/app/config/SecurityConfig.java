package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// Configure authentication manager
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// In-memory authentication with users and roles
		auth.inMemoryAuthentication().withUser("Ankush").password(passwordEncoder().encode("A123")).roles("CUSTOMER")
				.and().withUser("Ashutosh").password(passwordEncoder().encode("A456")).roles("ADMIN", "CUSTOMER");
	}

	// Configure HTTP security settings
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Define access rules for URLs and roles
		http.authorizeRequests().antMatchers("/home").permitAll() // Allow access to "/home" for everyone
				.antMatchers("/customers/**").hasAnyRole("CUSTOMER", "ADMIN") // Allow access to "/customers/**" for
																				// CUSTOMER and ADMIN roles
				.antMatchers("/admin").hasRole("ADMIN") // Allow access to "/admin" only for ADMIN role
				.and().formLogin() // Enable form-based login
				.and().httpBasic(); // Enable Basic Authentication
	}

	// Bean for creating a password encoder
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // Use BCryptPasswordEncoder for password encoding
	}

}
