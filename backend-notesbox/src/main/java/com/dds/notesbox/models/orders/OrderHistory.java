package com.dds.notesbox.models.orders;

import java.time.LocalDate;

import jakarta.persistence.*;

import com.dds.notesbox.models.PersistentEntity;
import com.dds.notesbox.models.users.User;

@Entity
@Table(name = "order_status_history")
public class OrderHistory extends PersistentEntity{

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "order_id")
  private Order order;
  
  @Column(name = "from") @Enumerated
  private OrderStatus fromStatus;

  @Column(name = "to") @Enumerated
  private OrderStatus toStatus;

  @Column //TODO add converter
  private LocalDate date;

  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name="changed_by", nullable = true)
  private User changedBy;

  public OrderHistory(Order order, OrderStatus fromStatus, OrderStatus toStatus, LocalDate date, User changedBy) {
    this.order = order;
    this.fromStatus = fromStatus;
    this.toStatus = toStatus;
    this.date = date;
    this.changedBy = changedBy;
  }

  public OrderHistory(Order order, OrderStatus fromStatus, OrderStatus toStatus, LocalDate date) {
    this.order = order;
    this.fromStatus = fromStatus;
    this.toStatus = toStatus;
    this.date = date;
  }

  public OrderHistory(){}
  
}
