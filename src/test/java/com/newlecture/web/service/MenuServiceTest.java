package com.newlecture.web.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MenuServiceTest {

	@Autowired
	// Autowired를 위해서는 클래스 
	private MenuService service;
	
	@Test
	void testGetList() {
//		fail("Not yet implemented");
		System.out.println(service.getList());
	}

}
