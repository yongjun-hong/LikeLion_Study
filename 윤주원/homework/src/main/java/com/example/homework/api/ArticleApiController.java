package com.example.homework.api;

import com.example.homework.dto.ArticleForm;
import com.example.homework.entity.Article;
import com.example.homework.repository.ArticleRepository;
import com.example.homework.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ArticleApiController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/api/hello")
    public String hello(){
        return "hello world!";
    }

    public List<Article> index() {
        return articleService.index();

    }

    @GetMapping("/articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleService.show(id);
    }

    @PostMapping("/articles")
    public ResponseEntity<Article> create(@RequestParam ArticleForm articleForm){
        Article article = articleService.create(articleForm);

        return (article != null) ?
                ResponseEntity.status(HttpStatus.OK).body(article) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
