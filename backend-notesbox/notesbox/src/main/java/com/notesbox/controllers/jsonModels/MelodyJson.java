package com.notesbox.controllers.jsonModels;

import com.notesbox.models.products.Melody;

public class MelodyJson {
  private long id;
  private String name;
  private String description;
  private double price;
  private double discountPrice;
  private boolean isOnSale;
  private CategoryJson category;

  public MelodyJson(Melody melody) {
    this.id = melody.getId();
    this.name = melody.getName();
    this.description = melody.getDescription();
    this.price = melody.getPrice();
    this.isOnSale = melody.hasDiscountPrice();
    if (this.isOnSale) {
      this.discountPrice = melody.getDiscountPrice();
    }
    this.category = new CategoryJson(melody.getCategory());

  }


  /*
   *   public Melody(String name, String description, double price, double discountPrice, Category category) {
    super(name, description, price, discountPrice);
   */
}
