/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import MODEL.POJO.Disciplina;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author thamires
 */
public interface ArqDisciplina {
    ArrayList<Disciplina> ler() throws IOException;
    Disciplina verificar (String nome);
    void inserir (String nome, String ementa, String codigo, String cargaHoraria);
    boolean salvar(Disciplina disciplina) throws IOException; // salva no arquivo
    boolean salvar(ArrayList<Disciplina> disciplinas) throws IOException; // salva no vetor	
}

