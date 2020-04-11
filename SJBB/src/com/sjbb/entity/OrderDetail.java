package com.sjbb.entity;
// Generated Apr 11, 2020 12:53:19 AM by Hibernate Tools 5.2.12.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OrderDetail generated by hbm2java
 */
@Entity
@Table(name = "order_detail", catalog = "fyp")
public class OrderDetail implements java.io.Serializable {

	private OrderDetailId id;
	private Order order;

	public OrderDetail() {
	}

	public OrderDetail(OrderDetailId id, Order order) {
		this.id = id;
		this.order = order;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idOrder", column = @Column(name = "id_order", nullable = false)),
			@AttributeOverride(name = "idCategory", column = @Column(name = "id_category", nullable = false)),
			@AttributeOverride(name = "quantity", column = @Column(name = "quantity", nullable = false)),
			@AttributeOverride(name = "subTotal", column = @Column(name = "sub_total", nullable = false, precision = 12, scale = 0)) })
	public OrderDetailId getId() {
		return this.id;
	}

	public void setId(OrderDetailId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order", nullable = false, insertable = false, updatable = false)
	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}