package com.example.quizapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
	private Integer id;
	private Integer questionNumber;
	private String question;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private String choice5;
	private Integer ans;
	private String explanation;
	private TestNumber testNumber;
	private Time time;
	private Koumoku koumoku;
	
	

	

}
