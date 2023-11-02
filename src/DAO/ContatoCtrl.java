/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Contato;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Aluno
 */
public class ContatoCtrl {
    
    public static String[] getContato(String index){
        DAOContato dao = new DAOContato();
        Contato contato = dao.getContato(index);
        return contato.toArray();
    }
    
    public static String[][] getContato(){
        DAOContato dao = new DAOContato();
        ArrayList<Contato> listaContato = dao.getContato();
        String[][] array = new String[listaContato.size()][10];
        for (int i = 0; i < listaContato.size(); i++) {
            array[i] = listaContato.get(i).toArray();
        }
        return array;
    }
    
    /*public static ArrayList<String[]> getContato(){
        DAOContato dao = new DAOContato();
        ArrayList<Contato> listaContato = dao.getContato();
        ArrayList<String[]> array = new ArrayList<>();
        for (Contato contato : listaContato){
            array.add(contato.toArray());
        }
        return array;
    }*/
    
    
    public static String[] saveContato(String[] dados){
        String index = dados[0];
        DAOContato dao = new DAOContato();
        Contato contato = new Contato();
        contato.fromArray(dados);
        if (index.equals("")){
            contato.setCodigo(UUID.randomUUID().toString());
            dao.addContato(contato);
        }else{
            dao.updateContato(contato);
        }
        return getContato(contato.getCodigo());
    }
    
    public static void deleteContato(String index){
        DAOContato dao = new DAOContato();
        dao.deleteContato(index);
    }
    
    
    
    
    
}
