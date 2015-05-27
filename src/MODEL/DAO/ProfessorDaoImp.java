/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import MODEL.POJO.Disciplina;
import MODEL.POJO.Professor;
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
public class ProfessorDaoImp implements ArqProfessor{
    private ArrayList<Professor> listaProfessores;
    Iterator<Professor> it;
    private FileWriter fw;
    private BufferedWriter bw;
    private FileReader fr;
    private BufferedReader br;
    String nomeArquivo;
    String caminhoPasta;
    
    public ProfessorDaoImp(){
        this.listaProfessores = new ArrayList<Professor>();
        caminhoPasta = "D:\\LEITURA_THAMIRES\\";
        nomeArquivo = "Professores";
        //nomeArquivo = "Professores_Novo.txt";
    }

    public ArrayList<Professor> ler(ArrayList<Disciplina> disciplinas) throws FileNotFoundException{        
        FileReader file;
        try {
            file = new FileReader(caminhoPasta+nomeArquivo+".txt"); //abre o arquivo
            
            BufferedReader ler = new BufferedReader(file);//Estacio o arquivo para leitura
            
            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                String nome = ler.readLine();
                String cpf = ler.readLine();
                String departamento = ler.readLine();
                int numDisciplinas = Integer.parseInt(ler.readLine());
                ArrayList<Disciplina> disciplinasProfessor;
                disciplinasProfessor = new ArrayList<Disciplina>();
                
                boolean flagEncontrouDisciplina = false;
                for(int i = 0; i< numDisciplinas; i++){ //lendo todas as disciplinas daquele professor
                    String codigoD = ler.readLine();
                    
                    //Buscando o código dentro do vetor de disciplinas
                    Iterator<Disciplina> itDisciplinas;
                    itDisciplinas = disciplinas.iterator();
                    if (disciplinas != null){
                        itDisciplinas = disciplinas.iterator();
                        Disciplina auxD = null;
                        while (itDisciplinas.hasNext()){ //loop para procurar a disciplina com o codigo dentro do vetor
                            auxD = itDisciplinas.next();  
                            if (auxD.getCodigo().equals(codigoD)){
                                flagEncontrouDisciplina = true;
                                break;
                            }  
                        }
                        if(flagEncontrouDisciplina){ //caso tenha encontrado a disciplina dentro do vetor, adiciona ao arraylist do professor
                            disciplinasProfessor.add(auxD);
                        }
                        flagEncontrouDisciplina = false;
                    }
                    
                }
                Professor novo = new Professor(nome,cpf, departamento);
                novo.setDisciplinas(disciplinasProfessor);
                this.listaProfessores.add(novo);//Adiciona o professor na lista
            }
            
            file.close();//Fecho o arquivo
            ler.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FaltaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FaltaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProfessores;
    }
    
    @Override
     public Professor verificar (String cpf){//verifica se o cpf ta salvo na lista de professores
        if (listaProfessores.isEmpty() == true) return null;
        it = listaProfessores.iterator(); 
	while (it.hasNext()) {  
            Professor aux = it.next();  
            if (aux.getCpf().equals(cpf)){  
                return aux;
            }  
	}
	return null;
    }
    
    @Override
    public void inserir(String nome, String cpf, String departamento) {
        Professor professores;
        professores = new Professor(nome, cpf, departamento);
        this.listaProfessores.add(professores);
    }

      @Override
      public boolean salvar() throws IOException{ //Salvar array de professores
	fw = new FileWriter(caminhoPasta+nomeArquivo+"_Novo.txt", true);
	bw = new BufferedWriter (fw);
        for(int i = 0; i< this.listaProfessores.size(); i++){ //Loop para salvar todos os professores
            bw.write(this.listaProfessores.get(i).getNome());
            bw.newLine();
            bw.write(this.listaProfessores.get(i).getCpf());
            bw.newLine();
            bw.write(this.listaProfessores.get(i).getDepartamento());
            bw.newLine();
           
            ArrayList<Disciplina> disciplinasProfessor = this.listaProfessores.get(i).getDisciplinas();
            if(disciplinasProfessor != null){ //caso o professor tenha disciplinas a serem salvas
                Integer tamDisciplinas = disciplinasProfessor.size();
                bw.write(tamDisciplinas.toString()); //Salvando a quantidade de disciplinas do professor
                bw.newLine();
                for(int j = 0; j< disciplinasProfessor.size(); j++){ //Loop para salvar todas as disciplinas desse professor
                    bw.write(disciplinasProfessor.get(j).getCodigo());
                    bw.newLine();
                }
            }else{ //caso nao tenha disciplinas salva como zero
                bw.write("0"); //Salvando a quantidade de disciplinas do professor
                bw.newLine();
            }
        }
	bw.close();
	fw.close();
	return true;
    }
      
    public void exibeProfessores(){
        for(int i = 0; i < listaProfessores.size(); i++){
            System.out.println("Nome: "+listaProfessores.get(i).getNome());
            System.out.println("Cpf: "+listaProfessores.get(i).getCpf());
            System.out.println("Departamento: "+listaProfessores.get(i).getDepartamento());
            ArrayList<Disciplina> auxDisciplinas;
            auxDisciplinas = listaProfessores.get(i).getDisciplinas();
            if(auxDisciplinas != null){
                System.out.println("-Disciplinas-");
                for(int j = 0; j < auxDisciplinas.size(); j++){
                    System.out.println("Nome: "+auxDisciplinas.get(j).getNome());
                    System.out.println("Ementa: "+auxDisciplinas.get(j).getEmenta());
                    System.out.println("Codigo: "+auxDisciplinas.get(j).getCodigo());
                    System.out.println("Carga Horaria: "+auxDisciplinas.get(j).getCargaHoraria());
                }
            }
            System.out.println("------------------------------");
        }
    }
    
    public ArrayList<Professor> getListaProfessores(){
        return this.listaProfessores;
    }
}
