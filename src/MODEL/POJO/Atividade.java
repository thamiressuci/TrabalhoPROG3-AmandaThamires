/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.POJO;

import java.util.ArrayList;

/**
 *
 * @author thamires
 */
public class Atividade {
   private String nome;
   private String tipo;
   private String data;
   private float valor;
   private ArrayList<Nota> notas;
 

    public Atividade(String nome, String tipo, String data, float valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        notas = new ArrayList<Nota>();
    }
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public void insereNotaAluno(String cpf, float nota){
        Nota auxNota = new Nota(nota, cpf);
        this.notas.add(auxNota);
    }
    
    public void exibeAtividade(){
        System.out.println("Nome: "+nome);
        System.out.println("Tipo: "+tipo);
        System.out.println("Data: "+data);
        System.out.println("Valor: "+valor);
    }
   
    public ArrayList<Nota> getNotas(){
        return notas;
    }
    
}
