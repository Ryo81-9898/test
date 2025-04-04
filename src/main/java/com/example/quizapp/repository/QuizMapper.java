package com.example.quizapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.quizapp.entity.Quiz;

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
	
//	idで指定した問題を削除
	void delete(@Param("id") int id);
	
	

}
