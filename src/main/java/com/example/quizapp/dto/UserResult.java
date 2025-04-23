package com.example.quizapp.dto;

import com.example.quizapp.entity.Koumoku;
import com.example.quizapp.entity.TestNumber;
import com.example.quizapp.entity.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResult {
	private Integer id;
	private Integer questionNumber;
	private String question;       // 問題文
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private String choice5;
	private String ans;
	private String explanation;
	private TestNumber testNumber;
	private Time time;
	private Koumoku koumoku;
	
	private String userAns; 		//数値のみ
    private String userAnswer;     // ユーザーの解答
    private String correctAnswer;	//正解番号と内容の組み合わせ
    private Boolean match;			//正解か不正解かの判断(正解ならtrue)

    

	
	
	
    
}
