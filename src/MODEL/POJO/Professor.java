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
public class Professor {
    
    private String nome;
    private String cpf;
    private String departamento;
    private ArrayList<Disciplina> disciplinas;
  
    
    public Professor(String nome, String cpf, String departamento){
        this.nome = nome;
        this.cpf = cpf;
        this.departamento = departamento;
        
    }
    public void insereDisciplina (Disciplina disciplinas){
        this.disciplinas.add(disciplinas);
           
}
    public void insereArrayDisciplina( ArrayList<Disciplina> disciplinas){
        this.disciplinas = disciplinas;
    }
    //Get e Set
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
    public String getDepartamento(){
        return departamento;
    }
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }
    public void setDisciplinas(ArrayList<Disciplina> disciplinas){
        this.disciplinas = disciplinas;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }
}
    
