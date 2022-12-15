package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.DeleteCartService;

/**
 * カートの商品削除を行うコントローラ.
 * 
 *
 * 
 * @author shibatamasayuki
 *
 */
@Controller
@RequestMapping("/delete")
public class DeleteCartController {
	@Autowired
	DeleteCartService service;

	/**
	 * @return カート一覧ページに遷移.
	 */
	@GetMapping("")
	public String index() {
		return "dummy";
	}

	/**
	 * カート内商品の削除処理を行い、カート一覧ページに遷移.
	 * 
	 * @param orderItemId orderItemのid
	 * @return リダイレクト
	 */
	@PostMapping("/cart")
	public String deleteCart(Integer id) {
		
		service.deleteCart(id);
		System.out.println("deleteCartController終了!!!!");
		return "redirect:/show-cart";
//		return "redirect:/";
	}
}




//package com.example.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.example.service.DeleteCartService;
//
///**
// * カートの商品削除を行うコントローラ.
// * 
// *
// * 
// * @author shibatamasayuki
// *
// */
//@Controller
//@RequestMapping("/delete")
//public class DeleteCartController {
//	@Autowired
//	DeleteCartService service;
//
//	/**
//	 * @return カート一覧ページに遷移.
//	 */
//	@GetMapping("")
//	public String index() {
//		return "dummy";
//	}
//
//	/**
//	 * カート内商品の削除処理を行い、カート一覧ページに遷移.
//	 * 
//	 * @param orderItemId orderItemのid
//	 * @return リダイレクト
//	 */
//	@PostMapping("/cart")
//	public String deleteCart(Integer orderItemId) {
//		service.deleteCart(orderItemId);
//
//		return "redirect:/show-cart";
//	}
//}
//
