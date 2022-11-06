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
public class ProductDescriptionDTO implements Serializable{
    private String productID;
    private String weight;
    private String type;
    private String specific;
    private String smell;
    private String preserve;

    public ProductDescriptionDTO() {
    }

    public ProductDescriptionDTO(String productID, String weight, String type, String specific, String smell, String preserve) {
        this.productID = productID;
        this.weight = weight;
        this.type = type;
        this.specific = specific;
        this.smell = smell;
        this.preserve = preserve;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecific() {
        return specific;
    }

    public void setSpecific(String specific) {
        this.specific = specific;
    }

    public String getSmell() {
        return smell;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }

    public String getPreserve() {
        return preserve;
    }

    public void setPreserve(String preserve) {
        this.preserve = preserve;
    }

   
}
