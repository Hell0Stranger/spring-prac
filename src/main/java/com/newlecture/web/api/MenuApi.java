package com.newlecture.web.api;

import com.newlecture.web.entity.Menu;
import com.newlecture.web.service.MenuService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MenuApi {

    @Autowired
    private MenuService service;
    /* GET/POST */
    // api/menus/cate/2
    @GetMapping("menus")
    public List<Menu> list(
            @RequestParam(defaultValue = "1", name="c") int category) {
        List<Menu> list = service.getListByCategory(category);
        return list;
    }

    @GetMapping("menus/{id}")
    public String item() {
        return null;
    }



    @PostMapping("reg")
    public  String reg(MultipartFile img, String name,
                       int price, HttpServletRequest request) throws IOException {
        //일련번호? -> 목록 만들기
//        {
//            status: 200,//사용자의 응답처리
//            resultObject: {id: 1, title: ..}
//        }

        Menu menu = service.getLastOneAfterAdding(name, img.getOriginalFilename(), int price);

//        service.afterAdding();
        Map<String, Object> dto = new HashMap<>();
        dto.put("status", 200);
        dto.put("resultObject", menu);


        //map

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


}
//    try {
//            Thread.sleep(10000);
//            } catch (InterruptedException e) {
//            e.printStackTrace();
//            }