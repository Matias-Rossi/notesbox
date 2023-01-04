export default class MusicalBox {
    id;
    displayName;
    price;
    discountPrice;
    categoryDisplayName;
  
    constructor(id, displayName, price, discountPrice, categoryDisplayName) {
        this.id = id;
        this.displayName = displayName;
        this.price = price;
        this.discountPrice = discountPrice;
        this.categoryDisplayName = categoryDisplayName;
    }
  }
  