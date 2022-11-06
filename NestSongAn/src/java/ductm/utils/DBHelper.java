/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

/**
 *
 * @author minhd
 */
public class DBHelper implements Serializable{
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection conn= null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url= "jdbc:sqlserver://localhost:1433;databaseName=NestSongAn";
        conn= DriverManager.getConnection(url, "sa", "123456789");
        return conn;
    }
}

   
//    public static void getSiteMaps(ServletContext context) throws IOException{
//        String siteMapsFile = context.getInitParameter("SITEMAPS_FILE_PATH");
//        InputStream is = null;
//        Properties siteMaps = null;
//        try{
//            is = context.getResourceAsStream(siteMapsFile);
//            siteMaps = new Properties();
//            siteMaps.load(is);
//            
//            context.setAttribute("SITEMAP", siteMaps);
//        }finally{
//                if( is != null){
//                    is.close();
//                }
//                
//        }
//    }
//}
