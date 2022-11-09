/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.account;

import ductm.utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author HP
 */
public class AccountDAO {
    
    private static final String LOGIN = " SELECT UserName, Password, Role FROM Account WHERE UserName = ? AND Password =?";
    private static final String SEARCH = " SELECT UserName, FullName, Role FROM Account WHERE FullName like ? ";
    //private static final String DELETE = " UPDATE tblUsers SET status = ? WHERE userID = ? ";
    private static final String UPDATE = " UPDATE Account SET FullName = ? , Role = ? WHERE UserName = ? ";
    private static final String USER_INFOR = " SELECT FullName, Mail, PhoneNumber, Role FROM tblUsers WHERE UserName = ? ";
    private static final String CHECK_DUPLICATE = " SELECT UserName FROM tblUsers WHERE UserName = ? ";
    private static final String INSERT = " INSERT INTO Account( UserName, FullName, Role, Password, Phone, Mail) VALUES(?,?,?,?,?,?) ";

   
    
     public AccountDTO checkLogin(String username, String password)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        AccountDTO result = null;
        try {
            //1. Make connection
            connection = DBHelper.getConnection();
            if (connection != null) {
                //2. Create SQL String
                String sql = "Select UserName, Role "
                        + "From Account "
                        + "Where UserName = ? And Password = ?";
                //3.Create Statement Object
                stm = connection.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4.Execute Query
                rs = stm.executeQuery();
                //5.Proccess result
                if (rs.next()) {
                    String fullName = rs.getString("FullName");
                    String role = rs.getString("Role");
                    result = new AccountDTO(username, password, fullName, role);
                    
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }
    public List<AccountDTO> getListUser(String search) throws SQLException {
        List<AccountDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(SEARCH);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String password = "***";
                    boolean status = rs.getBoolean("status");
                    list.add(new AccountDTO(roleID, fullName, password, fullName, LOGIN, roleID, UPDATE));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return list;
    }
    
   
    
    public boolean updateUser(AccountDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBHelper.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(UPDATE);
                stm.setString(1, user.getFullName());
                stm.setString(2, user.getRole());
                stm.setString(3, user.getUsername());
                check = stm.executeUpdate()>0?true:false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) stm.close();
            if (conn != null) conn.close();
        }
        return check;
    }
    
    public AccountDTO getUserInfor(String userID) throws SQLException {
        AccountDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(USER_INFOR);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    boolean status = rs.getBoolean("status");
                    user = new AccountDTO(roleID, fullName, userID, fullName, LOGIN, roleID, UPDATE);
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }
    
    public boolean insert(AccountDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBHelper.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(INSERT);
                stm.setString(1, user.getUsername());
                stm.setString(2, user.getFullName());
                stm.setString(3, user.getRole());
                stm.setString(4, user.getPassword());
                
                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) stm.close();
            if (conn != null) conn.close();
        }
        return check;
    }
    
}
