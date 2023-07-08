package com.dds.notesbox.models.orders;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import com.dds.notesbox.models.products.Product;

@Entity
@Table(name = "products_by_order")
public class OrderProduct {
  @ManyToOne(cascade = CascadeType.PERSIST)
  @EmbeddedId
  @PrimaryKeyJoinColumn
  private Order order;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @EmbeddedId
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

  public OrderProduct(){}
}
