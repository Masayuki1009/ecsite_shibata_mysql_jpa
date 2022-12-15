package com.example.service;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Entity.OrderEntity;
import com.example.form.OrderConfirmationForm;
import com.example.repository.OrderRepository;

/**
 * order情報の更新に関連するサービス.
 * 
 * @author shibatamasayuki
 *
 */
@Service
@Transactional
public class OrderConfirmationService {

	@Autowired
	OrderRepository repository;

	/**
	 * 注文処理を行う.
	 * 
	 * @return order
	 */
	public void updateOrder(OrderConfirmationForm form) {
		String deliveryTime = String.format("%s %s:00:00", form.getDeliveryTime(), form.getResponsibleCompany());
		SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("deliveryTime : " + deliveryTime);
		
		
		try {
			Date date = dateParser.parse(deliveryTime);
			
			Timestamp ts = new Timestamp(date.getTime());
			OrderEntity order = repository.getReferenceById(form.getOrderId());
			
			LocalDateTime currentTime = LocalDateTime.now();
//			System.out.println("orderDate : " + orderdate);
			DateTimeFormatter formatForm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String orderDate = currentTime.format(formatForm);
			System.out.println("orderDate結果 : " + orderDate);
			
			
			
			order.setOrderDate(orderDate);
			order.setId(form.getOrderId());
			order.setStatus(form.getPaymentMethod());
			order.setDestinationName(form.getDestinationName());
			order.setDestinationEmail(form.getDestinationEmail());
			order.setDestinationZipcode(form.getDestinationZipcode());
			order.setDestinationAddress(form.getDestinationAddress());
			order.setDestinationTel(form.getDestinationTel());
			order.setPaymentMethod(form.getPaymentMethod());
			order.setDeliveryTime(ts);
			System.out.println("orderEntity確認 情報更新後" + order);
//			repository.update(order);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
