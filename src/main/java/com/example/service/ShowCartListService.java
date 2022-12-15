package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Entity.ItemEntity;
import com.example.Entity.OrderEntity;
import com.example.Entity.OrderItemEntity;
import com.example.Entity.OrderToppingEntity;
import com.example.Entity.ToppingEntity;
import com.example.repository.ItemRepository;
import com.example.repository.OrderItemRepository;
import com.example.repository.OrderRepository;
import com.example.repository.OrderToppingRepository;
import com.example.repository.ToppingRepository;

/**
 * ordersテーブルを操作するレポジトリ.
 * 
 * @author 萩田
 *
 */
@Transactional
@Service
public class ShowCartListService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private OrderToppingRepository orderToppingRepository;
	@Autowired
	private ToppingRepository toppingRepository;
	@Autowired
	private ItemRepository itemRepository;

	/**
	 * 注文表を取得.
	 * 
	 * @param userId ユーザーID
	 * @param status ステータスID
	 * @return
	 */
	public OrderEntity showCartList(Integer userId, Integer status) {
		// ユーザーIDとステータスから注文前の情報を取得
		List<OrderEntity> orderList = orderRepository.findByStatusAndUserId(status, userId);
		if (orderList == null) {
			return null;
		}
		OrderEntity orderEntity = orderList.get(0);
		System.out.println("showcartServ orderEntity : " + orderEntity);
//		Integer totalSum = 0;

		// 注文商品リストにオーダーIDと一致する商品を取得
//		List<OrderItemEntity> orderItemList = orderItemRepository.findByOrderId(orderEntity.getId());
		List<OrderItemEntity> orderItemList = orderEntity.getOrderItemList();
		System.out.println("showcartServ orderItemList(Item追加前) : " + orderItemList);

		
		for (OrderItemEntity orderItemEntity : orderItemList) {
			ItemEntity item = itemRepository.getReferenceById(orderItemEntity.getItemId());
			orderItemEntity.setItem(item);
			System.out.println("showCartServ item取得後" + orderItemEntity);
//
			List<OrderToppingEntity> orderToppingList = orderItemEntity.getOrderToppingList();
			System.out.println("orderToppinglist" + orderToppingList);
			for (OrderToppingEntity orderToppingEntity : orderToppingList) {
				ToppingEntity topping = toppingRepository.getReferenceById(orderToppingEntity.getToppingId());
				System.out.println("toppin結果" + topping);
				orderToppingEntity.setTopping(topping);
			}
			
			orderItemEntity.setOrderToppingList(orderToppingList);
		}
//		orderEntity.setOrderItemList(orderItemList);
//		System.out.println("最終結果 orderEntity" + orderEntity);

//		List<ItemEntity> itemList = new ArrayList<>();
//		for (int i = 0; i < orderItemList.size(); i++) {
//			// トッピングリストを取得
//			List<OrderToppingEntity> orderToppingList = orderToppingRepository.findByOrderItemId(orderItemList.get(i).getId());
//			System.out.println("showcartServ orderToppingList : " + orderToppingList);

//			for (int j = 0; j < orderToppingList.size(); j++) {

//				if (orderToppingList.get(j).getToppingId() == 0) 	{
//					orderToppingList.get(j).setTopping(null);
//					break;
//				}
//				ToppingEntity toppingEntity = toppingRepository.getReferenceById(orderToppingList.get(j).getToppingId());
//				orderToppingList.get(j).setTopping(toppingEntity);

		// トッピング金額加算
//				if ("M".equals(orderItemList.get(i).getSize())) {
//					System.out.println(i);
////					totalSum += topping.getPriceM();
//				} else if ("L".equals(orderItemList.get(i).getSize())) {
////					totalSum += topping.getPriceL();
//				}
//			}
//			orderItemList.get(i).setOrderToppingList(orderToppingList);
//			itemList.add(itemRepository.getReferenceById(orderItemList.get(i).getItemId()));
//						orderItemList.get(i).setItem(itemList.get(i));

		// トッピング金額加算
//			if ("M".equals(orderItemList.get(i).getSize())) {
////				totalSum += itemList.get(i).getPriceM();
//			} else if ("L".equals(orderItemList.get(i).getSize())) {
////				totalSum += itemList.get(i).getPriceL();
//			}
//		}
//		order.setTotalPrice(totalSum);
		orderEntity.setOrderItemList(orderItemList);
		System.out.println("最終orderEntity shoecartListServ" + orderEntity);
		return orderEntity;
	}

}

//package com.example.service;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.domain.Item;
//import com.example.domain.Order;
//import com.example.domain.OrderItem;
//import com.example.domain.OrderTopping;
//import com.example.domain.Topping;
//import com.example.repository.ItemRepository;
//import com.example.repository.OrderItemRepository;
//import com.example.repository.OrderRepository;
//import com.example.repository.OrderToppingRepository;
//import com.example.repository.ToppingRepository;
//
///**
// * ordersテーブルを操作するレポジトリ.
// * 
// * @author 萩田
// *
// */
//@Transactional
//@Service
//public class ShowCartListService {
//
//	@Autowired
//	private OrderRepository orderRepository;
//	@Autowired
//	private OrderItemRepository orderItemRepository;
//	@Autowired
//	private OrderToppingRepository orderToppingRepository;
//	@Autowired
//	private ToppingRepository toppinRepository;
//	@Autowired
//	private ItemRepository itemRepository;
//
//	/**
//	 * 注文表を取得.
//	 * 
//	 * @param userId ユーザーID
//	 * @param status ステータスID
//	 * @return
//	 */
//	public Order showCartList(Integer userId, Integer status) {
//		// ユーザーIDとステータスから注文前の情報を取得
//		List<Order> orderList = orderRepository.findByStatusAndUserId(status, userId);
//		if (orderList == null) {
//			return null;
//		}
//		Order order = orderList.get(0);
//		Integer totalSum = 0;
//
//		// 注文商品リストにオーダーIDと一致する商品を取得
//		List<OrderItem> orderItemList = orderItemRepository.findByOrderId(order.getId());
//		List<Item> itemList = new ArrayList<>();
//
//		for (int i = 0; i < orderItemList.size(); i++) {
//			// トッピングリストを取得
//			List<OrderTopping> orderToppingList = orderToppingRepository
//					.findByOrderItemId(orderItemList.get(i).getId());
//
//			for (int j = 0; j < orderToppingList.size(); j++) {
//				if (orderToppingList.get(j).getToppingId() == 0) {
//					orderToppingList.get(j).setTopping(null);
//					break;
//				}
//				Topping topping = toppinRepository.load(orderToppingList.get(j).getToppingId());
//				orderToppingList.get(j).setTopping(topping);
//
//				// トッピング金額加算
//				if ("M".equals(orderItemList.get(i).getSize())) {
//					System.out.println(i);
//					totalSum += topping.getPriceM();
//				} else if ("L".equals(orderItemList.get(i).getSize())) {
//					totalSum += topping.getPriceL();
//				}
//			}
//			orderItemList.get(i).setOrderToppingList(orderToppingList);
//			itemList.add(itemRepository.load(orderItemList.get(i).getItemId()));
//			orderItemList.get(i).setItem(itemList.get(i));
//
//			// トッピング金額加算
//			if ("M".equals(orderItemList.get(i).getSize())) {
//				totalSum += itemList.get(i).getPriceM();
//			} else if ("L".equals(orderItemList.get(i).getSize())) {
//				totalSum += itemList.get(i).getPriceL();
//			}
//		}
//		order.setTotalPrice(totalSum);
//		order.setOrderItemList(orderItemList);
//		return order;
//	}
//
//}

//test
//for (OrderItemEntity orderItemEntity : orderItemList) {
//	ItemEntity item = itemRepository.getReferenceById(orderItemEntity.getItemId());
//	orderItemEntity.setItem(item);
//	System.out.println("showCartServ item取得後" + orderItemEntity);
//	
//	List<OrderToppingEntity> orderToppingList = orderToppingRepository.findByOrderItemId(orderItemEntity.getId());
//	for (OrderToppingEntity orderToppingEntity : orderToppingList) {
//	ToppingEntity topping = toppingRepository.getReferenceById(orderToppingEntity.getToppingId());
//	orderToppingEntity.setTopping(topping);
//}
//orderItemEntity.setOrderToppingList(orderToppingList);
//}
//orderEntity.setOrderItemList(orderItemList);
//System.out.println("最終結果 orderEntity" + orderEntity);
