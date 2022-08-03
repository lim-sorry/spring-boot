package com.rubypaper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

// @WebMvcTest는 서블릿 컨테이너(Tomcat 서버)를 모킹(Mocking)한다.
@WebMvcTest // @Controller, @RestController가 붙은 객체들만 메모리에 생성한다.
public class BoardControllerTest {
	
	// @WebMvcTest가 목킹한 서블릿 컨테이너를 목업(MockUp)한다. 
	@Autowired
	private MockMvc mockMvc; // MockMvc가 가짜 서블릿 컨테이너다.
	
	@Test
	public void testHello() throws Exception {
		// http://localhost:8080/hello?name=gurum으로 요청하듯
		mockMvc.perform(get("/hello").param("name", "gurum"))
		
		// 응답 상태코드(Status-Code)가 200인지 확인
		.andExpect(status().is(200))
		// 응답 결과값이 "hello : gurum"인지 확인
		.andExpect(content().string("hello : gurum"))
		.andDo(print());
	}
}










