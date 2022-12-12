package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Entity.UserEntity;
import com.example.form.InsertUserForm;
import com.example.service.InsertUserService;

@Controller
@RequestMapping("/insert")
public class InsertUserController {

	@Autowired
	private InsertUserService service;

	/**
	 * 登録画面表示.
	 * 
	 * @return 登録画面
	 */
	@GetMapping("")
	public String index(Model model, InsertUserForm form) {
		
		return "register_user";
	}

	/**
	 * ログイン画面遷移.
	 * 
	 * @param form リクエストパラメータ
	 * @return ログイン画面
	 */
	@PostMapping("/register")
	public String insert(@Validated InsertUserForm form, BindingResult result, RedirectAttributes redirectAttributes,
			Model model) {
		if (result.hasErrors()) {
			return index(model, form);
		}
//		User userEntity = new User();
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(form, userEntity);
		service.insert(userEntity);
		return "redirect:/login";
	}

}
