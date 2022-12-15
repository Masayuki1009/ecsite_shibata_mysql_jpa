package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Entity.ItemEntity;
import com.example.Entity.OrderEntity;
import com.example.Entity.OrderItemEntity;
import com.example.Entity.OrderToppingEntity;
import com.example.Entity.ToppingEntity;
import com.example.form.OrderConfirmationForm;
import com.example.service.ShowOrderConfirmService;

/**
 * 注文確認画面遷移を行う.
 * 
 * @author shibatamasayuki
 *
 */
@Controller
@RequestMapping("/order-confirm")
public class ShowOrderConfirmController {

	@Autowired
	ShowOrderConfirmService showOrderConfirmService;

	/**
	 * 注文確認画面に遷移.
	 * 
	 * @param orderId orderのid
	 * @param model   model
	 * @return 注文確認画面
	 */
	@PostMapping("/order")
	public String order(Model model, OrderConfirmationForm form) {
		OrderEntity orderEntity = showOrderConfirmService.findByOrderId(form.getOrderId());
		System.out.println("showOrderConfirmCont OrderEntity : " + orderEntity);
		List<OrderItemEntity> orderItemList = orderEntity.getOrderItemList();
		
		for (OrderItemEntity orderItem : orderItemList) {
			ItemEntity item = showOrderConfirmService.findItemByItemId(orderItem.getItemId());
			orderItem.setItem(item);

//			List<OrderTopping> orderToppingList = showOrderConfirmService
//					.findOrderToppingListByOrderItemId(orderItem.getId());
			List<OrderToppingEntity> orderToppingList = orderItem.getOrderToppingList();

			for (OrderToppingEntity orderTopping : orderToppingList) {
				ToppingEntity topping = showOrderConfirmService.findToppingByToppingId(orderTopping.getToppingId());
				orderTopping.setTopping(topping);
			}
			orderItem.setOrderToppingList(orderToppingList);
		}
//
		orderEntity.setOrderItemList(orderItemList);
		model.addAttribute("order", orderEntity);

		return "order_confirm";
//		return "redirect:/";
	}
}

//package com.example.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.example.domain.Item;
//import com.example.domain.Order;
//import com.example.domain.OrderItem;
//import com.example.domain.OrderTopping;
//import com.example.domain.Topping;
//import com.example.form.OrderConfirmationForm;
//import com.example.service.ShowOrderConfirmService;
//
///**
// * 注文確認画面遷移を行う.
// * 
// * @author shibatamasayuki
// *
// */
//@Controller
//@RequestMapping("/order-confirm")
//public class ShowOrderConfirmController {
//
//	@Autowired
//	ShowOrderConfirmService showOrderConfirmService;
//
//	/**
//	 * 注文確認画面に遷移.
//	 * 
//	 * @param orderId orderのid
//	 * @param model   model
//	 * @return 注文確認画面
//	 */
//	@PostMapping("/order")
//	public String order(Model model, OrderConfirmationForm form) {
//		Order order = showOrderConfirmService.findByOrderId(form.getOrderId());
//		List<OrderItem> orderItemList = showOrderConfirmService.findOrderItemListByOrderId(form.getOrderId());
//		for (OrderItem orderItem : orderItemList) {
//			Item item = showOrderConfirmService.findItemByItemId(orderItem.getItemId());
//			orderItem.setItem(item);
//
//			List<OrderTopping> orderToppingList = showOrderConfirmService
//					.findOrderToppingListByOrderItemId(orderItem.getId());
//
//			for (OrderTopping orderTopping : orderToppingList) {
//				Topping topping = showOrderConfirmService.findToppingByToppingId(orderTopping.getToppingId());
//				orderTopping.setTopping(topping);
//			}
//			orderItem.setOrderToppingList(orderToppingList);
//		}
//
//		order.setOrderItemList(orderItemList);
//		model.addAttribute("order", order);
//
//		return "order_confirm";
//	}
//}
