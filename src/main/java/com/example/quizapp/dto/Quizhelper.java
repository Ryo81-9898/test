package com.example.quizapp.dto;

import com.example.quizapp.entity.Koumoku;
import com.example.quizapp.entity.Quiz;
import com.example.quizapp.entity.TestNumber;
import com.example.quizapp.entity.Time;
import com.example.quizapp.form.QuizForm;

public class Quizhelper {
	
	//Quizへの変換（Form->entity)
	public static Quiz convertQuiz(QuizForm f) {
		Quiz q = new Quiz();		
		q.setId(f.getId());
		q.setQuestionNumber(f.getQuestionNumber());
		q.setQuestion(f.getQuestion());
		q.setChoice1(f.getChoice1());
		q.setChoice2(f.getChoice2());
		q.setChoice3(f.getChoice3());
		q.setChoice4(f.getChoice4());
		if(f.getChoice5()=="" || f.getChoice5() == null) {
			q.setChoice5(null);
		}else {
			q.setChoice5(f.getChoice5());			
		}
		q.setAns(f.getAns());
		q.setExplanation(f.getExplanation());

		return q;	
	}
	
	//QuizFormへ変換（Entity->Form)
	public static QuizForm convertForm(Quiz q) {
		QuizForm qf = new QuizForm();
		qf.setId(q.getId());
		qf.setQuestionNumber(q.getQuestionNumber());
		qf.setQuestion(q.getQuestion());
		qf.setChoice1(q.getChoice1());
		qf.setChoice2(q.getChoice2());
		qf.setChoice3(q.getChoice3());
		qf.setChoice4(q.getChoice4());
		if(q.getChoice5() == null) {
			qf.setChoice5(null);
		}else {
			qf.setChoice5(q.getChoice5());			
		}
		qf.setAns(q.getAns());
		qf.setExplanation(q.getExplanation());
		qf.setTestNumber(q.getTestNumber());
		qf.setTime(q.getTime());
		qf.setKoumoku(q.getKoumoku());
		return qf;
	}
	
//	問題から解説へ遷移する際に使用するコンバーター
	//UserResultへ変換（Entity->UserResult)
	public static UserResult convertUserResult(Quiz q) {
		UserResult ur = new UserResult();
		ur.setId(q.getId());
		ur.setQuestionNumber(q.getQuestionNumber());
		ur.setQuestion(q.getQuestion());
		ur.setChoice1(q.getChoice1());
		ur.setChoice2(q.getChoice2());
		ur.setChoice3(q.getChoice3());
		ur.setChoice4(q.getChoice4());
		ur.setChoice5(q.getChoice5());
		String ans = String.valueOf(q.getAns());
		ur.setAns(ans);
		ur.setExplanation(q.getExplanation());
		ur.setImagePath(q.getImagePath());
		ur.setTestNumber(q.getTestNumber());
		ur.setTime(q.getTime());
		ur.setKoumoku(q.getKoumoku());
		return ur;
		
	}

	
//新規作成時にフォームから受け取った情報を整理してエンティティにつなげるコンバーター
	//	QuizForm->Quiz
	//上のこのメソッド（convertQuiz:Quizへの変換（Form->entity)）いらなくなるかも（最後に確認）
		public static Quiz toQuiz(QuizForm f) {
			Quiz q = new Quiz();		
			q.setId(f.getId());
			q.setTestNumber(new TestNumber(f.getTestNumberId()));
			q.setTime(new Time(f.getTimeId()));
			q.setQuestionNumber(f.getQuestionNumber());
			q.setQuestion(f.getQuestion());
			if(f.getImagePath()=="" || f.getImagePath() == null) {
				q.setImagePath(null);
			}else {
				q.setImagePath(f.getImagePath());			
			}
			q.setChoice1(f.getChoice1());
			q.setChoice2(f.getChoice2());
			q.setChoice3(f.getChoice3());
			q.setChoice4(f.getChoice4());
			if(f.getChoice5()=="" || f.getChoice5() == null) {
				q.setChoice5(null);
			}else {
				q.setChoice5(f.getChoice5());			
			}
			q.setAns(f.getAns());
			if(f.getExplanation()=="" || f.getExplanation() == null) {
				q.setExplanation(null);
			}else {
				q.setExplanation(f.getExplanation());			
			}
			q.setKoumoku(new Koumoku(f.getKoumokuId()));
			return q;

		}
		
		
//		更新時に必要なコンバーター（型変換用）
		//QuizFormへ変換（Entity->Form)
		public static QuizForm toForm(Quiz q) {
			QuizForm qf = new QuizForm();
			qf.setId(q.getId());
			qf.setQuestionNumber(q.getQuestionNumber());
			qf.setQuestion(q.getQuestion());
			if(q.getImagePath() == null) {
				q.setImagePath(null);
			}else {
				qf.setImagePath(q.getImagePath());			
			}
			qf.setChoice1(q.getChoice1());
			qf.setChoice2(q.getChoice2());
			qf.setChoice3(q.getChoice3());
			qf.setChoice4(q.getChoice4());
			if(q.getChoice5() == null) {
				qf.setChoice5(null);
			}else {
				qf.setChoice5(q.getChoice5());			
			}
			qf.setAns(q.getAns());
			if(q.getExplanation() == null) {
				qf.setExplanation(null);
			}else {
				qf.setExplanation(q.getExplanation());			
			}
			qf.setTestNumber(q.getTestNumber());
			qf.setTestNumberId(q.getTestNumber().getTestNumberId());
			qf.setTime(q.getTime());
			qf.setTimeId(q.getTime().getTimeId());
			qf.setKoumoku(q.getKoumoku());
			qf.setKoumokuId(q.getKoumoku().getKoumokuId());
			System.out.println(q);
			return qf;
		}
		
}
