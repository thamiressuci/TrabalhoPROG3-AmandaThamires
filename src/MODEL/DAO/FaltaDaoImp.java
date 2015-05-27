/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import MODEL.POJO.Falta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thamires
 */
public class FaltaDaoImp {
    private ArrayList<Falta> listaFaltas;
    Iterator<Falta> it;
    private FileWriter fw;
    private BufferedWriter bw;
    private FileReader fr;
    private BufferedReader br;
    String nomeArquivo;
    
    public FaltaDaoImp(){
        this.listaFaltas = new ArrayList<Falta>();
         nomeArquivo = "Faltas.txt";
    }

    
     public Falta verificar (String cpf){//verifica se o cpf ta salvo na lista de alunos
	if (listaFaltas.isEmpty() == true) return null;
	it = listaFaltas.iterator(); 
	while (it.hasNext()) {  
                Falta aux = it.next();  
		if (aux.getCpf().equals(cpf)){  
                    return aux;
		}  
	}
	return null;
    }

    public void inserir(int qtd, String cpf) {
        Falta falta;
        falta = new Falta(qtd, cpf);
        this.listaFaltas.add(falta);
    }

    public ArrayList<Falta> getListaFaltas() {
        return this.listaFaltas;
    }
}

