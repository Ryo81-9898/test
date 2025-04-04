package com.example.quizapp.service;

import java.util.List;
import java.util.Map;

import com.example.quizapp.dto.UserResult;
import com.example.quizapp.entity.Quiz;

public interface QuizService {
//	すべての問題を取得
	List<Quiz> selectAllQuiz();
	
//	ランダムで５問取得
	List<Quiz> randomSelectQuiz(int no);
	
//	idで指定した問題を取得
	Quiz findQuizById(int id);
	
//	新しい問題を登録
	void insertNewQuiz(Quiz quiz);
	
//	問題を修正（更新）
	void updateQuiz(Quiz quiz);
	
//	idで指定した問題を削除
	void deleteQuiz(int id);

//	問題答え、解説の情報を扱う
	List<UserResult> getUserResult(Map<String, String> params, int questionCount);
	
//	正答率計算メソッド
	public int correctAnsRate(List<UserResult> userResults, int questionCount);
}