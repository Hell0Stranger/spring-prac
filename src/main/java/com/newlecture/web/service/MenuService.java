package com.newlecture.web.service;

import com.newlecture.web.entity.Menu;

import java.util.List;

// 인터페이스
public interface MenuService { 
	List<Menu> getList();
	List<Menu> getList(int page);

	List<Menu> getListByCategory(int category);


	void testTS();

	void addToCart(int username, int menuId, boolean ice, boolean large);

	int countOfMenuInCart(int memberId);

	Menu get(int id);

    void add(String title, String originalFilename, int price);


}
