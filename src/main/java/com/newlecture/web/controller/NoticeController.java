package com.newlecture.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//@RestController // 컨트롤러라고 말해주기 
@Controller		  // 출력되는 값이 문서(View)인 경우에는 @Controller 로 명시해주어야 한다. Controller 는 문서를 심어서 반환하는게 아닌, 실행되면 그 문서를 찾아서 반환한다.
				  // RestController는 값을 반환할 때 사용
@RequestMapping("/notice/")
public class NoticeController {
//	@GetMapping("list") // GET 방식으로 매핑한다.
//	public String NoticeList() {
//		return "공지목록";
//	}
	
//	@GetMapping("list") // GET 방식으로 매핑한다.
//	public List<String> NoticeList() { // Object 타입으로 반환하기.
//		List<String> list = new ArrayList<>();
//		list.add("Yang");
//		list.add("Ho");
//		list.add("Jung"); 
//		
//		return list; // 객체를 반환하면 제이슨 형태의 객체가 반환된다.
//	}
	
	@GetMapping("list") // GET 방식으로 매핑한다.
	@ResponseBody  		// View를 찾는 Controller 안에서 //
	public String list(Model model) { // 모델이라는 객체를 넘겨달라고(반환해달라고) 스프링mvc 에게 말하는 것.
		List<String> list = new ArrayList<>();
		list.add("Yang");
		list.add("Ho");
		list.add("Jung"); 
		
//		model.addAttribute("y", 13);
		
		return "notice/list"; // 반환값이 문서의 주소 가 되는 것.
	}
	
	@RequestMapping("detail")
	public String Noticedetail() {
		return "공지상세";
	}
}
