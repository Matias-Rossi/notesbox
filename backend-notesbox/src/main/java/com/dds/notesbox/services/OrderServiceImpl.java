package com.dds.notesbox.services;

import com.dds.notesbox.models.orders.*;
import com.dds.notesbox.models.products.Product;
import com.dds.notesbox.models.users.Address;
import com.dds.notesbox.models.users.Admin;
import com.dds.notesbox.models.users.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductService productService;

    @Override
    public Order createOrder(Customer customer, Address shippingAddress) {
        return new Order(customer, shippingAddress);
    }

    @Override
    public void changeOrderStatus(Order order, OrderStatus newStatus, LocalDate changeDate, Optional<Admin> adminOptional) {
        order.changeStatus(newStatus, changeDate, adminOptional);
    }

    @Override
    public void addManufacturerPartToOrder(Order order, ManufacturerPart manufacturerPart) {
        order.addManufacturerPart(manufacturerPart);
    }

    @Override
    public void addProductToOrder(Order order, Product product, int quantity) {
        double price = productService.getActualPrice(product);
        OrderProduct op = new OrderProduct(order, product, price, quantity);
        order.addOrderProduct(op);
    }
}
