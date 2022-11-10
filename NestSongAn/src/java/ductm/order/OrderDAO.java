/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.order;

import ductm.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author minhd
 */
public class OrderDAO implements Serializable{
    public static void addOrder(String name, String mail, String phone, Date orderDate, String address, String total) throws SQLException{
         Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = DBHelper.getConnection();
            String sql ="INSERT tblOrders(CustomerName, CustomerEmail, CustomerPhoneNumber, CustomerAddress, OrderDate, Total) "
                    + "VALUES(?, ?, ?, ?, ?, ? COLLATE Latin1_General_CS_AS )";
                    stm = conn.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, mail);
                stm.setString(3, phone);
                stm.setString(4, address);
                stm.setDate(5, orderDate);
                stm.setString(6, total);
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
    public int getLastOrderID() throws NamingException, SQLException, ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            if (conn != null){
                String sql = "Select top 1 OrderID "
                        + "From tblOrders "
                        + "Order By OrderID Desc";
                        
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if(rs.next()){
                    return rs.getInt("OrderID");
                }
                
            }
        }finally{
            if ( rs != null){
                rs.close();
            }
            if ( stm !=null){
                stm.close();
            }
            if ( conn != null){
                conn.close();
            }
        }
        return 0;
        
    }
}
    

