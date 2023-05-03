package com.example.likelionstudy.question;

import com.example.likelionstudy.answer.Answer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id //기본 키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //1씩 자동으로 증가.
    private Integer id;

    @Column(length = 200)
    //엔티티의 속성은 테이블의 컬럼명과 일치한다. 컬럼의 세부 설정을 위해 사용하는 어노테이션.
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    //1:N 관계
    //mappedBy는 속성명. Answer 클래스에서 Question 클래스를 참조한 참조명이다.
    //cascade는 질문이 삭제되면 답변도 같이 삭제.
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;//질문 하나에 답변은 여러개이므로, List 형태로 구성한다.
}
