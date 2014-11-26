package com.dao;

import com.conexion.Conexion;
import com.pojo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO implements DAO<Usuario> {
    
    private static final String SQL_CREATE= "insert into usuarios (login,password,nombre,apellido,rol) "
            + "values(?,?,?,?,?)";
    private static final String SQL_READ= "select * from usuarios where login= ?";
    private static final String SQL_READALL= "select * from usuarios";
    private static final String SQL_UPDATE= "update usuarios set password=?, nombre=?, apellido=?, rol=? where login=?";
    private static final String SQL_DELETE= "delete from usuarios where login=?";
    
    Conexion conexion= Conexion.getConexion();

    @Override
    public boolean create(Usuario u) {
        PreparedStatement ps;
        try {    
            ps = conexion.getCc().prepareStatement(SQL_CREATE);
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getNombre());
            ps.setString(4, u.getApellido());
            ps.setString(5, u.getRol());
            
            if (ps.executeUpdate()>0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        
        return false;

    }

    @Override
    public boolean update(Usuario u) {
        PreparedStatement ps;
        try {    
            ps = conexion.getCc().prepareStatement(SQL_UPDATE);
            ps.setString(1, u.getPassword());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellido());
            ps.setString(4, u.getRol());
            ps.setString(5, u.getLogin());
            
            if (ps.executeUpdate()>0)
            {   
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            conexion.cerrarConexion();
        }

        return false;
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try {          
            ps = conexion.getCc().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            
            if (ps.executeUpdate()>0)
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexion.cerrarConexion();
        }
        return false;
    }

    @Override
    public ArrayList<Usuario> read(Object key) {
        PreparedStatement ps;
           ArrayList <Usuario> u= new ArrayList();
            ResultSet rs;
        try {
            ps = conexion.getCc().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            rs= ps.executeQuery();
            while (rs.next())
            {
                u.add(new Usuario(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));    
            }
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexion.cerrarConexion();
        }
        return u;   
    }

    @Override
    public ArrayList<Usuario> readAll() {
        
            PreparedStatement ps;
            ArrayList<Usuario> usuarios =  new ArrayList();
            ResultSet rs;
        
            try {
            
            ps = conexion.getCc().prepareStatement(SQL_READALL);
            
            rs = ps.executeQuery();
            
            while (rs.next())
            {       
                usuarios.add(new Usuario(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                conexion.cerrarConexion();
            }
        return usuarios;
    }
    
    public Usuario login(Object key) {
        PreparedStatement ps;
            Usuario u= null;
            ResultSet rs;
        try {
            ps = conexion.getCc().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            rs= ps.executeQuery();
            while (rs.next())
            {
                u= new Usuario(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));    
            }
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conexion.cerrarConexion();
        }
        return u;   
    }
    
}
