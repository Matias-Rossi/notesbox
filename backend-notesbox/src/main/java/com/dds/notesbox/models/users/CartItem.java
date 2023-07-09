package com.dds.notesbox.models.users;

import com.dds.notesbox.models.products.Product;
import com.dds.notesbox.models.products.ProductSpecialCollectionKey;
import com.dds.notesbox.models.products.SpecialCollection;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class CartItem {

    @EmbeddedId
    private CartItemKey key;

    @Column(name = "product_quantity")
    @Getter @Setter
    private int productQuantity;

    @ManyToOne
    @Getter
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne @Getter
    @MapsId("specialCollectionId")
    @JoinColumn(name = "cart_id")
    private Cart cart;


    public CartItem(Product product, Cart cart, int qty){
        this.key = new CartItemKey(product.getId(), cart.getId());
        this.cart = cart;
        this.product = product;
        this.productQuantity = qty;
    }

    public CartItem(){}
}
