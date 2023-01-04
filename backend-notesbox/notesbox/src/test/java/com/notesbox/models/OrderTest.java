package com.notesbox.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.notesbox.models.orders.Order;
import com.notesbox.models.orders.OrderProduct;
import com.notesbox.models.orders.OrderStatus;
import com.notesbox.models.products.Manufacturer;
import com.notesbox.models.products.Product;
import com.notesbox.models.users.Address;
import com.notesbox.models.users.Customer;

public class OrderTest {
  @Test
  @DisplayName("Go through order states")
  public void order_states() {
    Address a = new Address("road", "123", "city", "province", "country", null, null);
    Customer customer = new Customer("customerName", "123", "123@abc.def", a);
    Manufacturer manufacturer = new Manufacturer("Manufacturer", "+12345678");
    List<Product> products = new ArrayList<Product>();
    Product product1 = new Product("name", "description", 59);
    Product product2 = new Product("name", "description", 59);
    products.add(product1);
    products.add(product2);
    
    System.out.println(customer);
    System.out.println(products);

    Order order = new Order(customer, products);
    order.addManufacturerPart("AC Transformer", manufacturer);
    order.manufacturerParts.get(0).markAsDelivered(null);
    order.changeStatus(null, OrderStatus.DELIVERED);
    assertEquals(order.getOrderStatus(), OrderStatus.DELIVERED);
  }
}
