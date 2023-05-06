package com.example.likelionstudy;

import com.example.likelionstudy.question.Question;
import com.example.likelionstudy.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class LikelionStudyApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void createQuestion(){
		Question q1 = new Question();
		q1.setSubject("테스트 제목입니다");
		q1.setContent("테스트 내용입니다");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);
	}
	//Question 테이블에 저장된 모든 데이터를 조회.
	@Test
	void findAll() {
		List<Question> questionList = this.questionRepository.findAll();
		assertEquals(6, questionList.size());
	}
	//Question 엔티티의 Id 값으로 데이터 조회.
	@Test
	void findById() {
		Optional<Question> oq = this.questionRepository.findById(2);
		if(oq.isPresent()){
			Question q = oq.get();
			assertEquals("스프링부트 모델 질문입니다.", q.getSubject());
		}
	}
	//Question 엔티티의 subject 값으로 조회하기.
	//findBySubject는 기본적으로 제공되지 않는 메소드 이므로, Question 리포지토리에서 추가.
	@Test
	void findBySubject() {
		Question q = this.questionRepository.findBySubject("스프링부트 모델 질문입니다.");
		assertEquals(2, q.getId());
	}
	//Question 엔티티의 subject, content 값을 AND 조건으로 조회하기.
	@Test
	void findBySubjectAndContent() {
		Question q = this.questionRepository.findBySubjectAndContent("스프링부트 모델 질문입니다.", "id는 자동으로 생성되나요?");
		assertEquals(2, q.getId());
	}
}
