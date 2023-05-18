package com.example.firstproject.controller;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j // 로깅을 위한 어노테이션이다.
public class ArticleController {

    @Autowired //미리 생성한 객체를 자동연결
    private ArticleRepository articleRepository;//객체 안만들어도 스프링부트가 알아서 해줌

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")// new.mustache에서 post로 던지기로 해서
    public String createArticles(ArticleForm form){
        log.info(form.toString());

        //1. dto를 entity로 변환!
        Article article=form.toEntity();//article 이라는 entity 클래스
       log.info(article.toString());

        //2.repository에게 entity를 db안에 저장
       Article saved= articleRepository.save(article);
       log.info(saved.toString());

        return "redirect:/articles/"+saved.getId();
    }
    @GetMapping("/articles/{id}")// 해당 url 요청을 처리 선언
    public String show(@PathVariable Long id, Model model){// urldptj id변수로 가져옴
        log.info("id = "+id);
        //1.id로 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        //2.가져온 데이터 모델에 등록
        model.addAttribute("article",articleEntity);
        //3. 보여줄 페이지 설정
        return "articles/show";
    }
    @GetMapping("/articles")
    public String index(Model model){
        //1.모든 article을 가져온다.
        List<Article> articleEntityList = articleRepository.findAll();
        //2.가져온 article 묶음으로 view에 전달
        model.addAttribute("articleList",articleEntityList);
        //3.뷰 페이지 설정
        return "articles/index";
    }
    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        // 수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 모델에 데이터 등록
        model.addAttribute("article", articleEntity);
        // 뷰 페이지 설정
        return "articles/edit";
    }
    @PostMapping("/articles/update")
    public String update(ArticleForm form) {
        log.info(form.toString());
        // 1: DTO를 엔티티로 변환
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());
        // 2: 엔티티를 DB로 저장
        // 2-1: DB에서 기존 데이터를 가져옴
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
        // 2-2: 기존 데이터가 있다면, 값을 갱신
        if (target != null) {
            articleRepository.save(articleEntity);
        }
        // 3: 수정 결과 페이지로 리다이렉트
        return "redirect:/articles/" + articleEntity.getId();
    }
    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        log.info("삭제 요청이 들어옴");
        //1.삭제 대상 가져오기
        Article target =  articleRepository.findById(id).orElse(null);
        log.info(target.toString());
        //2.대상 삭제
        if(target!=null){
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg","삭제 완료띠");
        }
        //3.결과페이지로 리다이렉트
        return "redirect:/articles";
    }
}
