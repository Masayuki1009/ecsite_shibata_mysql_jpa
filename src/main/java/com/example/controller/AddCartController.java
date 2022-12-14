package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.AddCartForm;
import com.example.service.AddCartService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class AddCartController {

	@Autowired
	private AddCartService addCartService;

	@Autowired
	private HttpSession session;

	/**
	 * 商品詳細ページ.
	 * 
	 * @return
	 */
	@GetMapping("")
	public String index() {
		return "item_detail";
	}

	/**
	 * カート追加.
	 * 
	 * @param form   カートフォーム
	 * @param userId ユーザーID
	 * @param model  リクエストパラメータ
	 * @return カート画面
	 */
	@PostMapping("/cart-add")
	public String addCart(AddCartForm form, Integer userId, Model model) {
		
		if (session.getAttribute("userId") == null) {
//			addCartService.AddOrder(form, Math.abs(session.getId().hashCode()));
//			addCartService.AddOrder(form, Math.abs(session.getId().hashCode()));
			return "redirect:/show-cart";
		}
		addCartService.AddOrder(form, userId);
		return "redirect:/show-cart";
	}
}


//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.example.form.AddCartForm;
//import com.example.service.AddCartService;
//
//import jakarta.servlet.http.HttpSession;
//
///**
// * 
// * 
// * @author 萩田
// *
// */
//@Controller
//@RequestMapping("/cart")
//public class AddCartController {
//
//	@Autowired
//	private AddCartService addCartService;
//
//	@Autowired
//	private HttpSession session;
//
//	/**
//	 * 商品詳細ページ.
//	 * 
//	 * @return
//	 */
//	@GetMapping("")
//	public String index() {
//		return "item_detail";
//	}
//
//	/**
//	 * カート追加.
//	 * 
//	 * @param form   カートフォーム
//	 * @param userId ユーザーID
//	 * @param model  リクエストパラメータ
//	 * @return カート画面
//	 */
//	@PostMapping("/cart-add")
//	public String addCart(AddCartForm form, Integer userId, Model model) {
//		
//		System.out.println("userId" + session.getAttribute("userId"));
//		if (session.getAttribute("userId") == null) {
////			addCartService.AddOrder(form, Math.abs(session.getId().hashCode()));
//			addCartService.AddOrder(form, Math.abs(session.getId().hashCode()));
//			return "redirect:/show-cart";
//		}
//		addCartService.AddOrder(form, userId);
//		return "redirect:/show-cart";
//	}
//}
