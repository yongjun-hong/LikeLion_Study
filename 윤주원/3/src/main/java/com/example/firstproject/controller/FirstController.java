package com.example.firstproject.controller;
//mustache와 연동시키기 위한 컨트롤러
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러로 사용하겠다.그리고 요청을 받는다.
public class FirstController {
    @GetMapping("/hi")// 연결시키기위한 것
    public String niceToMeetYou(Model model){
        model.addAttribute("username","joowon");//mustache에서 사용할 변수 선언
        return "greetings"; //tmeplates/greetings.mustache를 찾아서 브라우저에 전송!
    }
    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname","joowon");
        return "goodbye";//tmeplates/goodbye.mustache를 찾아서 브라우저에 전송!
    }


}
