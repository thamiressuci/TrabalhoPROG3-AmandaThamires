/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import MODEL.POJO.Aluno;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author DESTRUTOR
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        // INICIALIZAÇÃO DOS DADOS DA DISCIPLINA
        DisciplinaDaoImp testeDisc; //como se fosse uma váriavel global '-'
        testeDisc = new DisciplinaDaoImp();
        testeDisc.inserir("Prog 3", "Orientação a objetos, controle de erros e etc", "341", "60 horas");
        testeDisc.ler();
        testeDisc.salvar(testeDisc.getListaDisciplinas());
        //testeDisc.exibeDisciplinas();
        
        //INICIALIZAÇÃO DOS DADOS DO PROFESSOR
        ProfessorDaoImp testeProfessor; //como se fosse uma váriavel global '-'
        testeProfessor = new ProfessorDaoImp();
        testeProfessor.inserir("Hayley Williams", "000.000.000-00", "PARAMORES");
        testeProfessor.ler(testeDisc.getListaDisciplinas());
        //testeProfessor.salvar();
        //testeProfessor.exibeProfessores();
        
        //INICIALIZA DADOS DO ALUNO
        AlunoDaoImp testeAluno; //como se fosse uma váriavel global '-'
        testeAluno = new AlunoDaoImp();
        testeAluno.ler();
        testeAluno.inserir("Charlie XCX", "666.666.666-66");
        //testeAluno.salvar(testeAluno.getListaAlunos());
        //testeAluno.exibeAlunos();
        
        //INICIALIZA DADOS DA TURMA
        TurmaDaoImp testeTurma; //como se fosse uma váriavel global '-'
        testeTurma = new TurmaDaoImp();
        testeTurma.ler(testeAluno.getListaAlunos(),testeProfessor.getListaProfessores(), testeDisc.getListaDisciplinas());
        //testeTurma.inserir("Charlie XCX", "666.666.666-66");
        testeTurma.exibeTurmas();
        testeTurma.salvar(testeTurma.getTurmas());
        
    }
}
