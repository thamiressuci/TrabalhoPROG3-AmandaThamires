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
public class Falta {
    private int qtd;
    private String cpf;
    //funcao de ler do arquivo lista de faltas 
    
    public Falta(int qtd, String cpf){
        this.qtd = qtd;
        this.cpf = cpf;
    }
    
    public int getQtd(){
        return qtd;
    }
    public void setQtd(int qtd){
        this.qtd = qtd; 
    }
    
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf; 
    }
}
