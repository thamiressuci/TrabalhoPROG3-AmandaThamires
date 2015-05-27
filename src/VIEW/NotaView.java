/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.DAO.NotasDaoImp;
import MODEL.DAO.VerificacaoDaoImp;
import MODEL.POJO.Nota;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author thamires
 */
public class NotaView {
        static  Scanner entrada = new Scanner(System.in);
        private NotasDaoImp faltaDaoImp;
        public NotaView (NotasDaoImp notasDaoImp){
            this.faltaDaoImp = notasDaoImp;
        }
        public Scanner getEntrada() {
           return entrada;
        }
        public void setEntrada(Scanner entrada) {
            FaltaView.entrada = entrada;
        }
    
    public void cadastrarFalta() throws IOException{
		//Verificacoes
		VerificacaoDaoImp verificacoes = new VerificacaoDaoImp();
		System.out.println("Digite a nota do aluno: ");
		String notas = entrada.nextLine();
		while (verificacoes.verificarStringVazia(notas)){
			System.out.println("Nota nao aceita, digite novamente: ");
			notas = entrada.nextLine();
		}
                System.out.println("Digite o CPF do aluno: ");
		String cpf = entrada.nextLine();
		while (verificacoes.verificarCpf(cpf) == false){
                    System.out.println("CPF invalido, digite o CPF novamente: ");
                    cpf = entrada.nextLine();
                }
    }
     public void listarNota() {
		Iterator<Nota> it;
		ArrayList<Nota>listar = faltaDaoImp.getListaNotas(); 
		if (listar.isEmpty() == true) return;
		it = listar.iterator();
		while (it.hasNext()) {  
			Nota aux = it.next();  
			System.out.println("Nota:"+aux.getNota());
			System.out.println("CPF:"+aux.getCpf());
		}
		return;
    }
}

