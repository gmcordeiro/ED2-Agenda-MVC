/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.UUID;

/**
 *
 * @author Aluno
 */
public class Contato {
    private String codigo;
    private String nome;
    private String tipoContato;
    private boolean favorito;
    private String telefone;
    private String celular;
    private String fax;
    private String observacao;
    private String empresaNome;
    private String cargo;

    public Contato() {
        //this.codigo = UUID.randomUUID().toString();
        this.codigo = "";
        this.nome = "";
        this.tipoContato = "";
        this.favorito = false;
        this.telefone = "";
        this.celular = "";
        this.fax = "";
        this.observacao = "";
        this.empresaNome = "";
        this.cargo = "";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String indexContato) {
        this.codigo = indexContato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getEmpresaNome() {
        return empresaNome;
    }

    public void setEmpresaNome(String empresaNome) {
        this.empresaNome = empresaNome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public String[] toArray(){
        String[] array = new String[10];
        array[0] = codigo;
        array[1] = nome;
        array[2] = tipoContato;
        array[3] = Boolean.toString(favorito);
        array[4] = telefone;
        array[5] = celular;
        array[6] = fax;
        array[7] = observacao;
        array[8] = empresaNome;
        array[9] = cargo;
        
        return array;
    }
    
    public void fromArray(String[] array){
        codigo = array[0];
        nome = array[1];
        tipoContato = array[2];
        favorito = Boolean.getBoolean(array[3]);
        telefone = array[4];
        celular = array[5];
        fax = array[6];
        observacao = array[7];
        empresaNome = array[8];
        cargo = array[9];
    }
}
