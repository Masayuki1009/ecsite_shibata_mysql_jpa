package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.UserRepository;

/**
 * usersテーブルを操作するサービス.
 * 
 * @author 萩田
 * 
 */
@Transactional
@Service
public class LoginLogoutService {

	@Autowired
	private UserRepository repository;

	/**
	 * ハッシュ化されたパスワードをもとにログイン判定を行う.
	 * 
	 * @param email    メールアドレス
	 * @param password パスワード
	 * @return ユーザー情報
	 */
	public User login(String email, String password) {
		
		User user = repository.findByUser(email, password);
		if (user == null) {
			return null;
		}
//		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
//		if (bcpe.matches(password, user.getPassword())) {
//			return user;
//		}
		return user;
	}

}
