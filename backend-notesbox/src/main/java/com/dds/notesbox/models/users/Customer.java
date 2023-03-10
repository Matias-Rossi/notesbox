package com.dds.notesbox.models.users;

import com.dds.notesbox.models.orders.Order;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Entity
@DiscriminatorValue(value = "Customer")
public class Customer extends User {

    @Getter
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address shippingAddress;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "customer") @Getter
    private List<Order> orders = new ArrayList<Order>();

    public Customer(String name, String hashedPassword, String email, Address shippingAddress, List<Order> orders) {
        super(name, hashedPassword, email);
        setShippingAddress(shippingAddress);
        this.orders = orders;
    }

    public Customer(String name, String hashedPassword, String email, Address shippingAddress) {
        super(name, hashedPassword, email);
        setShippingAddress(shippingAddress);
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
        shippingAddress.setCustomer(this);
    }

    public Customer(){
        super();
    }
}
