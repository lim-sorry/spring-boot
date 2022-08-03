package com.rubypaper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rubypaper.jdbc.util.JDBCConnectionManager;

@Configuration
public class BoardConfiguration {
	
	public BoardConfiguration() {
		System.out.println("===> Chapter02 BoardConfiguration 생성");
	}
	
	// BoardAutoConfiguration 생성해주는 JDBCConnectionManager 덮어쓰기한다.
//	@Bean
//	JDBCConnectionManager connectionManger() {
//		JDBCConnectionManager manager = new JDBCConnectionManager();
//		manager.setDriverClass("org.h2.Driver");
//		manager.setUrl("jdbc:h2:tcp://localhost/~/test");
//		manager.setUsername("sa");
//		manager.setPassword("");
//		return manager;
//	}
}
