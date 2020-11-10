package com.customer;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class CustomermanagementApplication {
	
	//Springbootを起動するメソッド
	
	public static void main(String[] args) {
		SpringApplication.run(CustomermanagementApplication.class, args);
	}
	
	//DBとの接続設定
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setConfigLocation(new ClassPathResource("/mybatis-config.xml"));
		return sessionFactory.getObject();
	
	}

}
