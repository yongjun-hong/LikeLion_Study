package com.example.likelionstudy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//컨트롤러의 기능을 수행한다.
public class MainController {
    @GetMapping("/likelion")//localhost:8080/likelion 요청이 발생하면 index 메서드가 실행된다.
    @ResponseBody //응답으로 문자열을 리턴하라는 의미
    public String index(){
        return "파이팅!!";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
