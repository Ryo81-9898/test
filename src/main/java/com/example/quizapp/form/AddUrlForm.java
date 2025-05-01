package com.example.quizapp.form;

import jakarta.validation.constraints.Pattern;

import com.example.quizapp.entity.Lkoumoku;
import com.example.quizapp.entity.Mkoumoku;
import com.example.quizapp.entity.Mokuhyo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUrlForm {
		private Integer koumokuId;
		private String sKoumoku;
		@Pattern(regexp = "^$|https?://.+", message = "空欄または http(s):// から始まるURLを入力してください")
		private String blogUrl;
		private Mkoumoku mkoumoku;
		private Lkoumoku lkoumoku;
		private Mokuhyo mokuhyo;

}
