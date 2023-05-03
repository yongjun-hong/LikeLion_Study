package com.example.likelionstudy.answer;

import java.time.LocalDateTime;

import com.example.likelionstudy.question.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    //N:1 관계
    @ManyToOne //답변은 하나의 질문에 여러개가 달리는 구조. Question 엔티티와 연결된 속성이라는 것을 명시적으로 표시.
    private Question question; //답변 엔티티에서 질문 엔티티를 참조하기 위해 추가.
}