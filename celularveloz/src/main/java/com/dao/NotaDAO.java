
package com.dao;

import com.conexion.Conexion;
import com.pojo.Cliente;
import com.pojo.Nota;
import com.pojo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NotaDAO implements DAO <Nota>{
    
    Conexion conexion = Conexion.getConexion();
    
    private static final String SQL_CREATE= "INSERT INTO notas (folio, fecharecepcion, fechaentrega, login, id_cliente, imei, total, anticipo, resto,observaciones,modelo)" +
                                        " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_READULTIMOF = "Select * from notas order by folio desc limit 1" ;
    private static final String SQL_READ= "select * from notas where folio= ?";
    private static final String SQL_READALL= "select * from notas";
    private static final String SQL_UPDATE= "update notas set estatusnota=?, estatusreparacion=?"
            + " where folio=?";
    private static final String SQL_DELETE= "delete from notas where folio=?";

    
    @Override
    public boolean create(Nota n) 
    {
        PreparedStatement ps;
        
        try {
            ps = conexion.getCc().prepareStatement(SQL_CREATE);
            ps.setInt(1, n.getFolio());
            ps.setString(2, n.getFecharecibido());
            ps.setString(3, n.getFechaentrega());
            ps.setString(4, n.getU().getLogin());
            ps.setInt(5, n.getE().getId());
            ps.setString(6, n.getImei());
            ps.setDouble(7, n.getTotal());
            ps.setDouble(8, n.getAnticipo());
            ps.setDouble(9, n.getResta());
            ps.setString(10, n.getObservaciones());
            ps.setString(11, n.getModelo());
            if (ps.executeUpdate()>0)
            {
                return true;
            }  
        } catch (SQLException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            conexion.cerrarConexion();
        }
     return false;
    }
    
    public Nota readUltimo() {
            PreparedStatement ps;
            ResultSet rs;
            Nota nota = null;
        try {
            ps= conexion.getCc().prepareStatement(SQL_READULTIMOF);
            rs= ps.executeQuery();
            while (rs.next())
            {
               nota = new Nota(rs.getInt("folio"), rs.getString(2), rs.getString(3), rs.getString(4),
               rs.getInt(5), rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), 
               rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
            }
            return nota;
        } catch (SQLException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexion.cerrarConexion();
        }
        return nota;
    }

      public Nota readi(Object key) {
            PreparedStatement ps;
            ResultSet rs;
            Nota nota = null;
        try {
            ps= conexion.getCc().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            rs= ps.executeQuery();
            while (rs.next())
            {
               nota = new Nota(rs.getInt("folio"), rs.getString(2), rs.getString(3), rs.getString(4),
               rs.getInt(5), rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), 
               rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
            }
            return nota;
        } catch (SQLException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexion.cerrarConexion();
        }
        return nota;
    }
    
    
    @Override
    public boolean update(Nota n) 
    {
        PreparedStatement ps;
        try {
           
            ps =conexion.getCc().prepareStatement(SQL_UPDATE);
            
            ps.setString(1, n.getEstatusNota());
            ps.setString(2, n.getEstatusReparacion());
            ps.setInt(3, n.getFolio());
            
            if (ps.executeUpdate()>0)
            {    
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexion.cerrarConexion();
        }
        return false;
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
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    
                }

    @Override
    public ArrayList<Nota> read(Object key) {
       /* PreparedStatement ps;
            ArrayList<Nota> n= new ArrayList();
            ResultSet rs;
        try {
            ps= conexion.getCc().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            rs= ps.executeQuery();
            while (rs.next())
            {
                n.add(new Nota(rs.getInt(1), new Usuario(rs.getString(3)), new Cliente(rs.getInt(4)), rs.getString(6),
                        rs.getString(7), rs.getDouble(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexion.cerrarConexion();
        }*/
        return null;
    }

    @Override
    public ArrayList<Nota> readAll() {
       /*    PreparedStatement ps;
            ArrayList<Nota> notas =  new ArrayList();
            ResultSet rs;
        try {
            ps = conexion.getCc().prepareStatement(SQL_READALL);
            rs= ps.executeQuery();
            
            while (rs.next())
            {
                notas.add(new Nota(rs.getInt(1), new Usuario(rs.getString(3)), new Cliente(rs.getInt(4)), rs.getString(6),
                        rs.getString(7), rs.getDouble(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            conexion.cerrarConexion();
        }*/
        return null;
    }  
    
}
