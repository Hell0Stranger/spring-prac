import DeleteDlg from "./delete-dlg.js";

console.log("test");
 
window.addEventListener("load", function(event){

	var	menuList = document.querySelector(".menu-list");
	
//	menuList.onclick = function(e){
//		if(!e.target.classList.contains("btn-remove"))
//			return;
//			
//		e.preventDefault();
//		var request = new window.XMLHttpRequest();	
//
//		request.onreadystatechange = function() { 
//			
//			if(request.readyState < 4)	// 4보다 작은 상태에는(요청이 다 왔을때가 아니면)
//				return;
//			
//			
//			// console.log(request.responseText);
//			var response = JSON.parse(request.responseText);	// Object로 파싱
//			if(response.result == 1) {
//				var el = e.target.parentElement;
//				// classList에 menu-list-element가 포함되어 있지 않다면 부모요소로 올라가기
//				for(; !el.classList.contains("menu-list-element"); el = el.parentElement);
//				el.remove();	// classList에 menu-list-element가 포함되어 있다면 해당 메뉴 삭제
//			}
//				/*e.target
//				.parentElement
//				.parentElement
//				.parentElement
//				.remove();*/
//				
//		};
//		request.open("DELETE", "/api/menus/132");	// 데이터 요청
//		request.send();	// 데이터 보내기
//
//		 console.log(request.responseText);
//	}
	
	var menuListEl = menuList.querySelectorAll(".menu-list-element");
	var removeBtn = null;
	var form = null;
	
	for(var i=0; i<menuListEl.length; i++) {
		removeBtn = menuListEl[i].querySelector(".btn-remove");
		form = menuListEl[i].querySelector("form");
	
	
	// 삭제 버튼 클릭시 모달 창  띄우기
	removeBtn.onclick = function(e) {

		if(!e.target.classList.contains("btn-remove"))
			return;
			
		e.preventDefault();
		
	
		
		var link = "";
		if(form.hasChildNodes()) {
			var children = form.childNodes;
			
			for(var i=0; i<children.length; i++) {
	//			console.log("자식노드:" + children[i].nodeName + "<br />");
				if(children[i].nodeName == "A") 
					link = children[i].href;
					
			}
		
		}
		
		var lastIndex = link.indexOf("=");
		
		console.log(lastIndex);
		var id = link.substring(lastIndex+1);
//		var id_ = parseInt(id);
		
		var request = new window.XMLHttpRequest();	
		var type = "DELETE";
		var url = "/api/menus/" + id;

		var del = new DeleteDlg("삭제하시겠습니까?", "네", "아니요", "", "");
		del.open();
		
		


		request.onreadystatechange = function() { 
			
			if(request.readyState < 4)	// 4보다 작은 상태에는(요청이 다 왔을때가 아니면)
				return;
			
		
				var response = JSON.parse(request.responseText);	// Object로 파싱
				
				if(response.result == 1) {
					var el = e.target.parentElement;
					// classList에 menu-list-element가 포함되어 있지 않다면 부모요소로 올라가기
					for(; !el.classList.contains("menu-list-element"); el = el.parentElement);
					el.remove();	// classList에 menu-list-element가 포함되어 있다면 해당 메뉴 삭제
				}
					
		};
		
		del.onconfirm = function() {
			request.open(type, url);	// 데이터 요청
			request.send();	// 데이터 보내기
		}	

	 }
	}
});




/*window.addEventListener("load", function(event) {
	
	var menuList = document.querySelector(".menu-list");
	
	menuList.onclick = function(e) {
		e.preventDefault();
		if(!e.target.classList.contains("btn-remove"))
			return;
			
		// 원격에 있는 문서를만드는 도구
		var request = new XMLHttpRequest();
		request.onreadystatechange = function(e) {	// on: 이벤트 위임 속성 / 비동기방식을 사용하기 위한 함수
		// 상태가 바뀔때마다 매번 호출되는 이벤트이기 때문에 조건문으로 처리 
			
			if(request.readyState < 4)	// 4보다 작은 상태에는(요청이 다 왔을때가 아니면) return(아래 로직 막기)
				return;
						
			console.log(request.responseText);
		};
		request.open("DELETE", "/api/menu");	// 데이터 요청(주소창에 주소 보냄) false: 비동기가 아님(동기) default = true(비동기)
		request.send();	// 데이터 보내기(동기 - 기다렸다가 순차적으로 실행) / 
		
	};
	
});*/