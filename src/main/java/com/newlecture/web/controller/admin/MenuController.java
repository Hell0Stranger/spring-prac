package com.newlecture.web.controller.admin;

import com.newlecture.web.entity.Menu;
import com.newlecture.web.service.MenuService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.util.List;


    @Controller("adminMenuController")
    @RequestMapping("/admin/menu")
    public class MenuController {

        @Autowired // Field DI (DI 외에 별도로 실행해야 하는 로직이 없는 경우, Field에 Autowired 를 한다.)
        private MenuService service;
//	private CartService cartService;

        @GetMapping("list")


        public String list( // p 로 오는것을 page에 담아달라
                            @RequestParam(defaultValue = "1", name="p") int page,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response) {

            /*---------make cookie --------------*/
            String encodingValue = URLEncoder.encode("Hello Cookie");
            Cookie cookie = new Cookie("ctest", encodingValue);
            cookie.setPath("/");
            cookie.setMaxAge(100000000);
            response.addCookie(cookie);
            int memberId = 1 ;
            int countInCart = service.countOfMenuInCart(memberId);
//			session.setAttribute("test", "hello");
            List<Menu> list = service.getList(page);
//		Object test = session.getAttribute("test");



            model.addAttribute("list", list);
            model.addAttribute("countInCart", countInCart);
            return "admin/menu/list";
        }
        @PostMapping("list")
//post는 요청을 처리하지 않는다
        public String list( @RequestParam("menu-id") int menuId,
                            boolean ice,
                            boolean large) {
            System.out.printf("menuId:%d, ice:%s, large:%s\n",menuId,ice,large);
            service.addToCart(1,menuId,ice,large);
            return "redirect:list";// 다시 get요청 발생
        }
        // 경로에 많은 변수들을 꽂아서 쓸 수 있도록 하기 위함
        @GetMapping("{id}")
        //public String detail(int id) = 쿼리스트링 != 경로
        public String detail(
                @PathVariable("id") int id,
                @CookieValue ("ctest") String test,
                Model model
        ) {
            int memberId =1;
            int countInCart = service.countOfMenuInCart(memberId);
            Menu menu = service.get(id);
            System.out.println("id: "+id);
//		List<Menu> rcmdList = service.getRcmdListByMenu(menuId);
//		List<Menu> newList = service.getNewList();

//		String test = (String) session.getAttribute("test");

            System.out.println(test);
            return "menu/detail";
        }


        //사용자는 url encoded 방식으로 데이터를 전송한다
        // enctype 3가지 옵션 1. application/x-www-form (쿼리 스트링 형식)
        //					2. 파일은 어떻게 전송 ( 문자열과 결합 불가)  / multipart/form-data
        //					3.
        @PostMapping("reg")
        public  String reg(MultipartFile img, String title, int price, HttpServletRequest request) throws IOException {
            //일련번호?
            service.add(title, img.getOriginalFilename(),price);
            if(!img.isEmpty()){
                String path = "/image/menu";
                String realPath = request.getServletContext().getRealPath(path);
                System.out.println(realPath);

                File pathFile = new File(realPath);
                if(!pathFile.exists())
                    pathFile.mkdirs();

                // 어디에 저장할 것인가 ? (물리적으로 풀 경로)
                String fullPath = realPath+ File.separator+img.getOriginalFilename();
                InputStream fis = img.getInputStream();
                OutputStream fos = new FileOutputStream(fullPath);
                byte[] buf = new byte[1024];
                int size = 0;
                while ((size=fis.read(buf))>=0)
                        fos.write(buf,0,size);

                fos.close();
                fis.close();
            }
            return "redirect:list";
        }
//	public String list(Model model) { // front Controller 에게 Model 객체를 달라고 요청하는 것
//		service.testTS();
//		model.addAttribute("data", "hello"); // front Controller 에게 값을 넘겨준 것
//		service.getList();
//		System.out.print("호정아 안녕");
//		return "menu/list";
//	}
    }

