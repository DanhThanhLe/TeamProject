/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.order;

import ductm.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author minhd
 */
public class OrderDetailDAO implements Serializable{
    
public static void addOrderDetail( int orderID, String productID, int quantity, float price) throws SQLException{
         Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = DBHelper.getConnection();
            String sql ="INSERT tblOrderDetails(OrderID, ProductID, Quantity, Price) "
                    + "VALUES(?, ?, ?, ?)";
                    stm = conn.prepareStatement(sql);
                stm.setInt(1, orderID);
                stm.setString(2, productID);
                stm.setInt(3, quantity);
                stm.setFloat(4, price);
                stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally{
            }if (stm != null){
                stm.close();
            }if(conn != null){
            conn.close();
        }
        }
    }
