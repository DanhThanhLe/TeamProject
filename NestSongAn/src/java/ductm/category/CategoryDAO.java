/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.category;

import ductm.product.ProductDTO;
import ductm.utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minhd
 */
public class CategoryDAO {
    public List<CategoryDTO> getAllCategory() throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<CategoryDTO> list = new ArrayList<>();
       try {
            conn = DBHelper.getConnection();
            if(conn != null){
        String sql = "Select * "
                + "From tblCategory";
            
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int cid = rs.getInt("CategoryID");
                String cname = rs.getString("CategoryName");
                CategoryDTO dto = new CategoryDTO(cid, cname);
                list.add(dto);
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
                stm.close();
            }
        }
        return list;
    }
}
