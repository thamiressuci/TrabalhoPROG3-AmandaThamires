/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.POJO;

/**
 *
 * @author thamires
 */
public class Aluno {
    
    private String nome;
    private String cpf;
    
    
    public Aluno(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
}
