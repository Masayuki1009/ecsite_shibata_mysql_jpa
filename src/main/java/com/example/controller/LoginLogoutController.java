package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Entity.UserEntity;
import com.example.form.LoginForm;
import com.example.service.LoginLogoutService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * ユーザー情報を操作するコントローラ.
 * 
 * @author 萩田
 *
 */
@Controller
@RequestMapping("/login")
public class LoginLogoutController {

	@Autowired
	private LoginLogoutService service;

	@Autowired
	private HttpSession session;

	/**
	 * ログイン画面表示.
	 * 
	 * @param form リクエストパラメータ
	 * @return ログイン画面
	 */
	@RequestMapping("")
	public String index(LoginForm form) {
		return "login";
	}

	/**
	 * ログイン処理.
	 * 
	 * @param form リクエストパラメータ
	 * @return 商品一覧ページ
	 */
	@PostMapping("/showItemList")
	public String login(LoginForm form, Model model, HttpServletResponse response) {
		UserEntity userEntity = service.login(form.getEmail(), form.getPassword());

		
		if (userEntity == null) {
			model.addAttribute("loginError", "メールアドレス、またはパスワードが間違っています");
			return "login";
		}
		session.setAttribute("userId", userEntity.getId());
		session.setAttribute("userName", userEntity.getName());
		return "redirect:/";
	}

	/**
	 * ログアウト処理.
	 * 
	 * @return ログイン画面
	 */
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
}
