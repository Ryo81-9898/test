package com.example.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.quizapp.dto.UserResult;
import com.example.quizapp.entity.Quiz;
import com.example.quizapp.repository.QuizMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

	// DI
	private final QuizMapper quizMapper;

	@Override
	public List<Quiz> selectAllQuiz() {
		return quizMapper.selectAll();
	}

	@Override
	public List<Quiz> randomSelectQuiz(int no) {
		return quizMapper.randomSelect(no);
	}

	@Override
	public Quiz findQuizById(int id) {
		return quizMapper.selectById(id);
	}

	@Override
	public void insertNewQuiz(Quiz quiz) {
		quizMapper.insert(quiz);

	}

	@Override
	public void updateQuiz(Quiz quiz) {
		quizMapper.update(quiz);
	}

	@Override
	public void deleteQuiz(int id) {
		quizMapper.delete(id);
	}

	// 正答率、答え、解説表示のための情報を整理し、コントローラーへ送る
	@Override
	public List<UserResult> getUserResult(Map<String, String> params, int questionCount) {
		List<UserResult> userResults = new ArrayList<>();

		//送信されたデータの取得
		for (int i = 1; i <= questionCount; i++) {
			String questionText = params.get("question_" + i);
			String correctAnswer = params.get("ans_" + i);
			String explanation = params.get("explanation_" + i);
			String userAnswer = params.get("userAnswerQuestionNo" + i);


			//answer.htmlで表示するための情報を持ったクラスのリスト化
			UserResult result = new UserResult(questionText, correctAnswer, explanation, userAnswer);
			userResults.add(result);
		}

		return userResults;
	}

	//正答率計算メソッド
	@Override
	public int correctAnsRate(List<UserResult> userResults, int questionCount) {
		//正解数のカウント
		int correctAnsCount = 0;
		for (UserResult ur: userResults) {
			if (ur.getCorrectAnswer().charAt(0) == ur.getUserAnswer().charAt(0)) {
				correctAnsCount++;
			}
		}
		return correctAnsCount * 100 / questionCount;
	}

}
