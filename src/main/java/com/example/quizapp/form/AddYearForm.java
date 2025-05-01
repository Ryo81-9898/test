package com.example.quizapp.form;

import jakarta.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.example.quizapp.entity.Gengo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddYearForm {

//	private Integer testNumberId;
//	private Integer gengoNen;
//	private Integer seireki;
//	private Gengo gengo;
	
	
	
	 // ① テスト回：3桁（105〜999）
    @NotNull(message = "※テスト回を入力してください")
    @Range(min = 105, max = 199, message = "※3桁の数値（最新のテスト回入力）")
    private Integer testNumberId;

    // ② 元号年：1〜2桁（1〜99）
    @NotNull(message = "※元号年を入力してください")
    @Range(min = 1, max = 99, message = "※1〜2桁の数値（元号年を入力）")
    private Integer gengoNen;

    // ③ 西暦：4桁、2010〜2099に制限（Patternを使うためString型）
    @NotNull(message = "※西暦を入力してください")
    @Range(min = 2015, max = 2099, message = "※4桁の数値（西暦年を入力）")
    private Integer seireki;

    // ④ 元号（セレクトボックスで選択）
    @NotNull(message = "※元号を選択してください")
    private Gengo gengo;
}
