package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "order" )
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	
	@Column(name = "order_no")
	private String orderCode;
	
	@Column(name = "order_description")
	private String  orderDescription;
	
	
	@Column(name = "order_quantity")
	private int orderQuantity ;
	
	@Column(name = "order_buyer")
	private String orderBuyer;
	
	@Column(name = "order_style")
	private String orderStyle;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int id, String orderCode, String orderDescription, int orderQuantity, String orderBuyer,
			String orderStyle) {
		super();
		this.id = id;
		this.orderCode = orderCode;
		this.orderDescription = orderDescription;
		this.orderQuantity = orderQuantity;
		this.orderBuyer = orderBuyer;
		this.orderStyle = orderStyle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getOrderBuyer() {
		return orderBuyer;
	}

	public void setOrderBuyer(String orderBuyer) {
		this.orderBuyer = orderBuyer;
	}

	public String getOrderStyle() {
		return orderStyle;
	}

	public void setOrderStyle(String orderStyle) {
		this.orderStyle = orderStyle;
	}
	
	
	
}
