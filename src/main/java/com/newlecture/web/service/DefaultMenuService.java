package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.newlecture.web.dao.MenuDao;
import com.newlecture.web.entity.Menu;

@Service // 컨트롤러 어노테이션 
public class DefaultMenuService implements MenuService {
	
	@Autowired // Field DI (DI 외에 별도로 실행해야 하는 로직이 없는 경우, Field에 Autowired 를 한다.)
	private MenuDao menuDao; // MenuDao => 인터페이스
	
	public DefaultMenuService() {
	
	}
	
	//@Autowired // Constructor DI
	public DefaultMenuService(MenuDao menuDao) { // constructor injection
		this.menuDao = menuDao;
	}
	
	//@Autowired // repository(DB 저장소)에 service 객체를 주입한다. (setter injection)
	public void setMenuDao(MenuDao menuDao) { // setter injection
		this.menuDao = menuDao;
	}

	@Override
	public List<Menu> getList() {
//		String sql = "SELECT * FROM Menu";
//		JdbcTemplate template = new JdbcTemplate();
		
//		template.query(sql, null); 	// select
//		template.update(null); 		// update, delete
		
		List<Menu> list = menuDao.getList(0, 10, null, null);
		System.out.println(list);
		
		return list;
	}

	@Override
	public int addToBasket(int id) {
		return 0;
	}
	
	@Transactional (isolation = Isolation.READ_UNCOMMITTED)
	@Override
	public void testTS() {
		Menu menu =  menuDao.get(3);
		menu.setPrice(menu.getPrice()-500);
		menuDao.update(menu);
		menu.setPrice(menu.getPrice()-500);
		menuDao.update(menu);
		
		menuDao.deleteAll(null);
	}
	
}
