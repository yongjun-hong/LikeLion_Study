package com.example.firstproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// rest api를 구현하는 컨트롤러에 붙이는 어노테이션
@RestController
public class FirstApiController {

    @GetMapping("/api/hello")
    public String hello(){
        return "hello world!";
    }
}
