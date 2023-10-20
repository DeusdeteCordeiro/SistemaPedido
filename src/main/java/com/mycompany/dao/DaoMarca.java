/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import java.sql.ResultSet;

/**
 *
 * @author deusdete.2904
 */
public class DaoMarca extends BancoDeDadosMySql{
    String sql;
    
    public ResultSet listarTodos(){
        try{
            sql = 
                " SELECT  " +
                "   ID,   " +
                "   NOME  " +
                " FROM    " +
                "   MARCA " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
}
