/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;


import MODEL.POJO.Nota;
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
public class NotasDaoImp {
    private ArrayList<Nota> listaNotas;
    Iterator<Nota> it;
    private FileWriter fw;
    private BufferedWriter bw;
    private FileReader fr;
    private BufferedReader br;
    String nomeArquivo;
    
    public NotasDaoImp(){
        this.listaNotas = new ArrayList<Nota>();
         nomeArquivo = "Notas.txt";
    }

    public ArrayList<Nota> ler() throws FileNotFoundException{        
        FileReader file;
        
        try {
            file = new FileReader(nomeArquivo); //abre o arquivo
            
            BufferedReader ler = new BufferedReader(file);//Estacio o arquivo para leitura
            
            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                int nota = Integer.parseInt(ler.readLine());//Pega nota
                String cpf = ler.readLine();//Pega cpf
                Nota novo = new Nota(nota,cpf);
                this.listaNotas.add(novo);//Adiciona na lista
            }
            
            file.close();//Fecho o arquivo
            ler.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FaltaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FaltaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaNotas;
    }
     public Nota verificar (String cpf){//verifica se o cpf ta salvo na lista de alunos
	if (listaNotas.isEmpty() == true) return null;
	it = listaNotas.iterator(); 
	while (it.hasNext()) {  
                Nota aux = it.next();  
		if (aux.getCpf().equals(cpf)){  
                    return aux;
		}  
	}
	return null;
    }

    public void inserir(int nota, String cpf) {
        Nota notas;
        notas = new Nota(nota, cpf);
        this.listaNotas.add(notas);
    }


    public ArrayList<Nota> getListaNotas() {
        return this.listaNotas;
    }
}
