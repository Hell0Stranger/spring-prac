package com.newlecture.web.service;

import com.newlecture.web.dao.CartDao;
import com.newlecture.web.dao.MenuDao;
import com.newlecture.web.entity.Cart;
import com.newlecture.web.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // 컨트롤러 어노테이션 
public class DefaultMenuService implements MenuService {
	
	@Autowired // Field DI (DI 외에 별도로 실행해야 하는 로직이 없는 경우, Field에 Autowired 를 한다.)
	private MenuDao dao; // MenuDao => 인터페이스
	@Autowired
	private CartDao cartDao;

	@Override
	public List<Menu> getList() {return getList(1);}

	@Override
	public List<Menu> getList(int page) {
		int size =6;
		int offset = (page-1)*size;
		return dao.getList(offset,size,null);
	}
	@Override
	public void addToCart(int username, int menuId, boolean ice, boolean large) {
		Cart cart = new Cart(username, menuId, ice, large);
		cartDao.add(cart);
	}

	@Override
	public int countOfMenuInCart(int memberId) {
		 return cartDao.count(memberId);
		}


	@Override
	public Menu get(int id) {
		return null;
	}

	public  List<Menu> getListByCategory (int categoryId) {
		int page =1;
		int size = 6;
		int offset = (page-1)*size;
		List<Menu> list = dao.getList(offset, size, categoryId);
		return list;
	}

	@Transactional (isolation = Isolation.READ_UNCOMMITTED)
	@Override
	public Menu getLastOneAfterAdding(String name,
									  String OriginalFilename,
									  int price){
		Menu menu = new Menu(name, price, originalFilename,1);
		dao.add(menu);
		Menu lastOne = dao.getLast();

		return  lastOne;
	}


//	public void testTS() {
//		Menu menu =  dao.get(3);
//		menu.setPrice(menu.getPrice()-500);
//		dao.update(menu);
//		menu.setPrice(menu.getPrice()-500);
//		dao.update(menu);
//
//		dao.deleteAll(null);
//	}



}
