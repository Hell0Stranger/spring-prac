package com.newlecture.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired // Field DI (DI 외에 별도로 실행해야 하는 로직이 없는 경우, Field에 Autowired 를 한다.)
	private MenuService service;
	
	public MenuController() {

	}
	
	public MenuController(MenuService service) {
//		super();
		this.service = service;
	}

	@Autowired
	public void setService(MenuService service) {
		this.service = service;
	}

	@GetMapping("list")
	public String list() {
		return "menu/list";
	}
	
	@GetMapping("detail")
	public String detail() {
		return "menu/detail";
	}
//	public String list(Model model) { // front Controller 에게 Model 객체를 달라고 요청하는 것
//		service.testTS();
//		model.addAttribute("data", "hello"); // front Controller 에게 값을 넘겨준 것
//		service.getList();
//		System.out.print("호정아 안녕");
//		return "menu/list";
//	}
}
