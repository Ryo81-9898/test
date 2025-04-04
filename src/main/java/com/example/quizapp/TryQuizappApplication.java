package com.example.quizapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.quizapp.service.QuizService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class TryQuizappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TryQuizappApplication.class, args);
//		.getBean(TryQuizappApplication.class).exe();	
		}
	
	private final QuizService s;
	
//	public void exe() {
//		//全件検索
//		System.out.println("全件検索");
//		for (Quiz q : s.selectAllQuiz()) {
//			System.out.println(q);
//		}
//		//5問表示
//		System.out.println("5問表示");
//		for (Quiz q : s.randomSelectQuiz(5)) {
//			System.out.println(q);
//		}
//		
//		//1問表示
//		System.out.println("1問表示");
//		System.out.println(s.findQuizById(11));
//		//登録
//		System.out.println("登録");
//		Quiz q = new Quiz();
//		q.setQuestion("question21");
//		q.setChoice1("choice21-1");
//		q.setChoice2("choice21-2");
//		q.setChoice3("choice21-3");
//		q.setChoice4("choice21-4");
//		q.setAns(1);
//		q.setExplanation("explanation21");
//		s.insertNewQuiz(q);
//		System.out.println("登録確認");
//		System.out.println(s.findQuizById(21));
//		//更新
//		Quiz qu = s.findQuizById(2);
//		qu.setQuestion("question100");
//		qu.setChoice1("choice100-1");
//		qu.setChoice2("choice100-2");
//		qu.setChoice3("choice100-3");
//		qu.setChoice4("choice100-4");
//		qu.setAns(1);
//		qu.setExplanation("explanation100");
//		s.correctQuiz(qu);
//		System.out.println("更新確認");
//		System.out.println(s.findQuizById(2));
//		//削除
//		s.deleteQuiz(1);
//		System.out.println("削除確認");
//		for (Quiz i : s.selectAllQuiz()) {
//			System.out.println(i);
//		}
//
//	}
	
	

}
