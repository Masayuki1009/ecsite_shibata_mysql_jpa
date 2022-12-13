package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Entity.ItemEntity;
import com.example.Entity.OrderEntity;
import com.example.Entity.OrderItemEntity;
import com.example.Entity.OrderToppingEntity;
import com.example.Entity.ToppingEntity;
import com.example.form.AddCartForm;
import com.example.repository.ItemRepository;
import com.example.repository.OrderItemRepository;
import com.example.repository.OrderRepository;
import com.example.repository.OrderToppingRepository;
import com.example.repository.ToppingRepository;

@Transactional
@Service
public class AddCartService {

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
	 * カートに追加する.
	 * 
	 * @param form   リクエストフォーム
	 * @param userId ユーザーID
	 */
	public void AddOrder(AddCartForm form, Integer userId) {
		ItemEntity itemEntity = itemRepository.getReferenceById(form.getItemId());

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setUserId(userId);
		orderEntity.setTotalPrice(0);
		orderEntity.setStatus(0);

		// 初めて登録するか判定
		if (orderRepository.findByStatusAndUserId(0, userId).size() == 0) {
			orderEntity = orderRepository.save(orderEntity);
		}

		// call orderEntity with status 0 to get order_id on line 57
		orderEntity = orderRepository.findByStatusAndUserId(0, userId).get(0);

		OrderItemEntity orderItemEntity = new OrderItemEntity(itemEntity.getId(), orderEntity.getId(), form.getArea(),
				form.getResponsibleCompany(), null);
		orderItemRepository.save(orderItemEntity);

		OrderToppingEntity orderToppingEntity = new OrderToppingEntity();
		if (form.getToppingIdList() != null) {
			for (int i = 0; i < form.getToppingIdList().size(); i++) {
				ToppingEntity toppingEntity = toppingRepository.getReferenceById(form.getToppingIdList().get(i));
				orderToppingEntity = new OrderToppingEntity(null, form.getToppingIdList().get(i),
						orderItemEntity.getId());
				orderToppingRepository.save(orderToppingEntity);
			}
		}
		System.out.println("orderEntity最終結果 : " + orderEntity);
		System.out.println("orderItemEntity最終結果 : " + orderItemEntity);
		System.out.println("orderToppingEntity最終結果 : " + orderToppingEntity);

	}
}

//
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
//import com.example.form.AddCartForm;
//import com.example.repository.ItemRepository;
//import com.example.repository.OrderItemRepository;
//import com.example.repository.OrderRepository;
//import com.example.repository.OrderToppingRepository;
//import com.example.repository.ToppingRepository;
//
///**
// * 
// * 
// * @author 萩田
// *
// */
//@Transactional
//@Service
//public class AddCartService {
//
//	@Autowired
//	private OrderRepository orderRepository;
//	@Autowired
//	private OrderItemRepository orderItemRepository;
//	@Autowired
//	private OrderToppingRepository orderToppingRepository;
//	@Autowired
//	private ToppingRepository toppingRepository;
//	@Autowired
//	private ItemRepository itemRepository;
//
//	/**
//	 * カートに追加する.
//	 * 
//	 * @param form   リクエストフォーム
//	 * @param userId ユーザーID
//	 */
//	public void AddOrder(AddCartForm form, Integer userId) {
//		Item item = itemRepository.load(form.getItemId());
//		Order order = new Order();
//		order.setUserId(userId);
//		order.setTotalPrice(0);
//		order.setStatus(0);
//		// 初めて登録するか判定
//		if (orderRepository.findByStatusAndUserId(0, userId) == null) {
//			order = orderRepository.insert(order);
//			System.out.println("orderの結果" + order);
//		}
//		OrderItem orderItem = new OrderItem(null, item.getId(),
//				orderRepository.findByStatusAndUserId(0, userId).get(0).getId(), form.getArea(),
//				form.getResponsibleCompany(), item, null);
//		orderItemRepository.insert(orderItem);
//
//		OrderTopping orderTopping = new OrderTopping();
//		if (form.getToppingIdList() != null) {
//			for (int i = 0; i < form.getToppingIdList().size(); i++) {
//				Topping topping = toppingRepository.load(form.getToppingIdList().get(i));
//				orderTopping = new OrderTopping(null, form.getToppingIdList().get(i), orderItem.getId(), topping);
//				orderToppingRepository.insert(orderTopping);// 回す
//			}
//		}
//	}
//
//}
