package com.dao;

import com.conexion.Conexion;
import com.pojo.Articulo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticuloDAO implements DAO<Articulo> {

    private final String SQL_CREATE= "insert into articulosnota (folio, cantidad, descripcion, precio) "
            + "values(?,?,?,?) ";
    private final String SQL_READ= "select * from articulosnota where folio = ? ";
    private final String SQL_DELETE= "delete from articulosnota where folio = ? ";
    
  
    Conexion conexion= Conexion.getConexion();
    
    
    @Override
    public boolean create(Articulo a) {
        PreparedStatement ps;
        try {    
            ps = conexion.getCc().prepareStatement(SQL_CREATE);
            ps.setInt(1, a.getNota().getFolio());
            ps.setInt(2, a.getCantidad());
            ps.setString(3, a.getDescripcion());
            ps.setDouble(4, a.getCosto());
            
            if (ps.executeUpdate()>0)
            {   
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Articulo a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object key) {
     PreparedStatement ps;
        try {    
            ps= conexion.getCc().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            
            if (ps.executeUpdate()>0) 
            {
             return true;   
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            conexion.cerrarConexion();
            }
        return false;
    }

    @Override
    public ArrayList<Articulo> read(Object key) {
        PreparedStatement ps;
        ArrayList<Articulo> art = new ArrayList();
        ResultSet rs;
        
        try {
            ps = conexion.getCc().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            rs = ps.executeQuery();
            
            while (rs.next()) 
            {                
              art.add(new Articulo(rs.getInt(2), rs.getString(3), rs.getDouble(4)));
            }
            
            return art;
            
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return art;
    }

    @Override
    public ArrayList<Articulo> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
