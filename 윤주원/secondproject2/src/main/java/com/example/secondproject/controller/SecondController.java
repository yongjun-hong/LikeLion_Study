package com.example.secondproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.processing.Generated;

@Controller
public class SecondController {
    @GetMapping("/main")
    public String mmm(Model model){
        return "main";//html 페이지 이름
    }
    @GetMapping("/page1")
    public String first(Model model){
        model.addAttribute("title", "안녕하세요 페이지입니다.");
        return "page1";//html 페이지 이름
    }
    @GetMapping("/page2")
    public String second(Model model){
        model.addAttribute("title", "반가워요 페이지입니다.");
        return "page2";//html 페이지 이름

    }
    @GetMapping("/page3")
    public String third(Model model){
        model.addAttribute("title", "잘부탁드려요 페이지입니다.");
        return "page3";//html 페이지 이름

    }
}
