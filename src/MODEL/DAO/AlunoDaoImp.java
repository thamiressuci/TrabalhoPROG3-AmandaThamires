/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import MODEL.POJO.Aluno;
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
public class AlunoDaoImp implements ArqAluno {
    private ArrayList<Aluno> listaAlunos;
    Iterator<Aluno> it;
    private FileWriter fw;
    private BufferedWriter bw;
    private FileReader fr;
    private BufferedReader br;
    String nomeArquivo;
    String caminhoPasta;
    
    public AlunoDaoImp(){
        this.listaAlunos = new ArrayList<Aluno>();
        caminhoPasta = "D:\\LEITURA_THAMIRES\\";
        nomeArquivo = "Alunos";
    }
    
    @Override
    public void ler() throws FileNotFoundException{        
        FileReader file;
        try {
            file = new FileReader(caminhoPasta+nomeArquivo+".txt"); //abre o arquivo
            
            BufferedReader ler = new BufferedReader(file);//Estacio o arquivo para leitura
            
            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                String nome = ler.readLine();//Pega nome
                String cpf = ler.readLine();//Pega cpf
                
                Aluno novo = new Aluno(nome,cpf);
                this.listaAlunos.add(novo);//Adiciona na lista
            }
            
            file.close();//Fecho o arquivo
            ler.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlunoDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlunoDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
     public Aluno verificar (String cpf){//verifica se o cpf ta salvo na lista de alunos
	if (listaAlunos.isEmpty() == true) return null;
	it = listaAlunos.iterator(); 
	while (it.hasNext()) {  
                Aluno aux = it.next();
		if (aux.getCpf().equals(cpf)){  
                    return aux;
		}  
	}
	return null;
    }


    @Override
    public void inserir(String nome, String cpf) {
        Aluno aluno;
        aluno = new Aluno(nome, cpf);
        this.listaAlunos.add(aluno);
    }

    @Override
      public boolean salvar(Aluno aluno) throws IOException{
	if (aluno == null) return false;
	fw = new FileWriter(caminhoPasta+nomeArquivo+"_Novo.txt", true);
	bw = new BufferedWriter (fw);
	bw.write(aluno.getNome());
	bw.newLine();
	bw.write(aluno.getCpf());
	bw.newLine();
	bw.close();
	fw.close();
	return true;
    }
    
    @Override
    public boolean salvar(ArrayList<Aluno> lista) throws IOException{//Pega os alunos da lista e vai salvando no arquivo
        if (lista.isEmpty() == true) return false;
	it = lista.iterator();
	while (it.hasNext()){
            salvar(it.next());
	}
	return true;
    }

    public ArrayList<Aluno> getListaAlunos() {
        return this.listaAlunos;
    }
    
     public void exibeAlunos(){
        for(int i = 0; i < listaAlunos.size(); i++){
            System.out.println("Nome: "+listaAlunos.get(i).getNome());
            System.out.println("CPF: "+listaAlunos.get(i).getCpf());
            System.out.println("------------------------------");
        }
    }
}

 


