package com.notesbox.models.users;

import com.notesbox.models.orders.Order;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;

@Entity
public class Customer extends User {

    @Getter
    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Address shippingAddress;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "customer")
    private List<Order> orders = new ArrayList<Order>();

    public Customer(String name, String nonHashedPassword, String email, Address shippingAddress, List<Order> orders) {
        super(name, nonHashedPassword, email);
        this.shippingAddress = shippingAddress;
        this.orders = orders;
    }

    public Customer(String name, String nonHashedPassword, String email, Address shippingAddress) {
        super(name, nonHashedPassword, email);
        this.shippingAddress = shippingAddress;
    }
}
