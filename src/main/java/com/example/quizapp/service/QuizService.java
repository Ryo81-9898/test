package com.example.quizapp.service;

import java.util.List;

import com.example.quizapp.dto.UserResult;
import com.example.quizapp.entity.Koumoku;
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
	Koumoku findKoumokuTable(int id);
	
//	idで指定した問題を削除
	void deleteQuiz(int id);
	
//	idの最大値を取得
	int findMaxId();

	
//	正答率計算メソッド
	int correctAnsRate(List<UserResult> userResults, int questionCount);
	
//	正解番号と内容の組み合わせを作成
	String correctAnsMake(UserResult userResult);
	
//	ユーザーの解答番号と内容の組み合わせを作成
	String userAnsMake(UserResult userResult);
	
//	正解か不正解かの判定
	Boolean checkMatch(UserResult userResult);
	
	
	
//	ブログURL一覧取得
	List<Koumoku> findAllBlogUrl();
}