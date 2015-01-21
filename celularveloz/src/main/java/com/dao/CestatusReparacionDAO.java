
package com.dao;

import com.conexion.Conexion;
import com.pojo.CestatusReparacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CestatusReparacionDAO {
    
    Conexion conexion= Conexion.getConexion();
    private static String BUSQUEDA= "Select * from cestatusreparacion where id_estatusreparacion=?";
    
    public CestatusReparacion busquedas(int id_estatusreparacion)
    {
        PreparedStatement ps;
            ResultSet rs;
            CestatusReparacion cer= null;
        try {
            ps= conexion.getCc().prepareStatement(BUSQUEDA);
            ps.setInt(1, id_estatusreparacion);
            rs = ps.executeQuery();
            while (rs.next()) 
            {                
               cer= new CestatusReparacion(rs.getString(2));
            }
            return cer;
        } catch (SQLException ex) {
            Logger.getLogger(CestatusReparacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            conexion.cerrarConexion();
        }
        return cer;
    }
}
