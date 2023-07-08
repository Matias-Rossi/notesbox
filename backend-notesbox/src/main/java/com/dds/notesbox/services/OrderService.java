package com.dds.notesbox.services;

import com.dds.notesbox.models.orders.ManufacturerPart;
import com.dds.notesbox.models.orders.Order;
import com.dds.notesbox.models.orders.OrderStatus;
import com.dds.notesbox.models.products.Product;
import com.dds.notesbox.models.users.Address;
import com.dds.notesbox.models.users.Admin;
import com.dds.notesbox.models.users.Customer;

import java.time.LocalDate;
import java.util.Optional;

public interface OrderService {

    public Order createOrder(Customer customer, Address shippingAddress);

    public void changeOrderStatus(Order order, OrderStatus status, LocalDate changeDate, Optional<Admin> adminOptional);

    public void addManufacturerPartToOrder(Order order, ManufacturerPart manufacturerPart);

    public void addProductToOrder(Order order, Product product, int quantity);
}
