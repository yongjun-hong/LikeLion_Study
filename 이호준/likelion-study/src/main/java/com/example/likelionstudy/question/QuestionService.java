package com.example.likelionstudy.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    //전체 질문 수 조회
    public long getCount() {
        return this.questionRepository.count();
    }
    //전체 질문 리스트 조회
    public List<Question> getList(){
        return this.questionRepository.findAll();
    }
}
