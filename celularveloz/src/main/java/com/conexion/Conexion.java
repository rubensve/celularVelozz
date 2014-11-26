package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    public static Conexion conexion;
    private Connection cc;
    
     
    
    private Conexion(){
       /* String url = "jdbc:mysql://127.3.175.130:3306/celularveloz"; 
        String user = "adminvgCjIcy";
        String password = "DWAkVyU6_Ksf";*/
        try {
            Class.forName("com.mysql.jdbc.Driver");    
            cc= DriverManager.getConnection("jdbc:mysql://localhost:3306/CelularVeloz?zeroDateTimeBehavior=convertToNull","root","elmasmejor110789");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static synchronized Conexion getConexion(){
        if (conexion==null) 
        {
         conexion= new Conexion();   
        }
        return conexion;
    }

    public Connection getCc() {
        return cc;
    }
    
    public void cerrarConexion(){
        conexion=null;
    }
    
    
    
}
