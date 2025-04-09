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
		private Mkoumoku mkoumoku;
		private Lkoumoku lkoumoku;
		private Mokuhyo mokuhyo;
		



}
