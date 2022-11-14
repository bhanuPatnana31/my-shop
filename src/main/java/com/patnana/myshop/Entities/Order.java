package com.patnana.myshop.Entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int orderId;
	private String orderDesc;
	private LocalDateTime orderTime;
	private float orderValue;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime dateTime) {
		this.orderTime = dateTime;
	}

	public float getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(float orderValue) {
		this.orderValue = orderValue;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDesc=" + orderDesc + ", orderTime=" + orderTime + ", orderValue="
				+ orderValue + "]";
	}
	

}
