/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import MODEL.POJO.Aluno;
import MODEL.POJO.Atividade;
import MODEL.POJO.Disciplina;
import MODEL.POJO.Falta;
import MODEL.POJO.Nota;
import MODEL.POJO.Professor;
import MODEL.POJO.Turma;
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
public class TurmaDaoImp implements ArqTurma{
    private ArrayList<Turma> listaTurmas;
    Iterator<Turma> it;
    private FileWriter fw;
    private BufferedWriter bw;
    private FileReader fr;
    private BufferedReader br;
    String nomeArquivo;
    String caminhoPasta;
    
    public TurmaDaoImp(){
        this.listaTurmas = new ArrayList<Turma>();
        caminhoPasta = "D:\\LEITURA_THAMIRES\\";
        nomeArquivo = "Turmas";
    }
    
    public void criaTurma(){ //adiciona uma nova turma ao final do vetor de turmas
        
    }
    
    public void insereProfessor(){ //insere um professor na disciplina indicada
        
    }
    
    public void insereAluno(){ //insere um aluno na turma
        
    }

    @Override
    public ArrayList<Turma> ler(ArrayList<Aluno> alunos, ArrayList<Professor> professores, ArrayList<Disciplina> disciplinas) throws IOException {
        FileReader file;
        try {
            file = new FileReader(caminhoPasta+nomeArquivo+".txt"); //abre o arquivo

            BufferedReader ler = new BufferedReader(file);//Estacio o arquivo para leitura

            while(ler.ready()){//Equando nao chegar no final do arquivo, while continua
                
                //Lê os dados da turma
                int ano = Integer.parseInt(ler.readLine()); 
                int periodo = Integer.parseInt(ler.readLine());
                String local = ler.readLine();
                String horario = ler.readLine();
                int numero_de_vagas = Integer.parseInt(ler.readLine());
                
                Turma novaTurma = new Turma(ano, periodo, local, horario, numero_de_vagas);
        
                int qtdAlunos = Integer.parseInt(ler.readLine()); //pega a quantidade de alunos matriculados na turma
                
                if(qtdAlunos > 0){ //caso seja maior que zero, insere os n alunos na TURMA
                    boolean flagEncontrouAluno = false;
                    for(int i = 0; i < qtdAlunos; i++){ //insere todos os alunos na turma
                        String cpfAluno = ler.readLine();
                        //Buscando o cpf dentro do vetor de cpfs dos alunos
                        Iterator<Aluno> itAlunos;
                        itAlunos = alunos.iterator();
                        if (alunos != null){
                            itAlunos = alunos.iterator(); 
                            Aluno auxAluno = null;
                            while (itAlunos.hasNext()) {  
                               auxAluno = itAlunos.next();
                                if (auxAluno.getCpf().equals(cpfAluno)){  
                                    flagEncontrouAluno = true;
                                    break;
                                } 
                            }
                            if(flagEncontrouAluno == true){ //caso tenha encontrado o aluno insere ele no array de alunos da turma
                                novaTurma.insereAluno(auxAluno);
                            }
                            flagEncontrouAluno = false;
                        }
                    }
                }
                int qtdDisciplinas = Integer.parseInt(ler.readLine()); //pega a quantidade de disciplinas ofertadas para aquela turma
                if(qtdDisciplinas > 0){ //loop para ler todas as disciplinas da turma
                    boolean flagEncontrouDisciplina = false;
                    for(int i = 0; i < qtdDisciplinas; i++){
                        String codDisciplina = ler.readLine();
                        String cpfProfessor = ler.readLine();
                        
                        Disciplina novaDisciplina = null;
                        
                        //Buscando o código dentro do vetor de disciplinas
                        Iterator<Disciplina> itDisciplina;
                        itDisciplina = disciplinas.iterator();
                        if (disciplinas != null){
                            itDisciplina = disciplinas.iterator(); 
                            Disciplina auxDisciplina = null;
                            while (itDisciplina.hasNext()) {  
                               auxDisciplina = itDisciplina.next();  
                                if (auxDisciplina.getCodigo().equals(codDisciplina)){
                                    flagEncontrouDisciplina = true;
                                    break;
                                } 
                            }
                            if(flagEncontrouDisciplina){
                                novaDisciplina = auxDisciplina;
                            }
                        }
                        flagEncontrouDisciplina = false;
                        
                        //Buscando o cpf dentro do vetor dos professores
                        Iterator<Professor> itProfessores;
                        itProfessores = professores.iterator();
                        Professor auxProfessor = null;
                        boolean flagEncontrouProfessor = false;
                        
                        if (professores != null){
                           
                            itProfessores = professores.iterator();     
                            while (itProfessores.hasNext()) {  
                               auxProfessor = itProfessores.next();
                                if (auxProfessor.getCpf().equals(cpfProfessor)){
                                    flagEncontrouProfessor = true;
                                    break;
                                } 
                            }
                            if(flagEncontrouProfessor){
                                novaDisciplina.setProfessor(auxProfessor); //setando o professor dessa disciplina
                            }
                        }
                        
                        int qdtAlunosDisciplina = Integer.parseInt(ler.readLine()); //pega a quantidade de alunos dessa disciplina
                        
                        for(int j = 0; j < qdtAlunosDisciplina; j++){
                            String cpfAluno = ler.readLine();
                            int faltasAluno = Integer.parseInt(ler.readLine());
                            float notaAluno = Float.parseFloat(ler.readLine());
                            //Buscando o cpf dentro do vetor de alunos
                            Iterator<Aluno> itAlunos;
                            itAlunos = alunos.iterator();
                            if (alunos != null){
                                itAlunos = alunos.iterator(); 
                                Aluno auxAluno = null;
                                while (itAlunos.hasNext()) {  
                                    auxAluno = itAlunos.next();  
                                    if (auxAluno.getCpf().equals(cpfAluno)){
                                        novaDisciplina.insereAluno(auxAluno, notaAluno, faltasAluno);
                                        break;
                                    } 
                                }
                            }
                        } //fim do for de inserção dos alunos na disciplina
                        
                        int qtdAtividades = Integer.parseInt(ler.readLine()); //pegando todas as atividades dessa disciplina
                        if(qtdAtividades > 0){
                            for(int n = 0; n < qtdAtividades; n++){
                                String nomeAtividade = ler.readLine();
                                String tipoAtividade = ler.readLine();
                                String dataAtividade = ler.readLine();
                                float valorAtividade = Float.parseFloat(ler.readLine());
                                //System.out.println("valor "+valorAtividade);
                                int qtdAlunosDisciplina = Integer.parseInt(ler.readLine());
                                
                                boolean flagEncontrouAluno = false;
                                Atividade novaAtividade = new Atividade(nomeAtividade, tipoAtividade, dataAtividade, valorAtividade);
                                
                                for(int m = 0; m < qtdAlunosDisciplina; m++){
                                    String cpfAlunoDisciplina = ler.readLine();
                                    float notaAlunoDisciplina = Float.parseFloat(ler.readLine());
                                    //Buscando o cpf dentro do vetor de cpfs dos alunos
                                    Iterator<Aluno> itAlunos;
                                    itAlunos = alunos.iterator();
                                    if (alunos != null){
                                        itAlunos = alunos.iterator(); 
                                        Aluno auxAluno = null;
                                        while (itAlunos.hasNext()) {  
                                           auxAluno = itAlunos.next();
                                            if (auxAluno.getCpf().equals(cpfAlunoDisciplina)){  
                                                flagEncontrouAluno = true;
                                                break;
                                            } 
                                        }
                                        if(flagEncontrouAluno == true){ //caso tenha encontrado o aluno insere ele no array de alunos da turma
                                            novaAtividade.insereNotaAluno(cpfAlunoDisciplina, notaAlunoDisciplina);
                                        }
                                        flagEncontrouAluno = false;
                                    }
                                }
                                novaDisciplina.insereAtividade(novaAtividade);
                            }
                        }
                        novaTurma.insereDisciplina(novaDisciplina);
                        
                    }//fim do for de inserção das disciplinas
                    this.listaTurmas.add(novaTurma);
                }                
            }

            file.close();//Fecho o arquivo
            ler.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DisciplinaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DisciplinaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTurmas;
    }

    @Override
    public Turma verificar(int ano, int periodo) {
        if (listaTurmas.isEmpty() == true) return null;
        it = listaTurmas.iterator(); 
	while (it.hasNext()) {  
            Turma aux = it.next();  
            if (aux.getAno() == ano && aux.getPeriodo() == periodo){  
                return aux;
            }  
	}
	return null;
    }

    @Override
    public void inserir(Turma novaTurma) {
        listaTurmas.add(novaTurma);
    }

    @Override
    public boolean salvar(Turma turma) throws IOException {
        if (turma == null) return false;
	fw = new FileWriter(caminhoPasta+nomeArquivo+"_Novo.txt", true);
	bw = new BufferedWriter (fw);
	bw.write(Integer.toString(turma.getAno()));
	bw.newLine();
        bw.write(Integer.toString(turma.getPeriodo()));
	bw.newLine();
        bw.write(turma.getLocal());
	bw.newLine();
        bw.write(turma.getHorario());
	bw.newLine();
        bw.write(Integer.toString(turma.getNumero_de_vagas()));
        bw.newLine();
        
        //Salvando os alunos da turma
        ArrayList<Aluno> alunos = turma.getAlunos();
        Integer qtdAlunosTurma = alunos.size();
        bw.write(qtdAlunosTurma.toString()); //salvando quantidade de alunos
        bw.newLine();
	if(qtdAlunosTurma > 0){
            for(int j = 0; j < alunos.size(); j++){ //loop para salvar os cpfs dos alunos dessa turma
                bw.write(alunos.get(j).getCpf());
                bw.newLine();
            }
        }
        
        //Salvando as disciplinas da turma
        ArrayList<Disciplina> disciplinas = turma.getDisciplina();
        Integer qtdDisciplinas = disciplinas.size();
        bw.write(qtdDisciplinas.toString()); //salvando quantidade de disciplinas
        bw.newLine();
	if(qtdDisciplinas > 0){
            for(int j = 0; j < disciplinas.size(); j++){ //loop para salvar as disciplinas dessa turma
                bw.write(disciplinas.get(j).getCodigo()); //salvando o código da disciplina
                bw.newLine();
                bw.write(disciplinas.get(j).getProfessor().getCpf()); //salvando o cpf do professor
                bw.newLine();
                ArrayList<Aluno> alunosDisciplina = disciplinas.get(j).getAlunos();
                Integer qtdAlunosDisciplina = alunosDisciplina.size();
                bw.write(qtdAlunosDisciplina.toString()); //salvando a quantidade de alunos nessa disciplina
                bw.newLine();
                for(int k = 0; k < alunosDisciplina.size(); k++){ //salvando os alunos com as faltas e as notas dessa disciplina
                    bw.write(alunosDisciplina.get(k).getCpf()); //salvando o cpf do aluno
                    bw.newLine();
                    bw.write(Integer.toString(disciplinas.get(j).getFaltasAluno(alunosDisciplina.get(k).getCpf()))); //salvando as faltas do aluno
                    bw.newLine();
                    bw.write(Float.toString(disciplinas.get(j).getNotaAluno(alunosDisciplina.get(k).getCpf()))); //salvando a nota do aluno naquela disciplina
                    bw.newLine();
                } //terminou de salvar todos os alunos dessa disciplina
                
                ArrayList<Atividade> atividadesDisciplina = disciplinas.get(j).getAtividades(); //pega todas as atividades dessa disciplina
                Integer qtdAtividadesDisciplina = atividadesDisciplina.size();
                
                bw.write(qtdAtividadesDisciplina.toString()); //salvando a quantidade de atividades dessa disciplina
                bw.newLine();
                
                if(qtdAtividadesDisciplina > 0){ //caso tenha atividades, salva todas elas
                    for(int z = 0; z < atividadesDisciplina.size(); z++){
                        bw.write(atividadesDisciplina.get(z).getNome()); //salvando o nome da atividade
                        bw.newLine();
                        bw.write(atividadesDisciplina.get(z).getTipo()); //salvando o tipo da atividade
                        bw.newLine();
                        bw.write(atividadesDisciplina.get(z).getData()); //salvando a data da atividade
                        bw.newLine();
                        bw.write(Float.toString(atividadesDisciplina.get(z).getValor())); //salvando o valor da atividade
                        bw.newLine();
                        
                        ArrayList<Nota> notasAtividadeDisciplina = atividadesDisciplina.get(z).getNotas();
                        Integer qtdNotasAtividadesDisciplina = notasAtividadeDisciplina.size();
                        
                        bw.write(qtdNotasAtividadesDisciplina.toString()); //salvando a quantidade de notas
                        bw.newLine();
                        
                        if(qtdAlunosDisciplina > 0){
                            for(int y = 0; y < notasAtividadeDisciplina.size(); y++){ //salvando as notas na atividade
                                bw.write(notasAtividadeDisciplina.get(y).getCpf()); //salvando o cpf do aluno
                                bw.newLine();
                                bw.write(Float.toString(notasAtividadeDisciplina.get(y).getNota())); //salvando a nota do aluno nessa disciplina
                                bw.newLine();
                            }
                        }
                    }
                }
            }
        }
        
        
	bw.close();
	fw.close();
	return true;
    }

    @Override
    public boolean salvar(ArrayList<Turma> listaTurmas) throws IOException {
        if (listaTurmas.isEmpty() == true) return false;
	it = listaTurmas.iterator();
	while (it.hasNext()){
            salvar(it.next());
	}
	return true;
    }
    
     public void exibeTurmas(){
        for(int i = 0; i < listaTurmas.size(); i++){
            System.out.println("Ano: "+listaTurmas.get(i).getAno());
            System.out.println("Periodo: "+listaTurmas.get(i).getPeriodo());
            System.out.println("Local: "+listaTurmas.get(i).getLocal());
            System.out.println("Numero de vagas: "+listaTurmas.get(i).getNumero_de_vagas());
            System.out.println("Horario: "+listaTurmas.get(i).getHorario());
            
            ArrayList<Aluno> alunos = listaTurmas.get(i).getAlunos();
            ArrayList<Disciplina> disciplinas = listaTurmas.get(i).getDisciplina();
            if(alunos != null){
                System.out.println("-ALUNOS-");
                for(int j = 0; j < alunos.size(); j++){
                    System.out.println("Nome: "+alunos.get(j).getNome());
                    System.out.println("Cpf: "+alunos.get(j).getCpf());
                }
            }
            System.out.println("------------------------------");
            if(disciplinas != null){
                System.out.println("-DISCIPLINAS-");
                for(int j = 0; j < disciplinas.size(); j++){
                    System.out.println("Nome: "+disciplinas.get(j).getNome());
                    System.out.println("Ementa: "+disciplinas.get(j).getEmenta());
                    System.out.println("Codigo: "+disciplinas.get(j).getCodigo());
                    System.out.println("Carga Horaria: "+disciplinas.get(j).getCargaHoraria());
                    alunos = disciplinas.get(j).getAlunos();
                    if(alunos != null){
                        System.out.println("-ALUNOS EM "+disciplinas.get(j).getNome()+" - "+alunos.size());
                        for(int k = 0; k < alunos.size(); k++){
                            System.out.println("Nome: "+alunos.get(k).getNome());
                            System.out.println("Cpf: "+alunos.get(k).getCpf());
                            System.out.println("Faltas: "+disciplinas.get(j).getFaltasAluno(alunos.get(k).getCpf()));
                            System.out.println("Nota: "+disciplinas.get(j).getNotaAluno(alunos.get(k).getCpf()));
                        }
                    }
                    ArrayList<Atividade> atividadesExibir = disciplinas.get(j).getAtividades();
                    System.out.println("0000ATIVIDADES0000");
                    for(int z = 0; z < atividadesExibir.size(); z++){
                        atividadesExibir.get(z).exibeAtividade();
                    }
                    System.out.println("0000-----------0000");
                }
            }
            System.out.println("------------------------------");
        }
    }
     
     public ArrayList<Turma> getTurmas(){
         return listaTurmas;
     }
}

