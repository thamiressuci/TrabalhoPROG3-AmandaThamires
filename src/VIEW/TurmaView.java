/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.DAO.ProfessorDaoImp;
import MODEL.DAO.TurmaDaoImp;
import MODEL.DAO.VerificacaoDaoImp;
import MODEL.POJO.Aluno;
import MODEL.POJO.Disciplina;
import MODEL.POJO.Professor;
import MODEL.POJO.Turma;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author thamires
 */
public class TurmaView {
    private static Scanner entrada;
    private TurmaDaoImp turmaDaoImp;
    public TurmaView (TurmaDaoImp turmaDaoImp){
        this.turmaDaoImp = turmaDaoImp;
         entrada = new Scanner(System.in);
    }
    public Scanner getEntrada() {
        return entrada;
    }
    public void setEntrada(Scanner entrada) {
	TurmaView.entrada = entrada;
    }
    
     public String cadastrarTurma(ArrayList<Disciplina> disciplinas, ArrayList<Professor> professores, ArrayList<Aluno> alunos) throws IOException{
        VerificacaoDaoImp verificacao = new VerificacaoDaoImp();
        System.out.println("Cadastro de Turmas");
        System.out.print("Informe o Ano: ");
        Integer ano = Integer.parseInt(entrada.nextLine());
	while (ano < 0 || ano == null || ano.toString().equals("")){
		System.out.println("Ano da turma nao aceito, digite novamente: ");
		ano = Integer.parseInt(entrada.nextLine());
	}
        
        System.out.print("Informe o Periodo: ");
        Integer periodo = Integer.parseInt(entrada.nextLine());
	while (periodo < 0 || periodo == null || periodo.toString().equals("")){
		System.out.println("Periodo da turma nao aceito, digite novamente: ");
		periodo = Integer.parseInt(entrada.nextLine());
	}
        
        System.out.print("Informe o Local: ");
        String local = entrada.nextLine();
	while (local.equals("") || local == null){
		System.out.println("Local da turma nao aceito, digite novamente: ");
		local = entrada.nextLine();
	}
        
        System.out.print("Informe o Horario: ");
        String horario = entrada.nextLine();
	while (horario.equals("") || horario == null){
		System.out.println("Horario da turma nao aceito, digite novamente: ");
		horario = entrada.nextLine();
	}
        
        System.out.print("Informe o Numero de vagas: ");
        Integer numeroDeVagas = Integer.parseInt(entrada.nextLine());
	while (numeroDeVagas < 0 || numeroDeVagas == null || numeroDeVagas.toString().equals("")){
		System.out.println("Numero de vagas da turma nao aceito, digite novamente: ");
		numeroDeVagas = Integer.parseInt(entrada.nextLine());
	}
        System.out.println("Deseja inserir Alunos na turma? (1 - Sim ou 0 - Nao)");
        Integer opAlunos = Integer.parseInt(entrada.nextLine());
        Turma novaTurma = new Turma(ano, periodo, local, horario, numeroDeVagas);
        while(opAlunos == 1){
            if(alunos.size() > 0){
                System.out.println("Alunos no sistema");
                for(int x = 0; x < alunos.size(); x++){
                    System.out.println("CPF: "+alunos.get(x).getCpf()+" - Nome: "+alunos.get(x).getNome());
                }
                System.out.print("Informe o CPF do aluno para inserir na turma: ");
                String cpfAlunoTurma = entrada.nextLine();
                Aluno auxAlunoTurma = verificarAlunoLista(cpfAlunoTurma, alunos);
                if(auxAlunoTurma != null){
                    System.out.println(cpfAlunoTurma+" - Inserido na turma com sucesso!");
                    novaTurma.insereAluno(auxAlunoTurma);
                }
            }
            System.out.println("Deseja inserir Alunos na turma? (1 - Sim ou 0 - Nao)");
            opAlunos = Integer.parseInt(entrada.nextLine());
        }
	turmaDaoImp.inserir(novaTurma);
        turmaDaoImp.salvar(turmaDaoImp.getTurmas());
        System.out.println("Turma cadastrada com sucesso!");
        
        return null;

    }
     public Aluno verificarAlunoLista (String cpf, ArrayList<Aluno> listaAlunos){//verifica se o cpf ta salvo na lista de alunos
	Iterator<Aluno> it;
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
}
