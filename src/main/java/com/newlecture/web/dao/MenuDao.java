package com.newlecture.web.dao;

import com.newlecture.web.entity.Cart;
import com.newlecture.web.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper // 인터페이스에 붙여주는 어노테이션
public interface MenuDao {
//	List<Menu> getList(
//			int offset,
//			int size,
//			String field,
//			String query); 	// SELECT문을 처리하는 메서드
	void add(Cart cart);
	List<Menu> getList(int offset, int size, Integer categoryId);
	Menu get(int id);
	// SELECT
	int count(String query); 		// 검색결과를 집계(카운트)하는 함수 (SELECT)
	
	// 성공, 실패에 대한 결과값을 Service 에 알려주기 위한 메서드.
	int insert(Menu menu); 
	int update(Menu menu);
	int updateAll(Menu []menus);
	int delete(int id);
	@Transactional(propagation =Propagation.SUPPORTS)
	int deleteAll (int[] ids);


//    Menu getLast();
}


