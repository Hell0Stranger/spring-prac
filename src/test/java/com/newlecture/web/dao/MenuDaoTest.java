package com.newlecture.web.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@AutoConfigureTestDatabase(replace=Replace.NONE)
@MybatisTest // 기본적으로 스프링이 갖고 있는 기능ㅇ이 아님. 
class MenuDaoTest { // getList를 테스트하기 위한 메인 함수

	@Autowired
	private MenuDao menuDao;
	
	@Test
	void testGetList() { // getLIst와 관련된 함수들을 테스트 해보는 곳
		System.out.println(menuDao);
		int offset = 0;
		int size = 10;
		System.out.println(menuDao.getList(offset, size, null, null));		
//		fail("Not yet implemented"); 실패 매크로
	}

}

// 실행결과null = 참조가 안됐다. Autowired가 안됐다.
// 마이바티스가 컨테이너에 담아놨던 매퍼 객체