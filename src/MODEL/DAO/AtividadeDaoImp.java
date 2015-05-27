/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import MODEL.POJO.Atividade;
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
public class AtividadeDaoImp{
    private ArrayList<Atividade> listaAtividades;
    Iterator<Atividade> it;
    private FileWriter fw;
    private BufferedWriter bw;
    private FileReader fr;
    private BufferedReader br;
    String nomeArquivo;
    
    public AtividadeDaoImp(){
        this.listaAtividades = new ArrayList<Atividade>();
         nomeArquivo = "Atividades.txt";
    }
    
    
     public Atividade verificar (String tipo){
	if (listaAtividades.isEmpty() == true) return null;
	it = listaAtividades.iterator(); 
	while (it.hasNext()) {  
                Atividade aux = it.next();  
		if (aux.getTipo().equals(tipo)){  
                    return aux;
		}  
	}
	return null;
    }
     

    public ArrayList<Atividade> getListaAtividades() {
        return this.listaAtividades;
    }
}

