package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.Menu;

// 인터페이스
public interface MenuService { 
	List<Menu> getList();
	int addToBasket(int id);
	void testTS();
}
