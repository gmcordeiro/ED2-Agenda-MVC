/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.sql.*;
import Model.Contato;

/**
 *
 * @author Guilherme
 */
public class DAOContato {
    
    private static final String SQL_INSERT = 
            "INSERT INTO tbl_contato (codigo, nome, tipoContato, favorito, telefone, celular, fax, observacao, empresaNome, cargo)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = 
            "UPDATE tbl_contato SET nome = ?,tipoContato = ?,favorito = ?,telefone = ?,celular = ?,fax = ?,observacao = ?,empresaNome = ?,cargo = ? WHERE codigo = ?";
    private static final String SQL_DELETE =
            "DELETE FROM tbl_contato WHERE codigo = ?";
    private static final String SQL_SELECT_INDEX = "SELECT * FROM tbl_contato WHERE codigo = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM tbl_contato";
    
    
    // Busca um contato pelo UUID
    public Contato getContato(String index) {
        Connection connection = DataBaseConnection.getConnection();
        Contato contato = new Contato();
        try{
            PreparedStatement pst = connection.prepareStatement(SQL_SELECT_INDEX);
            pst.setString(1, index);
            ResultSet result = pst.executeQuery();
            if(result.next()){
                contato.setCodigo(result.getString("codigo"));
                contato.setNome(result.getString("nome"));
                contato.setTipoContato(result.getString("tipoContato"));
                contato.setFavorito(result.getBoolean("favorito"));
                contato.setTelefone(result.getString("telefone"));
                contato.setCelular(result.getString("celular"));
                contato.setFax(result.getString("fax"));
                contato.setObservacao(result.getString("observacao"));
                contato.setEmpresaNome(result.getString("empresaNome"));
                contato.setCargo(result.getString("cargo"));
            } else {
                contato = null;
                System.out.println("Contato não existe!");
            }
            pst.close();
        }catch(SQLException e){
            System.out.println("Close connection failed listacontatos.SQLQuery.getContato()");
            contato = null;
        }
        return contato;
    }
    
    //Busca todos os contatos
    public ArrayList<Contato> getContato(){
        Connection connection = DataBaseConnection.getConnection();
        ArrayList<Contato> listaContatos = new ArrayList<>();
        try{
            PreparedStatement pst = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                Contato contato = new Contato();
                contato.setCodigo(result.getString("codigo"));
                contato.setNome(result.getString("nome"));
                contato.setTipoContato(result.getString("tipoContato"));
                contato.setFavorito(result.getBoolean("favorito"));
                contato.setTelefone(result.getString("telefone"));
                contato.setCelular(result.getString("celular"));
                contato.setFax(result.getString("fax"));
                contato.setObservacao(result.getString("observacao"));
                contato.setEmpresaNome(result.getString("empresaNome"));
                contato.setCargo(result.getString("cargo"));
                listaContatos.add(contato);
            }
            pst.close();
        }catch(SQLException e){
            System.out.println("Close connection failed listacontatos.SQLQuery.getContato()");
        }
        return listaContatos;
    }
    
    public void addContato(Contato contato){
        Connection connection = DataBaseConnection.getConnection();
        try{
            PreparedStatement pst = connection.prepareStatement(SQL_INSERT);
            pst.setString(1, contato.getCodigo());
            pst.setString(2, contato.getNome());
            pst.setString(3, contato.getTipoContato());
            pst.setBoolean(4, contato.isFavorito());
            pst.setString(5, contato.getTelefone());
            pst.setString(6, contato.getCelular());
            pst.setString(7, contato.getFax());
            pst.setString(8, contato.getObservacao());
            pst.setString(9, contato.getEmpresaNome());
            pst.setString(10, contato.getCargo());
            pst.executeUpdate();
            pst.close();
        }catch(SQLException e){
            System.out.println("Close connection failed listacontatos.SQLQuery.addContato()");
        }
    }    
    
    public void updateContato(Contato contato){
        Connection connection = DataBaseConnection.getConnection();
        try{
            PreparedStatement pst = connection.prepareStatement(SQL_UPDATE);
            pst.setString(1, contato.getNome());
            pst.setString(2, contato.getTipoContato());
            pst.setBoolean(3, contato.isFavorito());
            pst.setString(4, contato.getTelefone());
            pst.setString(5, contato.getCelular());
            pst.setString(6, contato.getFax());
            pst.setString(7, contato.getObservacao());
            pst.setString(8, contato.getEmpresaNome());
            pst.setString(9, contato.getCargo());
            pst.setString(10, contato.getCodigo());
            pst.executeUpdate();
            pst.close();
        }catch(SQLException e){
            System.out.println("Close connection failed listacontatos.SQLQuery.updateContato()");
        }
    }
    
    public void deleteContato(String index){
        Connection connection = DataBaseConnection.getConnection();
        try{
            PreparedStatement pst = connection.prepareStatement(SQL_DELETE);
            pst.setString(1, index);
            pst.executeUpdate();
            pst.close();
        }catch(SQLException e){
            System.out.println("Close connection failed listacontatos.SQLQuery.updateContato()");
        }
    }
    
}
