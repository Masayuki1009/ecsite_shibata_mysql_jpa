package com.example.Entity;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {
	/** 注文ID */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** ユーザーID */
	@Column(name = "user_id")
	private Integer userId;

	/** ステータス */
	@Column(name = "status")
	private Integer status;

	/** 合計金額 */
	@Column(name = "total_price")
	private Integer totalPrice;

	/** 注文日 */
	@Column(name = "order_date")
	private String orderDate;

	/** 宛先氏名 */
	@Column(name = "destination_name")
	private String destinationName;

	/** 宛先Eメール */
	@Column(name = "destination_email")
	private String destinationEmail;

	/** 宛先郵便番号 */
	@Column(name = "destination_zipcode")
	private String destinationZipcode;

	/** 宛先住所 */
	@Column(name = "destination_address")
	private String destinationAddress;

	/** 宛先TEL */
	@Column(name = "destination_tel")
	private String destinationTel;

	/** 配達時間 */
	@Column(name = "delivery_time")
	private Timestamp deliveryTime;

	/** 支払い方法 */
	@Column(name = "payment_method")
	private Integer paymentMethod;

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval=true)
	@JoinColumn(name = "order_id")
	private List<OrderItemEntity> orderItemList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getDestinationEmail() {
		return destinationEmail;
	}

	public void setDestinationEmail(String destinationEmail) {
		this.destinationEmail = destinationEmail;
	}

	public String getDestinationZipcode() {
		return destinationZipcode;
	}

	public void setDestinationZipcode(String destinationZipcode) {
		this.destinationZipcode = destinationZipcode;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public String getDestinationTel() {
		return destinationTel;
	}

	public void setDestinationTel(String destinationTel) {
		this.destinationTel = destinationTel;
	}

	public Timestamp getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Timestamp deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Integer getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public List<OrderItemEntity> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItemEntity> orderItemList) {
		this.orderItemList = orderItemList;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", userId=" + userId + ", status=" + status + ", totalPrice=" + totalPrice
				+ ", orderDate=" + orderDate + ", destinationName=" + destinationName + ", destinationEmail="
				+ destinationEmail + ", destinationZipcode=" + destinationZipcode + ", destinationAddress="
				+ destinationAddress + ", destinationTel=" + destinationTel + ", deliveryTime=" + deliveryTime
				+ ", paymentMethod=" + paymentMethod + ", orderItemList=" + orderItemList + "]";
	}

//	@Override
//	public String toString() {
//		return "OrderEntity [id=" + id + ", userId=" + userId + ", status=" + status + ", totalPrice=" + totalPrice
//				+ ", orderDate=" + orderDate + ", destinationName=" + destinationName + ", destinationEmail="
//				+ destinationEmail + ", destinationZipcode=" + destinationZipcode + ", destinationAddress="
//				+ destinationAddress + ", destinationTel=" + destinationTel + ", deliveryTime=" + deliveryTime
//				+ ", paymentMethod=" + paymentMethod + "]";
//	}

}
