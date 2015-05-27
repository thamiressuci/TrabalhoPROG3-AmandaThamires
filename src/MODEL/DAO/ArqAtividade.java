/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import MODEL.POJO.Atividade;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author thamires
 */
public interface ArqAtividade {
   public ArrayList<Atividade> ler() throws IOException;
   Atividade verificar (String tipo);
   void inserir (String nome, String tipo, String data, String valor);
   boolean salvar(Atividade atividade) throws IOException; // salva no arquivo
   boolean salvar(ArrayList<Atividade> lista) throws IOException; // salva no vetor
    
} 

