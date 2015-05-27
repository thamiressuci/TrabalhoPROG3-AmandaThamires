/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;
import MODEL.DAO.AlunoDaoImp;
import MODEL.DAO.DisciplinaDaoImp;
import MODEL.DAO.ProfessorDaoImp;
import MODEL.DAO.TurmaDaoImp;
import VIEW.AlunoView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author thamires
 */
public class MenuView {
    AlunoDaoImp alunoGlobal;
    ProfessorDaoImp professorGlobal;
    DisciplinaDaoImp disciplinaGlobal;
    TurmaDaoImp turmaGlobal;
    
    AlunoView menuAluno;
    ProfessorView menuProfessor;
    DisciplinaView menuDisciplina;
    TurmaView menuTurma;
    AtividadeView menuAtividade;
    private static Scanner entrada;
    
    public MenuView() throws FileNotFoundException, IOException{
        
        //inicializando as disciplinas
        disciplinaGlobal = new DisciplinaDaoImp();
        disciplinaGlobal.ler();
        
        //inicializando os alunos
        alunoGlobal = new AlunoDaoImp();
        alunoGlobal.ler();
        
        //inicializando professores
        professorGlobal = new ProfessorDaoImp();
        professorGlobal.ler(disciplinaGlobal.getListaDisciplinas());
        
        //inicializando as turmas
        turmaGlobal = new TurmaDaoImp();
        turmaGlobal.ler(alunoGlobal.getListaAlunos(), professorGlobal.getListaProfessores(), disciplinaGlobal.getListaDisciplinas());
        
        //inicializando o menu
        menuAluno = new AlunoView(alunoGlobal);
        menuProfessor = new ProfessorView(professorGlobal);
        menuDisciplina = new DisciplinaView(disciplinaGlobal);
        menuTurma = new TurmaView(turmaGlobal);
        menuAtividade = new AtividadeView();
        entrada = new Scanner(System.in);
    }
    
    public void getOperacao() throws IOException{
        this.exibeMenu();
        Integer operacao = Integer.parseInt(entrada.nextLine());
        if(operacao == 1){ //caso seja a operação de cadastro do aluno
            menuAluno.cadastrarAluno();
        }
        if(operacao == 2){ //caso seja a operação de cadastro de professor
            menuProfessor.cadastrarProfessor();
        }
        if(operacao == 3){ //operacao de cadastro de disciplina no sistema
            menuDisciplina.cadastrarDisciplina();
        }
        if(operacao == 4){ //operacao de cadastro de turmas
            menuTurma.cadastrarTurma(disciplinaGlobal.getListaDisciplinas(), professorGlobal.getListaProfessores(), alunoGlobal.getListaAlunos());
        }
        if(operacao == 5){
            menuAtividade.cadastrarAtividade(turmaGlobal.getTurmas());
        }
        
        
        if(operacao == 0){ //sai do menu
            return;
        }
        this.getOperacao();
    }
    
    public void exibeMenu(){
        System.out.println("1. Cadastro de alunos: Nome, CPF.");
        System.out.println("2. Cadastro de professores: Nome, CPF, Departamento.");
        System.out.println("3. Cadastro de disciplinas: Nome, Ementa, Carga Horaria.");
        System.out.println("4. Cadastro de turmas: Ano, Periodo, Local, Horario, Numero de Vagas.");
        System.out.println("5. Cadastro de atividades: Nome, Tipo, Data, Valor.");
        System.out.println("6. Lancamento de notas: Nota.");
        System.out.println("7. Lancamento do numero total de faltas: numero de faltas para um aluno.");
        System.out.print("Operacao: ");
    }
}
