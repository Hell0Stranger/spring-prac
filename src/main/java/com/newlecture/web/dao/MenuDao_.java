package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newlecture.web.entity.Menu;

@Mapper // 인터페이스에 붙여주는 어노테이션
public interface MenuDao_ {
	// 쿼리문과 구현할 함수를 매핑하는 것(매핑툴) = mybatis
	// Mybatis는 쿼리를 직접 작성해야 하지만, JPA 는 쿼리를 직접 작성할 필요가 없다.
	@Select("select * from Menu where name like '%${title}%'") // select * from Menu where name like 'hello'
//	@Select("select * from Menu where name like #{title}") // select * from Menu where name like 'hello'
//	@Select("select * from Menu where name like ${title}") // select * from Menu where name like hello
	List<Menu> getList(String title); 	// SELECT문을 처리하는 메서드
	Menu get(); 			// SELECT
	int count(); 			// 검색결과를 집계(카운트)하는 함수 (SELECT)
	
	int insert(); // 성공, 실패에 대한 결과값을 Service 에 알려주기 위한 메서드.
	int update(); // 성공, 실패에 대한 결과값을 Service 에 알려주기 위한 메서드.
	int delete();
}

// #{title} 기본 - 값이 문자열이라서 '' 이 필요한 경우 
// ${title} - 값을 '' 없이 문자열 그대로 뽑고싶을 때 