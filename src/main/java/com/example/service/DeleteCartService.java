package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Entity.OrderItemEntity;
import com.example.Entity.OrderToppingEntity;
import com.example.Entity.ToppingEntity;
import com.example.repository.OrderItemRepository;
import com.example.repository.OrderToppingRepository;

/**
 * order_itemテーブルを操作するサービス.
 * 
 * @author shibatamasayuki
 *
 */
@Transactional
@Service
public class DeleteCartService {

	@Autowired
	OrderItemRepository repository;

	@Autowired
	OrderToppingRepository orderToppingRepository;

	/**
	 * 削除処理を行う.
	 * 
	 * @param orderItemId orderItemのid
	 */
	public void deleteCart(Integer id) {

		OrderItemEntity deleteOrderItemEntity = repository.findByid(id);
		System.out.println("Topping消去済みのOrderItemEntity : " + deleteOrderItemEntity);

		if (deleteOrderItemEntity.getOrderToppingList().size() != 0) {
			System.out.println("toppingあります");
			List<OrderToppingEntity> orderToppingList = deleteOrderItemEntity.getOrderToppingList();
			System.out.println("消去予定のOrderTopping : " + orderToppingList);
			orderToppingRepository.deleteAllOrderTop(id);
//			Integer orderItemId = orderToppingList.get(0).getOrderItemId();
//			for (OrderToppingEntity orderTopping : orderToppingList) {
//				orderToppingRepository.delete(orderTopping);
////				orderToppingRepository.deleteById(orderItemId);
//				System.out.println("orderList状況 : " + orderTopping);
//			}

		}

		System.out.println("deleteOrderItemEntity" + deleteOrderItemEntity);
		repository.delete(deleteOrderItemEntity);

	}
}

//package com.example.service;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.repository.OrderItemRepository;
//
///**
// * order_itemテーブルを操作するサービス.
// * 
// * @author shibatamasayuki
// *
// */
//@Transactional
//@Service
//public class DeleteCartService {
//
//	@Autowired
//	OrderItemRepository repository;
//	
//	/**
//	 * 削除処理を行う.
//	 * 
//	 * @param orderItemId orderItemのid
//	 */
//	public void deleteCart(Integer orderItemId) {
//		repository.deleteById(orderItemId);
//	}
//}
