package com.example.quizapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Time {
			private Integer timeId;
			private String time;
			
//			フォームから得た数値を変換するためのコンストラクター（新規作成時に使用）
			public Time(Integer t) {
				this.timeId = t;
			}
}
