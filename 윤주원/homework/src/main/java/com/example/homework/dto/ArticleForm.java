package com.example.homework.dto;


import com.example.homework.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class ArticleForm {
    private String title;
    private String content;

    public Article toEntity(){
        return new Article(null,title,content);
    }
}
