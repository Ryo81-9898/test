package com.example.quizapp.security.repository;

import org.apache.ibatis.annotations.Mapper;


import com.example.quizapp.security.entity.Authentication;

@Mapper
public interface AuthenticationMapper {
//	ユーザー名でログイン情報を取得します。
	Authentication selectByUsername(String username);

}
