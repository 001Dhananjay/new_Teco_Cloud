package com.in.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		/*
		 * http .authorizeHttpRequests(auth -> auth.anyRequest().authenticated() )
		 * .httpBasic(withDefaults());
		 * 
		 * return http.build();
		 */   
    	
    	return http
    		    .authorizeRequests()
    		      .requestMatchers("/design", "/orders").hasRole("ADMIN")
    		      .requestMatchers("/", "/**").permitAll()
    		 
    		    .and().formLogin().and()
    		    .build();
    
    }

    
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		/*
		 * manager.createUser( User.withUsername("john") .password("john")
		 * .roles("NORMAL") // for testing .build() ); manager.createUser(
		 * User.withUsername("Dhananjay") .password("Dhananjay") // for testing
		 * .roles("ADMIN") .build() );
		 */       
        
        manager.createUser(User.withUsername("john").password(this.passwordEncoder().encode("john")).roles("NORMAL").build());
        manager.createUser(User.withUsername("Dhananjay").password(this.passwordEncoder().encode("Dhananjay")).roles("ADMIN").build());
        
        
        
        return manager;
    }

    //  Use NoOpPasswordEncoder (only for testing)
    @Bean
    public PasswordEncoder passwordEncoder() {
        //return NoOpPasswordEncoder.getInstance();
    	return new BCryptPasswordEncoder(10);
    }
}
