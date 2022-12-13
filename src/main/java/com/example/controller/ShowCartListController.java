//package com.example.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.example.Entity.OrderEntity;
//import com.example.service.ShowCartListService;
//
//import jakarta.servlet.http.HttpSession;
//
//@Controller
//@RequestMapping("/show-cart")
//public class ShowCartListController {
//
//	@Autowired
//	private ShowCartListService showCartListService;
//
//	@Autowired
//	private HttpSession session;
//
//	/**
//	 * カートリスト表示.
//	 * 
//	 * @param model リクエストパラメータ
//	 * @return カートリストページ
//	 */
//	@GetMapping("")
//	public String index(Model model) {
//		if (session.getAttribute("userId") != null) {
//			Integer userId = (Integer) session.getAttribute("userId");
//			OrderEntity orderEntity = showCartListService.showCartList(userId, 0);
//
////				Integer tempTotalPrice = order.getTotalPrice() + hashOrder.getTotalPrice();
////				order.setTotalPrice(tempTotalPrice);
////			}
//
////			if (order != null) {
////				Integer tax = order.getTax();
////				model.addAttribute("tax", tax);
////				order.setTotalPrice(tax + order.getTotalPrice());
////			}
////			System.out.println("orderEntity : " + orderEntity);
//			model.addAttribute("cartList", orderEntity);
//			return "cart_list";
//		}
//
////		Integer userId = Math.abs(session.getId().hashCode());
////		Order order = showCartListService.showCartList(userId, 0);
////		if (order != null) {
////			Integer tax = order.getTax();
////			model.addAttribute("tax", tax);
////			order.setTotalPrice(tax + order.getTotalPrice());
////		}
////		model.addAttribute("cartList", orderEntity);
//		return "cart_list";
//	}
//}
//
////package com.example.controller;
////
////
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
////
////import com.example.domain.Order;
////import com.example.service.ShowCartListService;
////
////import jakarta.servlet.http.HttpSession;
////
/////**
//// * ordersテーブルを操作するコントローラ.
//// * 
//// * @author 萩田
//// *
//// */
////@Controller
////@RequestMapping("/show-cart")
////public class ShowCartListController {
////
////	@Autowired
////	private ShowCartListService showCartListService;
////
////	@Autowired
////	private HttpSession session;
////
////	/**
////	 * カートリスト表示.
////	 * 
////	 * @param model リクエストパラメータ
////	 * @return カートリストページ
////	 */
////	@GetMapping("")
////	public String index(Model model) {
////		if (session.getAttribute("userId") != null) {
////			Integer userId = (Integer) session.getAttribute("userId");
////			Order order = showCartListService.showCartList(userId, 0);
////			Order hashOrder = showCartListService.showCartList(Math.abs(session.getId().hashCode()), 0);
////
////			if (hashOrder != null && order != null) {
////				for (int i = 0; i < hashOrder.getOrderItemList().size(); i++) {
////					order.getOrderItemList().add(hashOrder.getOrderItemList().get(i));
////				}
////				System.out.println(hashOrder);
////				System.out.println(order);
////				Integer tempTotalPrice = order.getTotalPrice() + hashOrder.getTotalPrice();
////				order.setTotalPrice(tempTotalPrice);
////			}
////
////			if (order != null) {
////				Integer tax = order.getTax();
////				model.addAttribute("tax", tax);
////				order.setTotalPrice(tax + order.getTotalPrice());
////			}
////			model.addAttribute("cartList", order);
////			return "cart_list";
////		}
////		Integer userId = Math.abs(session.getId().hashCode());
////		Order order = showCartListService.showCartList(userId, 0);
////		if (order != null) {
////			Integer tax = order.getTax();
////			model.addAttribute("tax", tax);
////			order.setTotalPrice(tax + order.getTotalPrice());
////		}
////		model.addAttribute("cartList", order);
////		return "cart_list";
////	}
////}
