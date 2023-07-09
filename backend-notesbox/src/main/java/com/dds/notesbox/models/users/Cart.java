package com.dds.notesbox.models.users;

import com.dds.notesbox.models.PersistentEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart extends PersistentEntity {

    @OneToOne
    private Customer customer;

    @Getter
    @OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "cart_id")
    private List<CartItem> cartItems = new ArrayList<CartItem>();
}
