package com.customer.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * ログイン機能を設定するクラスです あとで追加する機能：admin権限付与、パスワードをテーブルから拾ってくる
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().mvcMatchers("/login").permitAll() // ログイン画面は誰にでも入れるよ
        .mvcMatchers("/admin/**").hasRole("ADMIN") // adminしか閲覧できない、が実装は後回し
        .anyRequest().authenticated().and() // 呪文
        .formLogin().loginPage("/login") // ログインページはコントローラを経由しないのでViewNameとの紐付けが必要
        .usernameParameter("username") // リクエストパラメータのname属性を明示
        .passwordParameter("password") // リクエストパラメータのpassword属性を明示※下で設定可
        .defaultSuccessUrl("/customer") // ログイン成功時のurl
        .failureUrl("/login-error").permitAll().and() // ログイン失敗時のurl
        .logout().logoutUrl("/logout") // ログアウト用のurl
        .logoutSuccessUrl("/login") // ログアウト成功時のurl
        .deleteCookies("JSESSIONID") // ログアウト時に削除するクッキー名
        .invalidateHttpSession(true).permitAll();// ログアウト時のセッション破棄を有効化
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    auth.inMemoryAuthentication()

        // ユーザ名'admin', パスワード'1234',ロール'ADMIN'のユーザを追加
        .withUser("admin").password(passwordEncoder.encode("1234")).roles("ADMIN");

  }

}
