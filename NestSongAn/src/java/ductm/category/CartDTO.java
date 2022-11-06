/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author ACER
 */
public class CartDTO {
    private HashMap<Integer, Item> list = null;
    
    public CartDTO() {
        list = new HashMap<Integer, Item>();
    }
    public void setCart(HashMap<Integer, Item> lst)
    {
        this.list = lst;
    }
    public void add(Item item){
        Item getlst = list.get(new Integer(item.getID()));
        if(getlst != null){
            int quantity = item.getQuantity() + getlst.getQuantity();
            getlst.setQuantity(quantity);   
        }else{
            getlst = item;
            
        }
        list.put(new Integer(item.getID()), getlst);    
    }
    public boolean Update(int id, int quantity){
        boolean result = false;     
        Item getlst = list.get(id);
        if(getlst != null){
            result = true;
            if(quantity == 0){
                result = deleteProduct(id);
            }else{
            getlst.setQuantity(quantity);
            list.put(id, getlst);
            }
        }
        return result;
    }
    
    //Define the list property
    public HashMap<Integer, Item> getList() {
        return list;
    }        
    public boolean deleteProduct(int id){
        boolean result = false;
        Item item = list.get(id);
        if(item != null){
            result = true;
            list.remove(id);
        }
        return result;
    }
    public void empty(){
        list.clear();
    }
 
}
