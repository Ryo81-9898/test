package com.example.quizapp.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

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
	@NotNull(message = "※問題番号は必須です")
	private Integer questionNumber;
	@NotBlank(message = "※問題文は必須です")
	private String question;
	@Pattern(regexp = ".*\\.(png|jpg)$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "画像ファイルは .png, .PNG, .jpg, .JPG のいずれかで指定してください")
	private String imagePath;
	@NotBlank(message = "※選択肢1は必須です")
	private String choice1;
	@NotBlank(message = "※選択肢2は必須です")
	private String choice2;
	@NotBlank(message = "※選択肢3は必須です")
	private String choice3;
	@NotBlank(message = "※選択肢4は必須です")
	private String choice4;
	private String choice5;
	@NotNull(message = "※答えは必須です")
	private Integer ans;
	private String explanation;
	@NotNull(message = "※試験回数は必須です")
	@Range(min = 105, max = 114, message = "※試験回数は第{min}回から最新のテストまでの範囲となっています")
	private Integer testNumberId;
	private TestNumber testNumber;
	@NotNull(message = "※選択は必須です")
	private Integer timeId;
	private Time time;
	@NotNull(message = "※選択は必須です")
	private Integer koumokuId;
	private Koumoku koumoku;
	//新規作成or更新(form.html)、ID検索or更新確認画面(detail.html)
	private Boolean isNew;

}
