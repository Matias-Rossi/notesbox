package com.dds.notesbox.models.orders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dds.notesbox.models.PersistentEntity;
import com.dds.notesbox.models.products.Manufacturer;
import com.dds.notesbox.models.products.Product;
import com.dds.notesbox.models.users.Address;
import com.dds.notesbox.models.users.Admin;
import com.dds.notesbox.models.users.Customer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
  @Column(name = "status")
  @Getter
  private OrderStatus orderStatus = OrderStatus.NEW;

  @OneToMany(cascade = CascadeType.ALL)
  private List<OrderHistory> orderHistory = new ArrayList<OrderHistory>();

  @Column
  double totalPrice = 0;


  public Order(Customer customer, Address shippingAddress) {
    this.customer = customer;
    this.shippingAddress = shippingAddress;
  }

   public void changeStatus(OrderStatus newStatus, LocalDate date, Optional<Admin> adminOptional) {
     OrderHistory oh = new OrderHistory(
             this, orderStatus, newStatus, date, adminOptional.orElse(null)
     );
      this.orderHistory.add(oh);
      orderStatus = newStatus;
   }

   //TODO: method to remove?
  public void addManufacturerPart(ManufacturerPart mp) {
    this.manufacturerParts.add(mp);
  }

  public void addOrderProduct(OrderProduct op) {
    products.add(op);
    totalPrice += op.getPrice() * op.getQuantity();
  }

  public Order(){}


  
}
