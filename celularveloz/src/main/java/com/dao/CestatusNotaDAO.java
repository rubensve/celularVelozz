/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.pojo.CestatusNota;
import com.pojo.CestatusReparacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rubens
 */
public class CestatusNotaDAO {
    Conexion conexion= Conexion.getConexion();
    private static String BUSQUEDA= "select * from cestatusnota where id_estatusnota=?";
    
    public CestatusNota busquedas(int id_estatusnota)
    {
        PreparedStatement ps;
            ResultSet rs;
            CestatusNota cen= null;
        try {
            ps= conexion.getCc().prepareStatement(BUSQUEDA);
            ps.setInt(1, id_estatusnota);
            rs = ps.executeQuery();
            while (rs.next()) 
            {                
               cen= new CestatusNota(rs.getString(2));
            }
            return cen;
        } catch (SQLException ex) {
            Logger.getLogger(CestatusNotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            conexion.cerrarConexion();
        }
        return cen;
    }
}
