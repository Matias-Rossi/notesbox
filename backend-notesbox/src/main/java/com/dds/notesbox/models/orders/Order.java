package com.dds.notesbox.models.orders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dds.notesbox.models.PersistentEntity;
import com.dds.notesbox.models.products.Manufacturer;
import com.dds.notesbox.models.products.Product;
import com.dds.notesbox.models.users.Address;
import com.dds.notesbox.models.users.Admin;
import com.dds.notesbox.models.users.Customer;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "orders")
public class Order extends PersistentEntity {
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipping_address")
  private Address shippingAddress;

  @OneToMany(cascade = CascadeType.ALL)
  private List<OrderProduct> products;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
  public List<ManufacturerPart> manufacturerParts;

  @Enumerated(EnumType.STRING)
  @Column(name = "status") @Getter
  private OrderStatus orderStatus = OrderStatus.NEW;

  @OneToMany(cascade = CascadeType.ALL)
  private List<OrderHistory> orderHistory = new ArrayList<OrderHistory>();

  @Column
  double totalPrice = 0;


  public Order(Customer customer, Address shippingAddress, List<OrderProduct> products, List<ManufacturerPart> manufacturerParts) {
    this.customer = customer;
    this.shippingAddress = shippingAddress;
    this.products = products;
    this.manufacturerParts = manufacturerParts;
    this.orderStatus = OrderStatus.NEW;
  }

  public Order(Customer customer, List<Product> products) {
    this.customer = customer;
    this.shippingAddress = customer.getShippingAddress();
    this.manufacturerParts = new ArrayList<ManufacturerPart>();
    this.orderStatus = OrderStatus.NEW;
    this.changeStatusSystem(OrderStatus.MANUFACTURER_ASSIGNMENT_PENDING);
  }

  public void changeStatus(Admin admin, OrderStatus toStatus) {
    //TODO: validate parts delivered on frontend
    OrderHistory orderHistory = new OrderHistory(this, this.orderStatus, toStatus, LocalDate.now(), admin);
    this.orderHistory.add(orderHistory);
    this.orderStatus = toStatus;
  }

  public void changeStatusSystem(OrderStatus toStatus) {
    //Status changed automatically (or by unknown admin)
    OrderHistory orderHistory = new OrderHistory(this, this.orderStatus, toStatus, LocalDate.now());
    this.orderHistory.add(orderHistory);
    this.orderStatus = toStatus;
  }

  public void addManufacturerPart(String partName, Manufacturer manufacturer) {
    ManufacturerPart mp = new ManufacturerPart(this, partName, manufacturer);
    this.manufacturerParts.add(mp);
  }

  public void addProduct(Product product, int quantity) {
    OrderProduct op = new OrderProduct(this, product, product.getPrice(), quantity);
    totalPrice += product.getPrice() * quantity;
  }

  public Order(){}


  
}
