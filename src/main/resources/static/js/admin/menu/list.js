window.addEventListener("load", function () {
	const btnAdd = document.querySelector(".btn-add");
	const menuRegSection =document.querySelector(".menu-reg-section");
	const imgInput = document.querySelector(".img-input");
	const fileInput = document.querySelector(".file-input");

	btnAdd.onclick = function(e) {
		e.preventDefault();
		console.log("test");
		menuRegSection.classList.remove("d-none");
	}
	//클릭을 전이하는 것 = 트리거

	imgInput.onclick = function (e) {
		// fileInput.dispatchEvent(e.target())
		let event = new MouseEvent("click" , {
			'view' : window,
			'bubbles' : true,
			'cancelable' : true

		});
		fileInput.dispatchEvent(event);
	}

	fileInput.oninput = function (e) {
		console.log("test"); // file을 선택해서 file의 정보만 얻은 것
		//1. 그 정보를 가지고 로컬에서 파일을 읽어와야함 (바이너리 리딩 , -> 리더 활용)
		//
		let url = fileInput.files[0];
		let reader = new FileReader();
		//-----지역화 하지 않기위해 -------
		reader.onload = (evt) => {
			imgInput.src = evt.target.result; //읽고자하는 이미지의  바이너리 (비트맵)
		}

		reader.readAsDataURL(url);
		// reader는 비동기처리 , 이벤트 개념
	}

})