package com.example.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "item_id")
	private Integer itemId;

	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "size")
	private String size;

//	@OneToMany
//	@JoinColumn(name = "order_item_id")
//	private List<OrderToppingEntity> orderToppingList;

	public OrderItemEntity() {
	}

	public OrderItemEntity(Integer itemId, Integer orderId, Integer quantity, String size,
			List<OrderToppingEntity> orderToppingList) {
		this.itemId = itemId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.size = size;
//		this.item = item;
//		this.orderToppingList = orderToppingList;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "OrderItemEntity [id=" + id + ", itemId=" + itemId + ", orderId=" + orderId + ", quantity=" + quantity
				+ ", size=" + size + "]";
	}

//	public List<OrderToppingEntity> getOrderToppingList() {
//		return orderToppingList;
//	}
//
//	public void setOrderToppingList(List<OrderToppingEntity> orderToppingList) {
//		this.orderToppingList = orderToppingList;
//	}

}
