package com.customer.auth;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        	.antMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated().and()
            .formLogin()
            .loginPage("/login") //ログインページはコントローラを経由しないのでViewNameとの紐付けが必要
            .loginProcessingUrl("/sign_in") //フォームのSubmitURL、このURLへリクエストが送られると認証処理が実行される
            .usernameParameter("username") //リクエストパラメータのname属性を明示
            .passwordParameter("password")
            .successForwardUrl("/admin/customer")
            .failureUrl("/login-error").permitAll().and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login")
            .permitAll();
    }
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		auth.inMemoryAuthentication()
				// ユーザ名'user', パスワード'user',ロール'USER'のユーザを追加
				.withUser("user").password(passwordEncoder.encode("user")).roles("USER").and()
				// ユーザ名'admin', パスワード'admin',ロール'ADMIN'のユーザを追加
				.withUser("admin").password(passwordEncoder.encode("admin")).roles("ADMIN");

	}


}
