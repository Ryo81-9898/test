package com.example.quizapp.service.impl;

import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.quizapp.entity.Authentication;
import com.example.quizapp.entity.LoginUser;
import com.example.quizapp.repository.AuthenticationMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginUserDetailsServiceImpl implements UserDetailsService {

	//	DI
	private final AuthenticationMapper authenticationMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//「認証テーブル」からデータを取得
		Authentication authentication = authenticationMapper.selectByUsername(username);
		
		//		対象データがあれば、UserDetailsの実装クラスを返す
		if (authentication != null) {
			//対象データが存在する
			//UserDetailsの実装クラスを返す
			return new LoginUser(authentication.getUsername(),
					authentication.getPassword(),
					Collections.emptyList()
//					getAuthorityList(authentication.getAuthority()),
//					authentication.getDisplayname()
					);

		} else {
			//	対象データが存在しない
			throw new UsernameNotFoundException(
					username + " => 指定しているユーザ名は存在しません");

		}


	}

}
