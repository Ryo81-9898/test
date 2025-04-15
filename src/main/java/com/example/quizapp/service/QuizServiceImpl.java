package com.example.quizapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.quizapp.dto.UserResult;
import com.example.quizapp.entity.KoumokuTable;
import com.example.quizapp.entity.MaxId;
import com.example.quizapp.entity.Quiz;
import com.example.quizapp.entity.TimeTable;
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
		for (UserResult ur: userResults) {
			if (ur.getAns().charAt(0) == ur.getUserAnswer().charAt(0)) {
				correctAnsCount++;
			}
		}
		return correctAnsCount * 100 / questionCount;
	}

}
