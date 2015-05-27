/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import MODEL.POJO.Aluno;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author thamires
 */
    public interface ArqAluno {
        Aluno verificar (String cpf);
        public void ler()throws FileNotFoundException;    
        void inserir (String nome, String cpf);
        boolean salvar(Aluno aluno) throws IOException; // salva no arquivo
        boolean salvar(ArrayList<Aluno> lista) throws IOException;
}

