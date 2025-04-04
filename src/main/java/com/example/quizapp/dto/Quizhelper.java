package com.example.quizapp.dto;

import com.example.quizapp.entity.Quiz;
import com.example.quizapp.form.QuizForm;

public class Quizhelper {
	
	//Quizへの変換（Form->entity)
	public static Quiz convertQuiz(QuizForm f) {
		Quiz q = new Quiz();		
		q.setId(f.getId());
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
		
		return qf;
	}
}
