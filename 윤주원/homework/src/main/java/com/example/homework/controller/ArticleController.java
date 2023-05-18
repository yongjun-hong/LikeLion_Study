package com.example.homework.controller;

import com.example.homework.dto.ArticleForm;
import com.example.homework.entity.Article;
import com.example.homework.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @GetMapping("/articles")

    @PostMapping("/articles/new")
    public String nAF(ArticleForm dto){
      log.info(dto.toString());
      //dto를 entity로 변환
      Article article = dto.toEntity();
      //repository에게 entity를 db로 저장
      Article saved = articleRepository.save(article);
      return "";
    }

}
