package com.example.homework.service;
import com.example.homework.entity.Article;
import com.example.homework.dto.ArticleForm;
import com.example.homework.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    public List<Article> index(){
        return articleRepository.findAll();
    }
    public Article show(Long id){
        return articleRepository.findById(id).orElse(null);
    }
    public Article create(ArticleForm articleForm){
        Article article = articleForm.toEntity();
        if(article.getId()!=null) return null;
        return articleRepository.save(article);
    }
    public Article update(Long id, ArticleForm articleForm){
        Article article = articleForm.toEntity();
        Article target = articleRepository.findById(id).orElse(null);
        if(target == null || id!=article.getId()){
            return null;
        }
        target.patch(article);
        Article updated = articleRepository.save(target);
        return updated;
    }
    public Article delete(Long id){
        Article article = articleRepository.findById(id).orElse(null);
        if(article == null)
            return null;
        articleRepository.delete(article);
        return article;
    }





}
