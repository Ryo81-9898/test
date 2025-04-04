package com.example.quizapp.form;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizForm {
		private int id;
		private String question;
		private String choice1;
		private String choice2;
		private String choice3;
		private String choice4;
		private String choice5;
		private Integer ans;
		private String explanation;
		//新規作成or更新(form.html)、ID検索or更新確認画面(detail.html)
		private Boolean isNew;
}
