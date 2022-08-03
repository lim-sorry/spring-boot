package com.rubypaper;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import com.rubypaper.controller.BoardController;

@SpringBootTest(classes = BoardController.class,
		        properties = {"author.name=Gurum", 
		                      "author.age=28", 
		                      "author.nation=Korea"})
public class PropertiesTest {
	
//	@Value("${author.name}")
//	private String name;
//	
//	@Value("${author.age}")
//	private int age;
	
	@Autowired
	private Environment env;
	
	@Test
	public void testMethod() {
		// 테스트 코드를 작성한다.
		System.out.println("이름 : " + env.getProperty("author.name"));
		System.out.println("나이 : " + env.getProperty("author.age"));
		System.out.println("국적 : " + env.getProperty("author.nation"));
	}
}











