package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;//자동주입. 생성자의존성주입
	
	//목록
	@GetMapping("/list")
	public void list(Model model) {
		//request.setAttribute("list", service.getList()); 와 같은 역할
		// 리턴값이 void이면 url 주소와 같은 이름인 list.jsp로 포워딩
		model.addAttribute("list", service.getList()); // "list"는 attribute명
	}
	//등록화면으로 이동
	@GetMapping("/register")
	public void register() {

	}
	
	
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
		
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno")Long bno,Model model) {
		model.addAttribute("board", service.get(bno));
	}
	
	
}
