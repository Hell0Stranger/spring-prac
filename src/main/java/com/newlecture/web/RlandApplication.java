package com.newlecture.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RlandApplication {
	public static void main(String[] args) {
		SpringApplication.run(RlandApplication.class, args); // 톰캣을 실행하는 코드 => 기존에는 톰캣이 나를 실행했다면 부트는 톰캣을 실행시킴. (주객전도)
	}

}


// JSP = 자바 서버 페이지
// 제스퍼 = 출력페이지를 변환해주는 엔진
//  
// 타임리프 = 서버사이드 렌더링을 담당하고 있는 템플릿 엔진 = html 한정