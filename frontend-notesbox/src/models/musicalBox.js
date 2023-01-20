import { isEmpty } from "~/shared/utils/utils.js";

export default class MusicalBox {
    id;
    displayName;
    price;
    discountPrice;
    hasDiscountPrice;
    categoryDisplayName;
  
    constructor(id, displayName, price, discountPrice, categoryDisplayName) {
        this.id = id;
        this.displayName = displayName;
        this.price = price;
        this.discountPrice = discountPrice;
        this.hasDiscountPrice = discountPrice !== null && discountPrice !== undefined;
        this.categoryDisplayName = categoryDisplayName;
    }

    static fromProduct(product) {
        //console.log(product);
        return new MusicalBox(
            product["id"],
            product["name"],
            product["price"],
            product["discountPrice"],
            product["categoryName"]
        ); 
    }

    static listFromSpecialCollection(specialCollection) {
        console.log("bbb")
        console.log(specialCollection)
        if(specialCollection["name"] == "Loading..." || specialCollection == undefined || isEmpty(specialCollection))
            return [];
        // console.log(specialCollection.len);
        // if(specialCollection.len == undefined) 
        //     return [];
        let scList = specialCollection["products"];
        // console.log("scList ⬇")
        // console.log(scList)
        let products = scList.map(elem => MusicalBox.fromProduct(elem));
        return products;
    }
  }
  