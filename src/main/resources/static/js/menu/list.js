window.addEventListener("load", (e)=> {
    /* 지역화 사용할 필요가 없을 때 arrow function */

    const ul = document.querySelector(".menu-category ul");
    const menuBox= document.querySelector(".menu-list");
    let currentLi = document.querySelector(".menu-category ul li.menu-selected");
    const controller = new AbortController();

    ul.onclick = function (e) {
        e.preventDefault();
        const el = e.target;
        if(menuBox.classList.contains("ajax-loader")){
            if( confirm("기다려이자식아.. \n\r 요청 취소하려면 확인 누르덩가"))
            controller.abort();
            controller = new AbortController();
            return;
        }

        if (el.tagName!= "LI" && el.tagName != "A")
            return;

        let li = el;
        if(el.tagName =="A")
            li = el.parentElement;

            li.classList.add("menu-selected");
            currentLi.classList.remove("menu-selected");
            currentLi = li;

            // classList -> 여러 클래스를 가질 수 있도록 해주는 list 프레임워크

            // 데이터를 요청 ?C=2 → param:2
            // /api/menu/list?c=2
            // /api/menu/c/2
            // /api/menu/c/2
            // /api/menu/list/c/2

        // XMLHttpRequest vs. Fetch api
            let queryString =`?c=${currentLi.dataset.id}`;
            if(currentLi.dataset.id ==0)
                    queryString = "";

            //요청전 아이콘띄우기

        menuBox.classList.add("ajax-loader");

        const signal = controller.signal;

            fetch(`/api/menus${queryString}`,{ signal})
            .then((response)=>response.json())
                .then((list) => {
                    menuBox.innerHTML = "";
                    // th:each="menu:${list}"
                for(let m of list) {
                    let template =  `
                                        <section class="menu  hidden" >
                                        <form class="" action="list" method="post">
                                        <h1 >${m.name}</h1>
                                        <div class="menu-img-box">
                                        <a href="detail"><img class="menu-img" src="/image/product/12.png"></a>
                                        </div>
                                        <div class="menu-price" >${m.price} 원</div>
                                        <div class="menu-option-list">
                                        <span class="menu-option">
                                        <input class="menu-option-input" type="checkbox" name="ice" value="true">
                                        <label>ICED</label>
                                        </span>
                                        <span class="menu-option ml-2">
                                        <input class="menu-option-input" type="checkbox" name="large" value="true">
                                        <label>Large</label>
                                        </span>
                                        </div>
                                        <div class="menu-button-list">
                                        <input type="hidden" name="menu-id" >
                                        <input class="btn btn-cancel btn-cancel-lg btn-size-1 btn-size-1-lg" type="submit" name="cmd" value="담기">
                                        <input class="btn btn-default btn-default-lg btn-size-1 btn-size-1-lg ml-1" type="submit" name="cmd" value="주문하기">
                                        </div>
                                        </form>
                                        </section>
                                    `;

                                // menuBox.insertAdjacentHTML('beforeend', template);
                                // 아래와 같은 방법으로 변경 -> 객체를 얻는 것에 대한 어려움
                                let el = new DOMParser()
                                        .parseFromString(template, "text/html")
                                        .body
                                        .firstElementChild;

                                menuBox.append(el);


                                }

                    setTimeout(() => {
                        let length = menuBox.children.length;
                        for(let i=0; i<length; i++)
                            menuBox.children[i].classList.remove("hidden");
                    } ,10);




                    // setTimeout(()=> {
                    //     menuBox.lastElementChild.classList.remove("hidden");
                    // } , 0)
                    //12.21 막내를 찾는 연산
                    // node 조회
                    // 1.document.getElementById
                    // 2.querySelector
                    // 3.childern 0,1,2 번째
                    // 4.class id 통해서 찾기
                    // 5.menubox.lastElementChild
                    // 6.반복문 안에서 반복되는
                    // 7. children (element 객체만 대상으로 )vs. childNodes (모든 객체 대상으로)

                    //------ menubox.last

                    menuBox.classList.remove("ajax-loader");
                    //appendChild() append() insertAdjacentElement() in

                })
                .catch(err => {
                    console.log(`fetch error:${err.message}`);
                    menuBox.classList.remove("ajax-loader");
                });
        //fetch는 promise를 반환해준다


    }
})
