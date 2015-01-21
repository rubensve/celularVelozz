package com.dao;

import com.conexion.Conexion;
import com.pojo.Nota;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotaDAO implements DAO<Nota> 
{
    Conexion conexion= Conexion.getConexion();
    
    private static String LEERULTIMO= "Select * from notas order by folio desc limit 1";
    private static String INSERTAR="insert into notas(fecharecepcion,fechaentrega,login,id_cliente,imei,modelo,total,anticipo,resto,observaciones)"+
           " values(curdate(), date_format(?, get_format(date, 'ISO')),?,?,?,?,?,?,?,?);";
    private static String LEERIND= "Select * from notas where folio= ?";
    private static final String SQL_READCLIENTES= "select a.folio, a.fecharecepcion, a.fechaentrega, a.login, a.id_cliente, a.imei,a.modelo, a.total, a.anticipo, b.descripcion, c.descripcion, "
            + " a.observaciones, a.obsreparacion from notas as a inner join cestatusnota as b on a.id_estatusnota= b.id_estatusnota "
            + " inner join cestatusreparacion as c on a.id_estatusreparacion= c.id_estatusreparacion where id_cliente=?;";
    
    public Nota leerIndividual(int folio){
        PreparedStatement ps;
            Nota n= null;
            ResultSet rs;
        
        try {
            ps= conexion.getCc().prepareStatement(LEERIND);
            ps.setInt(1, folio);
            rs= ps.executeQuery();
            while (rs.next())
            {
                n= new Nota(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getDouble(8),  
                        rs.getDouble(9), rs.getInt(11), rs.getInt(12),rs.getString(13),rs.getString(14));
            }
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            conexion.cerrarConexion();
        }
        return n; 
    }
    
    public ArrayList<Nota> readPorCliente(int id_cliente)
    {
            PreparedStatement ps;
            ArrayList<Nota> notas = new ArrayList();
            ResultSet rs;
        try {
            ps= conexion.getCc().prepareStatement(SQL_READCLIENTES);
            ps.setInt(1, id_cliente);
            rs= ps.executeQuery();
            while (rs.next())
            {
                notas.add(new Nota(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getDouble(8),  
                        rs.getDouble(9), rs.getString(10),rs.getString(11), rs.getString(12),rs.getString(13)));
            }
             } catch (SQLException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return notas;
    }
    
    public Nota leerultimo() {
        PreparedStatement ps;
            Nota n= null;
            ResultSet rs;
        try {
            ps= conexion.getCc().prepareStatement(LEERULTIMO);
            rs= ps.executeQuery();
            while (rs.next())
            {
                n= new Nota(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getDouble(8),rs.getDouble(9), rs.getDouble(10),rs.getInt(11),rs.getInt(12),
                        rs.getString(13), rs.getString(14));    
            }
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            conexion.cerrarConexion();
        }
        return n;
    }
    
    @Override
    public boolean create(Nota n) {
        PreparedStatement ps;
            
        try {
            ps = conexion.getCc().prepareStatement(INSERTAR);
            ps.setString(1, n.getFechaentrega());
            ps.setString(2, n.getU().getLogin());
            ps.setInt(3, n.getC().getId());
            ps.setString(4, n.getImei());
            ps.setString(5, n.getModelo());
            ps.setDouble(6, n.getTotal());
            ps.setDouble(7, n.getAnticipo());
            ps.setDouble(8, n.getResto());
            ps.setString(9, n.getObservaciones());
            
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
    public boolean update(Nota o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Nota> read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Nota> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
