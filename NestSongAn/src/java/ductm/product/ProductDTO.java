/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.product;

import java.io.Serializable;

/**
 *
 * @author minhd
 */
public class ProductDTO implements Serializable{
    private String productID;
    private String productName;
    private String categoryID;
    private float price;
    private String unit;
    private String productImage;

    public ProductDTO(String productID, String productName, String categoryID, float price, String unit, String productImage) {
        this.productID = productID;
        this.productName = productName;
        this.categoryID = categoryID;
        this.price = price;
        this.unit = unit;
        this.productImage = productImage;
    }

    public ProductDTO(String productName, float price) {
        this.productName = productName;
        this.price = price;
    }
    

    public ProductDTO() {
    }


    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    
}
