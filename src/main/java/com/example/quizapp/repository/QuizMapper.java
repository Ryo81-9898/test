package com.example.quizapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.quizapp.entity.Koumoku;
import com.example.quizapp.entity.MaxId;
import com.example.quizapp.entity.Quiz;
import com.example.quizapp.entity.TestNumber;
import com.example.quizapp.entity.TimeTable;

@Mapper
public interface QuizMapper {
//	すべての問題を取得
	List<Quiz> selectAll();
	
//	ランダムで指定した問題数取得
	List<Quiz> randomSelect(int id);
	
//	idで指定した問題を取得
	Quiz selectById(Integer id);
	
//	新しい問題を登録
	void insert(Quiz quiz);
	
//	問題を修正（更新）
	void update(Quiz quiz);
	
//	更新時のタイムテーブル取得
	TimeTable getTimeTable(int id);
	
//	更新時の項目テーブル取得
	Koumoku getKoumokuById(int id);

//	idで指定した問題を削除
	void delete(@Param("id") int id);
	
//	idの最大値を取得
	MaxId getMaxId();
	
//	ブログURL一覧のためのテーブル取得
	List<Koumoku> getKoumoku();
	
//	ブログURL追加、更新のためIdで検索
	Koumoku selectUrlById(int id);
	
//	ブログURLをデータベース追加のためのメソッド
	void updateUrl(Koumoku k);
	
//	新年度追加処理
	void insertYear(TestNumber t);
}
