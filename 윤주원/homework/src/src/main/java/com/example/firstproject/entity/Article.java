package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor //롬복으로 생성
@ToString
@Entity //db 헤당 객체를 인식 가능!
@NoArgsConstructor // 디폴트 생성자 추가
@Getter // 롬복으로 게터 추가
public class Article {
    @Id// 대표값 주민번호
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1,2,3 auto generate,자동생성전략
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }
}



