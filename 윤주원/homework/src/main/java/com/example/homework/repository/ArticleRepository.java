package com.example.homework.repository;
import com.example.homework.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Override
    List<Article> findAll();
}
