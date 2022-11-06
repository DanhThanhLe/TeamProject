/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.category;

import ductm.product.ProductDTO;

/**
 *
 * @author minhd
 */
public class Item {
   private String id; //tham chiếu tới productID
    private ProductDTO product;
    private int quantity; //số lượng item cho vào trong cart 
    private String name;

    public Item() {
        super();
    }

    public Item(String id, ProductDTO product, int quantity, String name) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.name = name;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
