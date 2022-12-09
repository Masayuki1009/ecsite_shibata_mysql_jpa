package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Item;
import com.example.domain.Order;
import com.example.domain.OrderItem;
import com.example.domain.OrderTopping;
import com.example.domain.Topping;
import com.example.form.AddCartForm;
import com.example.repository.ItemRepository;
import com.example.repository.OrderItemRepository;
import com.example.repository.OrderRepository;
import com.example.repository.OrderToppingRepository;
import com.example.repository.ToppingRepository;

/**
 * 
 * 
 * @author 萩田
 *
 */
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
		Item item = itemRepository.load(form.getItemId());
		Order order = new Order();
		order.setUserId(userId);
		order.setTotalPrice(0);
		order.setStatus(0);
		// 初めて登録するか判定
		if (orderRepository.findByStatusAndUserId(0, userId) == null) {
			order = orderRepository.insert(order);
			System.out.println("orderの結果" + order);
		}
		OrderItem orderItem = new OrderItem(null, item.getId(),
				orderRepository.findByStatusAndUserId(0, userId).get(0).getId(), form.getArea(),
				form.getResponsibleCompany(), item, null);
		orderItemRepository.insert(orderItem);

		OrderTopping orderTopping = new OrderTopping();
		if (form.getToppingIdList() != null) {
			for (int i = 0; i < form.getToppingIdList().size(); i++) {
				Topping topping = toppingRepository.load(form.getToppingIdList().get(i));
				orderTopping = new OrderTopping(null, form.getToppingIdList().get(i), orderItem.getId(), topping);
				orderToppingRepository.insert(orderTopping);// 回す
			}
		}
	}

}
