package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

//JpaReposiotory
public interface ArticleRepository extends CrudRepository<Article, Long> { //crud 동작을 사용 가능해짐 , <관리대상 entity, 대표값타입을 삽입>
    @Override
    ArrayList<Article> findAll();
}
