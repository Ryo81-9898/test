package com.example.quizapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Koumoku {
		private Integer koumokuId;
		private String sKoumoku;
		private String blogUrl;
		private Mkoumoku mkoumoku;
		private Lkoumoku lkoumoku;
		private Mokuhyo mokuhyo;
		
//		フォームから得た数値を変換するためのコンストラクター（新規作成時に使用）
		public Koumoku(Integer k) {
			this.koumokuId = k;
		}


}
