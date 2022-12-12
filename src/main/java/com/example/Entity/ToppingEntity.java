package com.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "toppings")
public class ToppingEntity {
	@Id
	@Column(name = "id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "price_m", nullable = false)
	private Integer priceM;

	@Column(name = "price_l", nullable = false)
	private Integer priceL;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPriceM() {
		return priceM;
	}

	public void setPriceM(Integer priceM) {
		this.priceM = priceM;
	}

	public Integer getPriceL() {
		return priceL;
	}

	public void setPriceL(Integer priceL) {
		this.priceL = priceL;
	}

	@Override
	public String toString() {
		return "Topping [id=" + id + ", name=" + name + ", priceM=" + priceM + ", priceL=" + priceL + "]";
	}
}
