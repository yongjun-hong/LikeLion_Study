package com.example.Using_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

@Controller
public class PageController {

    @GetMapping("/button") // /button 주소 요청이 오면, 실행되는 메소드
    public String button(){

        return "button";  //button 이라는 파일을 찾아서 반환해준다.
    }

    @GetMapping("/page1") // /page1 주소 요청이 오면, 실행되는 메소드
    public String page1(Model model){
        String today = datefunc();
        model.addAttribute("page11", today); //page1.html에 있는 page11이라는 변수에 현재시간 데이터 저장.
        return "page1";  //page1 이라는 파일을 찾아서 반환해준다.
    }

    @GetMapping("/page2") // /page2 주소 요청이 오면, 실행되는 메소드
    public String page2(Model model){
        String today = datefunc();
        model.addAttribute("page22", today); //page2.html에 있는 page22이라는 변수에 현재시간 데이터 저장.
        return "page2";  //page2 이라는 파일을 찾아서 반환해준다.
    }

    @GetMapping("/page3") // /page3 주소 요청이 오면, 실행되는 메소드
    public String page3(Model model){
        String today = datefunc();
        model.addAttribute("page33", today); //page3.html에 있는 page33이라는 변수에 현재시간 데이터 저장.
        return "page3";  //page3 이라는 파일을 찾아서 반환해준다.
    }

    public String datefunc(){ //현재 시간을 반환하는 함수
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        return formattedDate;
    }
}
