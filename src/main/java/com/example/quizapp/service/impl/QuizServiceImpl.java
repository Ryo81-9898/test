package com.example.quizapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.quizapp.dto.UserResult;
import com.example.quizapp.entity.KoumokuTable;
import com.example.quizapp.entity.MaxId;
import com.example.quizapp.entity.Quiz;
import com.example.quizapp.entity.TimeTable;
import com.example.quizapp.repository.QuizMapper;
import com.example.quizapp.service.QuizService;

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
	public TimeTable findTimeTable(int id) {
		return quizMapper.getTimeTable(id);
	}

	@Override
	public KoumokuTable findKoumokuTable(int id) {
		return quizMapper.getKoumokuTable(id);
	}

	@Override
	public void deleteQuiz(int id) {
		quizMapper.delete(id);
	}

	@Override
	public int findMaxId() {
		MaxId maxIdEntity = quizMapper.getMaxId();
		return maxIdEntity.getMaxId();
	}

	//正答率計算メソッド
	@Override
	public int correctAnsRate(List<UserResult> userResults, int questionCount) {
		//正解数のカウント
		int correctAnsCount = 0;
		for (UserResult ur : userResults) {
			if (ur.getAns().charAt(0) == ur.getUserAnswer().charAt(0)) {
				correctAnsCount++;
			}
		}
		return correctAnsCount * 100 / questionCount;
	}

	//	正解番号と内容の組み合わせを作成
	@Override
	public String correctAnsMake(UserResult userResult) {
		String correctAns = "";

		switch (userResult.getAns()) {
		case "1" -> correctAns = "1. " + userResult.getChoice1();
		case "2" -> correctAns = "2. " + userResult.getChoice2();
		case "3" -> correctAns = "3. " + userResult.getChoice3();
		case "4" -> correctAns = "4. " + userResult.getChoice4();
		case "5" -> correctAns = "5. " + userResult.getChoice5();
		}
		return correctAns;
	}

	//	ユーザーの解答番号と内容の組み合わせを作成
	@Override
	public String userAnsMake(UserResult userResult) {
		String userAns = "";

		switch (userResult.getUserAns()) {
		case "1" -> userAns = "1. " + userResult.getChoice1();
		case "2" -> userAns = "2. " + userResult.getChoice2();
		case "3" -> userAns = "3. " + userResult.getChoice3();
		case "4" -> userAns = "4. " + userResult.getChoice4();
		case "5" -> userAns = "5. " + userResult.getChoice5();
		}
		return userAns;
	}

	//	正解か不正解かの判定
	@Override
	public Boolean checkMatch(UserResult userResult) {
		if (userResult.getUserAns().equals(userResult.getAns())) {
			return true;
		} else {
			return false;
		}
		
	}

}
