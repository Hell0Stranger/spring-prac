package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	// 어노테이션으로 매핑해주기
//	@RequestMapping("/hello")
//	public String hojung() {
//		// 라이브러리(스프링 mvc 라이브러리인 Dispatcher)가 있기 때문에 가능한 것
//		// 처음만드는 패키지의 경로 아래에 해당되는 범위 내에서 auto(자동)로 탐색을 해서 실행해준다.
//		return "Hello 스프링";
//	}
//	
//	@RequestMapping("/bye")
//	// 스프링에서는 한 클래스 안에서 여러개의 url을 매핑할 수 있다.
//	// 클래스는 여러개의 url을 담아놓을 수 있는 폴더 단위의 개념으로 생각하면 된다.
//	public String index() {
//		return "Welcome ~ ";
//	}
}
