package com.dds.notesbox.services;

import com.dds.notesbox.models.orders.Order;
import com.dds.notesbox.models.orders.OrderProduct;
import com.dds.notesbox.models.products.Product;
import com.dds.notesbox.models.users.Cart;
import com.dds.notesbox.models.users.CartItem;
import com.dds.notesbox.models.users.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ProductService productService;

    @Override
    public void emptyCart(Cart cart) {
        cart.getCartItems().clear();
    }

    @Override
    public void addProductToCart(Cart cart, Product product, int qty) {
        CartItem newCartItem = new CartItem(product, cart, qty);
        cart.addItemToCart(newCartItem);
    }

    @Override
    public void removeProductFromCart(Cart cart, Product product) {
        cart.removeProductFromCart(product);
    }

    @Override
    public void editProductFromCart(Cart cart, Product product, int newQty) {
        int index = -1;
        List<CartItem> cartItems = cart.getCartItems();
        for (int i=0; i < cartItems.size(); i++) {
            if(cartItems.get(i).getProduct().getId() == product.getId()) {
                index = i;
                break;
            }
        }
        if (index > 0) {
            CartItem newCartItem = new CartItem(product, cart, newQty);
            cart.replaceItemFromCart(index, newCartItem);
        }
    }

    @Override
    public Order createOrderFromCart(Cart cart) {
        Customer customer = cart.getCustomer();
        Order order = new Order(customer, customer.getShippingAddress());
        for ( CartItem cartItem : cart.getCartItems()) {
            OrderProduct op = new OrderProduct(
                    order,
                    cartItem.getProduct(),
                    productService.getActualPrice(cartItem.getProduct()),
                    cartItem.getProductQuantity()
            );
            order.addOrderProduct(op);
        }

        return order;
    }
}
