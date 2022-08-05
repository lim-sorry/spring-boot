	package com.rubypaper.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.rubypaper.domain.Board;
import com.rubypaper.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 글 등록 화면 이동
	@GetMapping("/insertBoard")
	public String insertBoard() {
		// /WEB-INF/board/insertBoard.jsp 화면으로 이동한다.
		return "insertBoard";
	}
	
	// 글 등록 기능 처리
	@PostMapping("/insertBoard")
	public String insertBoard(Board board, @RequestBody MultipartFile uploadFile) throws Exception {
		// 파일 업로드 처리
		// 클라이언트가 업로드한 파일의 이름을 얻어낸다.
		String fileName = uploadFile.getOriginalFilename();
		// 서버의 특정 디렉토리에 파일을 출력한다.
		uploadFile.transferTo(new File("C:/DEV/" + fileName));
		
		// 글 등록을 요청한다.
		boardService.insertBoard(board);
		// 글 등록 성공 후, 목록 화면으로 이동한다. 
		return "forward:getBoardList";
	}
	
	// 글 수정 기능 처리
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	// 글 삭제 기능 처리
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	
	// 글 상세 조회
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	
	// 글 목록 검색
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model) {
		List<Board> list = boardService.getBoardList();
		System.out.println(list.toString());
		// 검색 결과를 Model에 등록한다. 
		model.addAttribute("boardList", list);
		// JSP 파일 이름을 리턴한다. 
		return "getBoardList";
	}
}






















