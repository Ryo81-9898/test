package com.example.quizapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResult {
    private String questionText;       // 問題文
    private String correctAnswer;  // 正解
    private String explanation;    // 解説
    private String userAnswer;     // ユーザーの解答
}
