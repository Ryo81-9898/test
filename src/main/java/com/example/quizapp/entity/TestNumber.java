package com.example.quizapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestNumber {
		private Integer testNumberId;
		private Integer gengoNen;
		private Integer seireki;
		private Gengo gengo;

}
