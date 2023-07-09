package com.dds.notesbox.models.users;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
public class CartItemKey implements Serializable {
    @Column(name = "product_id")
    @Getter
    @Setter
    Long productId;

    @Column(name = "cart_id")
    @Getter @Setter
    Long cartId;

    public CartItemKey(Long productId, Long cartId) {
        this.productId = productId;
        this.cartId = cartId;
    }

    public CartItemKey(){}
}
