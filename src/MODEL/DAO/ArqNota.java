/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;


import MODEL.POJO.Nota;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author thamires
 */
public interface ArqNota {
   public ArrayList<Nota> ler() throws IOException;
   Nota verificar (String cpf);
   void inserir (int nota, String cpf);
   boolean salvar(Nota notas) throws IOException; // salva no arquivo
   boolean salvar(ArrayList<Nota> lista) throws IOException; // salva no vetor
}
