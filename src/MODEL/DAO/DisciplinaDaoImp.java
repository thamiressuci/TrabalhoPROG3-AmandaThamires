/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;


import MODEL.POJO.Disciplina;
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
public class DisciplinaDaoImp implements ArqDisciplina{
    private ArrayList<Disciplina> listaDisciplinas;
    Iterator<Disciplina> it;
    private FileWriter fw;
    private BufferedWriter bw;
    private FileReader fr;
    private BufferedReader br;
    String nomeArquivo;
    String caminhoPasta;
    
    public DisciplinaDaoImp(){
        this.listaDisciplinas = new ArrayList<Disciplina>();
        caminhoPasta = "D:\\LEITURA_THAMIRES\\";
        nomeArquivo = "Disciplinas";
    }
    

    @Override
    public ArrayList<Disciplina> ler() throws FileNotFoundException{        
        FileReader file;
        try {
            file = new FileReader(caminhoPasta+nomeArquivo+".txt"); //abre o arquivo

            BufferedReader ler = new BufferedReader(file);//Estacio o arquivo para leitura

            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                String nome = ler.readLine(); 
                String ementa = ler.readLine();
                String codigo = ler.readLine();
                String cargaHoraria = ler.readLine();

                Disciplina novo = new Disciplina(nome, ementa, codigo, cargaHoraria);
                this.listaDisciplinas.add(novo);//Adiciona na lista
            }

            file.close();//Fecho o arquivo
            ler.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DisciplinaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DisciplinaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDisciplinas;
    }
    @Override
   public Disciplina verificar (String nome){//verifica se o nome da disciplina ja ta salvo na lista de disciplinas
        if (listaDisciplinas.isEmpty() == true) return null;
        it = listaDisciplinas.iterator(); 
	while (it.hasNext()) {  
            Disciplina aux = it.next();  
            if (aux.getNome().equals(nome)){  
                return aux;
            }  
	}
	return null;
    }
    
    
    @Override
    public void inserir(String nome, String ementa, String codigo, String cargaHoraria) {
        Disciplina disciplina;
        disciplina = new Disciplina(nome, ementa, codigo, cargaHoraria);
        this.listaDisciplinas.add(disciplina);
    }

    @Override
    public boolean salvar(Disciplina disciplina) throws IOException{
	if (disciplina == null) return false;
	fw = new FileWriter(caminhoPasta+nomeArquivo+"_Novo.txt", true);
	bw = new BufferedWriter (fw);
	bw.write(disciplina.getNome());
	bw.newLine();
	bw.write(disciplina.getEmenta());
	bw.newLine();
        bw.write(disciplina.getCodigo());
	bw.newLine();
        bw.write(disciplina.getCargaHoraria());
	bw.newLine();
	bw.close();
	fw.close();
	return true;
    }
    
    @Override
    public boolean salvar(ArrayList<Disciplina> disciplinas) throws IOException{
        if (disciplinas.isEmpty() == true) return false;
	it = disciplinas.iterator();
	while (it.hasNext()){
            salvar(it.next());
	}
	return true;
    }

    public void exibeDisciplinas(){
        for(int i = 0; i < listaDisciplinas.size(); i++){
            System.out.println("Nome: "+listaDisciplinas.get(i).getNome());
            System.out.println("Ementa: "+listaDisciplinas.get(i).getEmenta());
            System.out.println("Código: "+listaDisciplinas.get(i).getCodigo());
            System.out.println("Carga Horaria: "+listaDisciplinas.get(i).getCargaHoraria());
            System.out.println("------------------------------");
        }
    }
    
    public ArrayList<Disciplina> getListaDisciplinas(){
        return listaDisciplinas;
    }
    
    public void setListaDisciplinas(ArrayList<Disciplina> listaDisciplinas){
        this.listaDisciplinas = listaDisciplinas;
    }
    
}
