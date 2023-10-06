/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import com.mysql.cj.protocol.x.MessageConstants;
import java.sql.ResultSet;

/**
 *
 * @author deusdete.2904
 */
public class DaoCategoria extends BancoDeDadosMySql{
    private String sql;
    
    public Boolean inserir(int id, String nome, String descricao){
        try{
            sql = "INSERT INTO CATEGORIA (ID, NOME, DESCRICAO)VALUES (?, ?, ?)";
        
            getStatement().setInt(1, id);
            getStatement().setString(2, nome);
            getStatement().setString(3, descricao);
            
            getStatement().executeUpdate();
            return true;
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }                    
    }
    
    public Boolean alterar (int id, String novoNome, String novaDescricao){
        try{
            sql = "UPDATE CATEGORIA SET NOME = ?, DESCRICAO = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(3, id);
            getStatement().setString(1, novoNome);
            getStatement().setString(2, novaDescricao);
        
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM CATEGORIA WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            getStatement().setInt(1, id);
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ResultSet listarTodos(){
        try{
            sql ="SELECT ID, NOME, IFNULL(DESCRICAO, '')FROM CATEGORIA WHER ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
        }catch(Exception e){
            System.out.println(e.getMessage());          
        }
        return getResultado();
    }
    
    public ResultSet ListarPorId(int id){
        try{
            sql = "SELECT ID, NOME, IFNULL(DESCRICAO, '') FROM CATEGORIA WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1,id);
        
        }catch(Exception e){
            System.out.println("e.getMessage");
            
        }       
    }return  getResultado();
    
    public ResultSet listarPorNome(String nome){
        try{
            sql = "SELECT ID, NOME,IFNULL(DESCRICAO,'') FROM CATEGORIA WHERE NOME LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return  getResultado();
    }
    
    public ResultSet listarPorDescricao(String descricao){
        try{
            sql = "SELECT ID, NOME, IFNULL(DESCRICAO, '') FROM CATEGORIA";
        
        }catch (Exception e){}
            System.out.println(e.getMessage());
    }
}
            
    