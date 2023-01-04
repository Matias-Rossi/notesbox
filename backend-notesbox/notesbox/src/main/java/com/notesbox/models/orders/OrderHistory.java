package com.notesbox.models.orders;

import java.time.LocalDate;

import javax.persistence.*;

import com.notesbox.models.PersistentEntity;
import com.notesbox.models.users.Admin;

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
  private Admin changedBy;

  public OrderHistory(Order order, OrderStatus fromStatus, OrderStatus toStatus, LocalDate date, Admin changedBy) {
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
  
}
