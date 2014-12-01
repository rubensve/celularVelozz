/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.ClienteDAO;
import com.pojo.Cliente;

/**
 *
 * @author rubens
 */
public class pruebaclientenombre {
    
    public static void main(String[] args) {
        ClienteDAO clientes = new ClienteDAO();
        Cliente cliente= clientes.readinombre("ruben", "veloz");
        System.out.println(cliente.getId()+" " + cliente.getNombre()+" " + cliente.getApellido()+ " " + cliente.getTelefono());
        
        
        
    }
    
}
