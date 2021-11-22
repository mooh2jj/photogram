package com.cos.photogramstart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// super 삭제 - 기존 시큐리티가 가지고 있는 기능이 다 비활성화됨.
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**").authenticated()	// 이 주소들은 인증이 필요함. 302code 가 뜸. 
			.anyRequest().permitAll()	// 그외 주소는 허용됨.
			.and()
			.formLogin()				// 인증이 필요한 주소는 이쪽 loginPage로 가라
			.loginPage("/auth/signin")
			.defaultSuccessUrl("/");
	}
}
