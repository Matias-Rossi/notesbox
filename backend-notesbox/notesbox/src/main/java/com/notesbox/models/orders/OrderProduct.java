package com.notesbox.models.orders;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

import com.notesbox.models.products.Product;

@Entity
@Table(name = "products_by_order")
public class OrderProduct {
  @ManyToOne(cascade = CascadeType.PERSIST)
  @PrimaryKeyJoinColumn
  private Order order;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @PrimaryKeyJoinColumn
  private Product product;

  @Column
  private double price;

  @Column
  private int quantity;

  public OrderProduct(Order order, Product product, double price, int quantity) {
    this.order = order;
    this.product = product;
    this.price = price;
    this.quantity = quantity;
  }
}
