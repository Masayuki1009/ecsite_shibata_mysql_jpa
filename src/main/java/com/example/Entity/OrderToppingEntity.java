package com.example.Entity;

import java.util.List;

import com.example.domain.Topping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_toppings")
public class OrderToppingEntity {

	/** 注文トッピングID */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** トッピングID */
	@Column(name = "topping_id", nullable = false)
	private Integer toppingId;

	/** 注文商品ID */
	@Column(name = "order_item_id", nullable = false)
	private Integer orderItemId;

	@OneToOne
	@JoinColumn(name = "id")
	private ToppingEntity topping;
	
	public OrderToppingEntity() {
	}

	public OrderToppingEntity(Integer id, Integer toppingId, Integer orderItemId, ToppingEntity topping) {
		this.id = id;
		this.toppingId = toppingId;
		this.orderItemId = orderItemId;
		this.topping = topping;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getToppingId() {
		return toppingId;
	}

	public void setToppingId(Integer toppingId) {
		this.toppingId = toppingId;
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public ToppingEntity getTopping() {
		return topping;
	}

	public void setTopping(ToppingEntity topping) {
		this.topping = topping;
	}



}
