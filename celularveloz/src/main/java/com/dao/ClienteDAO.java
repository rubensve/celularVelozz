package com.dao;

import com.conexion.Conexion;
import com.pojo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO implements DAO <Cliente> {

    Conexion conexion = Conexion.getConexion();
    private static final String SQL_CREATE= "insert into clientes (nombre,apellido,direccion,telefono) "
            + "values(?,?,?,?)";
    private static final String SQL_READI= "select * from clientes where id_cliente= ?";
    private static final String SQL_READ= "select * from clientes where nombre= ?";
    private static final String SQL_READALL= "select * from clientes";
    private static final String SQL_UPDATE= "update clientes set nombre=?, apellido=?, direccion=?, telefono=? where id_cliente=?";
    private static final String SQL_DELETE= "delete from clientes where id_cliente=?";
    
    @Override
    public boolean create(Cliente c) {
        PreparedStatement ps;
        try {
            
            ps = conexion.getCc().prepareStatement(SQL_CREATE);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getTelefono());
            
            if (ps.executeUpdate()>0)
            {    
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexion.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Cliente c) {
        PreparedStatement ps;
        try {
            ps = conexion.getCc().prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getTelefono());
            ps.setInt(5, c.getId());
            
            if (ps.executeUpdate()>0)
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            ps.setString(1,key.toString() );
            
            if (ps.executeUpdate()>0)
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
        conexion.cerrarConexion();
                 }
    return false;
    }

    @Override
    public ArrayList<Cliente> read(Object key) {
        ArrayList<Cliente> c= new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.getCc().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            rs= ps.executeQuery();
            while (rs.next())
            {
                c.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public ArrayList<Cliente> readAll() {
        PreparedStatement ps;
        ArrayList<Cliente> clientes = new ArrayList();
        ResultSet rs;
        try {
            ps = conexion.getCc().prepareStatement(SQL_READALL); 
            rs = ps.executeQuery();
            
            while (rs.next())
            {
                clientes.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexion.cerrarConexion();
        }
         return clientes;
    } 
    
     public Cliente readi(int id) {
        PreparedStatement ps;
            Cliente c= null;
            ResultSet rs;
        try {
            ps = conexion.getCc().prepareStatement(SQL_READI);
            ps.setInt(1, id);
            rs= ps.executeQuery();
            while (rs.next())
            {
                c= new Cliente(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));    
            }
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexion.cerrarConexion();
        }
        return c;   
    }

}
