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
//		.getBean(TryQuizappApplication.class).exe()
		}
	
//	private final QuizMapper m;
//
//	public void exe() {
//	
//
//			System.out.println("全件検索");
//			for (Quiz q : m.selectAll()) {
//			System.out.println(q);
//			}
//			//5問表示
//			System.out.println("5問表示");
//			for (Quiz q : m.randomSelect(5)) {
//				System.out.println(q);
//			}
//			
//			//1問表示
//			System.out.println("1問表示");
//			System.out.println(m.selectById(11));
//			//登録
//			System.out.println("登録");
//			Quiz q = new Quiz();
//			TestNumber test = new TestNumber();
//			test.setTestNumberId(105);
//			Time time = new Time();
//			time.setTimeId(1);
//			Koumoku koumoku = new Koumoku();
//			koumoku.setKoumokuId(1);
//			q.setTestNumber(test);
//			q.setTime(time);
//			q.setQuestionNumber(14);
//			q.setQuestion("question21");
//			q.setChoice1("choice21-1");
//			q.setChoice2("choice21-2");
//			q.setChoice3("choice21-3");
//			q.setChoice4("choice21-4");
//			q.setAns(1);
//			q.setExplanation("explanation21");
//			q.setKoumoku(koumoku);
//			m.insert(q);
//			System.out.println("登録確認");
//			System.out.println(m.selectById(21));
//			//更新
//			Quiz qu = m.selectById(2);
//			TestNumber test1 = new TestNumber();
//			test1.setTestNumberId(105);
//			Time time1 = new Time();
//			time1.setTimeId(1);
//			Koumoku koumoku1 = new Koumoku();
//			koumoku1.setKoumokuId(1);
//			qu.setTestNumber(test1);
//			qu.setTime(time1);
//			qu.setQuestionNumber(25);
//			qu.setQuestion("question100");
//			qu.setChoice1("choice100-1");
//			qu.setChoice2("choice100-2");
//			qu.setChoice3("choice100-3");
//			qu.setChoice4("choice100-4");
//			qu.setChoice4("choice100-5");
//			qu.setAns(3);
//			qu.setKoumoku(koumoku1);
//			m.update(qu);
//			System.out.println("更新確認");
//			System.out.println(m.selectById(2));
//			//削除
//			m.delete(1);
//			System.out.println("削除確認");
//			for (Quiz i : m.selectAll()) {
//				System.out.println(i);
//			}
//			//タイムテーブル、項目テーブル
//			System.out.println(m.getTimeTable(1));
//			System.out.println(m.getKoumokuTable(16));
//	
//		
//	}
//}
	
	
	private final QuizService s;
	
	public void exe() {
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
//		
//		
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
//		s.updateQuiz(qu);
//		System.out.println("更新確認");
//		System.out.println(s.findQuizById(2));
//		//削除
//		s.deleteQuiz(1);
//		System.out.println("削除確認");
//		for (Quiz i : s.selectAllQuiz()) {
//			System.out.println(i);
//		}
		
		//タイムテーブル、項目テーブル
		System.out.println(s.findTimeTable(1));
		System.out.println(s.findKoumokuTable(16));

	}
}
