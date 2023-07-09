package com.dds.notesbox.models.users;

import com.dds.notesbox.models.PersistentEntity;
import com.dds.notesbox.models.products.Product;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart extends PersistentEntity {

    @OneToOne
    @Getter
    private Customer customer;

    @OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "cart")
    @Getter
    private List<CartItem> cartItems = new ArrayList<CartItem>();
    //TODO: use set?

    public void addItemToCart(CartItem item) {
        cartItems.add(item);
    }

    public void removeProductFromCart(Product product) {
        cartItems.removeIf(i -> i.getProduct().getId() == product.getId());
    }

    public void replaceItemFromCart(int index, CartItem newItem) {
        cartItems.set(index, newItem);
    }
}
