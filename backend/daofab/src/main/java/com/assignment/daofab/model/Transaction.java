package com.assignment.daofab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * @author amit shankar
 * 
 * Transaction entity class has their entities with getter and setter methods.
 * 
 * 
 * **/

@Entity
@Table(name = "transaction")
public class Transaction{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "sender")
	private String sender;

	@Column(name = "receiver")
	private String receiver;

	@Column(name = "total_amount")
	private int totalAmount;

	@Column(name="total_paid_amount")
	private int totalPaidAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTotalPaidAmount() {
		return totalPaidAmount;
	}

	public void setTotalPaidAmount(int totalPaidAmount) {
		this.totalPaidAmount = totalPaidAmount;
	}
}
