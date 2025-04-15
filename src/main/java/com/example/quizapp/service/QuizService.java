package com.example.quizapp.service;

import java.util.List;

import com.example.quizapp.dto.UserResult;
import com.example.quizapp.entity.KoumokuTable;
import com.example.quizapp.entity.Quiz;
import com.example.quizapp.entity.TimeTable;

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
	
//	更新時のタイムテーブル取得
	TimeTable findTimeTable(int id);
	
//	更新時の項目テーブル取得
	KoumokuTable findKoumokuTable(int id);
	
//	idで指定した問題を削除
	void deleteQuiz(int id);
	
//	idの最大値を取得
	int findMaxId();

	
//	正答率計算メソッド
	public int correctAnsRate(List<UserResult> userResults, int questionCount);
}