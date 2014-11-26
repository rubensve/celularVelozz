
package com.dao;

import java.util.ArrayList;

public interface DAO <Objeto> {
    
    public boolean create(Objeto o);
    public boolean update(Objeto o);
    public boolean delete(Object key);
    public ArrayList<Objeto> read(Object key);
    public ArrayList<Objeto> readAll();
    
    
}
