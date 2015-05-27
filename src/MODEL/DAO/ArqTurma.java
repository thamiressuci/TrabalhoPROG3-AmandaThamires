/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import MODEL.POJO.Aluno;
import MODEL.POJO.Disciplina;
import MODEL.POJO.Professor;
import MODEL.POJO.Turma;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author thamires
 */
public interface ArqTurma {
    ArrayList<Turma> ler(ArrayList<Aluno> alunos, ArrayList<Professor> professores, ArrayList<Disciplina> disciplinas) throws IOException;
    Turma verificar (int ano, int periodo);
    void inserir (Turma novaTurma);
    boolean salvar(Turma turma) throws IOException; // salva no arquivo
    boolean salvar(ArrayList<Turma> listaTurmas) throws IOException; // salva no vetor	
}
