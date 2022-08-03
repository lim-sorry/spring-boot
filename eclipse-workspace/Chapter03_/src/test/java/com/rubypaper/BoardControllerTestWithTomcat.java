package com.rubypaper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.rubypaper.domain.Board;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BoardControllerTestWithTomcat {
	
	@Autowired
	// TestRestTemplate은 REST API를 테스트하기 위한 가상의 브라우저 객체다.
	private TestRestTemplate restTemplate;
	
	@Test
	public void testHello() throws Exception {
		String result = restTemplate.getForObject("/hello?name=gurum", String.class);
		assertEquals("hello : gurum", result);
	}
	
	@Test
	public void testGetBoard() throws Exception {
		Board result = restTemplate.getForObject("/getBoard/1", Board.class);
		assertNotNull(result);
		assertEquals("테스터", result.getWriter());
	}
	
	@Test
	public void testGetBoardList() throws Exception {
		List<Board> result = restTemplate.getForObject("/getBoardList", List.class);
		assertEquals(2, result.size());
	}
}










