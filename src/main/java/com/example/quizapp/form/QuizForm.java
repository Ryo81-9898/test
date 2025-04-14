package com.example.quizapp.form;


import com.example.quizapp.entity.Koumoku;
import com.example.quizapp.entity.TestNumber;
import com.example.quizapp.entity.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizForm {
		private int id;
		private Integer questionNumber;
		private String question;
		private String choice1;
		private String choice2;
		private String choice3;
		private String choice4;
		private String choice5;
		private Integer ans;
		private String explanation;
		private Integer testNumberId;
		private TestNumber testNumber;
		private Integer timeId;
		private Time time;
		private Integer koumokuId;
		private Koumoku koumoku;
		//新規作成or更新(form.html)、ID検索or更新確認画面(detail.html)
		private Boolean isNew;
}
