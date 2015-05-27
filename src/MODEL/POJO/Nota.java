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
public class Nota {
    private float nota;
    private String cpf;
    
    public Nota(float nota, String cpf){
        this.nota = nota;
        this.cpf = cpf;
    }
    public float getNota(){
        return nota;
    }
    public void setNota(int nota){
        this.nota = nota;
    }
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
}

    
   

