package com.dds.notesbox.services;

import com.dds.notesbox.models.orders.Order;
import com.dds.notesbox.models.products.Product;
import com.dds.notesbox.models.users.Cart;

public interface CartService {
    public void emptyCart(Cart cart);

    public void addProductToCart(Cart cart, Product product, int qty);

    public void removeProductFromCart(Cart cart, Product product);

    public void editProductFromCart(Cart cart, Product product, int newQty);

    public Order createOrderFromCart(Cart cart);
}
