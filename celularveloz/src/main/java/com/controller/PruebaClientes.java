package com.controller;

import com.dao.ClienteDAO;
import com.pojo.Cliente;
import java.util.ArrayList;


public class PruebaClientes {
    public static void main(String[] args) {
        
        String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
      String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");

        System.out.println(host+port);
}
}
