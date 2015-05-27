/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;
import MODEL.POJO.Falta;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author thamires
 */
public interface ArqFalta {
   public ArrayList<Falta> ler() throws IOException;
   Falta verificar (String cpf);
   void inserir (String qtd, String cpf);
   boolean salvar(Falta atividade) throws IOException; // salva no arquivo
   boolean salvar(ArrayList<Falta> lista) throws IOException; // salva no vetor
    
}

