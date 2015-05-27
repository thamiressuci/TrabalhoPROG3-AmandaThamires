/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.POJO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author thamires
 */
public class Disciplina {
    private String nome;
    private String ementa;
    private String codigo;
    private String cargaHoraria;
    private ArrayList<Falta> faltas;
    private ArrayList<Nota> notas;
    private ArrayList<Atividade> atividades;
    private ArrayList<Aluno> alunos;
    private Professor professor;

    public Disciplina(String nome, String ementa, String codigo,String cargaHoraria) {
        this.nome = nome;
        this.ementa = ementa;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        professor = new Professor("-", "-", "-");
        faltas = new ArrayList<Falta>();
        notas = new ArrayList<Nota>();
        atividades = new ArrayList<Atividade>();
        alunos = new ArrayList<Aluno>();
    }
    public void insereAluno(Aluno aluno, float nota, int faltas){
        Falta auxFalta;
        auxFalta = new Falta(faltas, aluno.getCpf());
        Nota auxNota;
        auxNota = new Nota(nota, aluno.getCpf());
        this.faltas.add(auxFalta);
        notas.add(auxNota);
        alunos.add(aluno);
    }
    
    public void insereAtividade(Atividade nova){
        atividades.add(nova);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    public void setProfessor(Professor professor){
        this.professor = professor;
    }
    
    public Professor getProfessor(){
        return professor;
    }
    
    public ArrayList<Aluno> getAlunos(){
        return alunos;
    }
    
    public ArrayList<Falta> getFaltas(){
        return faltas;
    }
    
    public ArrayList<Nota> getNotas(){
        return notas;
    }
    
    public int getFaltasAluno(String cpf){
        //Buscando o cpf dentro do vetor de alunos
        Iterator<Falta> itFaltas;
        itFaltas = faltas.iterator();
        if (faltas != null){
            itFaltas = faltas.iterator(); 
            Falta auxFalta = null;
            while (itFaltas.hasNext()) {  
                auxFalta = itFaltas.next();  
                if (auxFalta.getCpf().equals(cpf)){
                    return auxFalta.getQtd();
                } 
            }
        }
        return -1;
    }
    
    public float getNotaAluno(String cpf){
        //Buscando o cpf dentro do vetor de alunos
        Iterator<Nota> itNotas;
        itNotas = notas.iterator();
        if (notas != null){
            itNotas = notas.iterator(); 
            Nota auxNota = null;
            while (itNotas.hasNext()) {  
                auxNota = itNotas.next();  
                if (auxNota.getCpf().equals(cpf)){
                    return auxNota.getNota();
                } 
            }
        }
        return -1;
    }
    
    public ArrayList<Atividade> getAtividades(){
        return atividades;
    }
}

