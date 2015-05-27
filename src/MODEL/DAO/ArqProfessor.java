/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;


import MODEL.POJO.Disciplina;
import MODEL.POJO.Professor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author thamires
 */
public interface ArqProfessor {
   public ArrayList<Professor> ler(ArrayList<Disciplina> disciplinas) throws IOException;
   public Professor verificar (String cpf);
   public void inserir (String nome, String cpf, String departamento);
   public boolean salvar() throws IOException; // salva no arquivo
}


