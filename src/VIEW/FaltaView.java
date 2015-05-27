/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.DAO.FaltaDaoImp;
import MODEL.DAO.VerificacaoDaoImp;
import MODEL.POJO.Falta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author thamires
 */
public class FaltaView {
    static  Scanner entrada = new Scanner(System.in);
    private FaltaDaoImp faltaDaoImp;
    public FaltaView (FaltaDaoImp faltaDaoImp){
	this.faltaDaoImp = faltaDaoImp;
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
		System.out.println("Digite a quantidade de faltas do aluno: ");
		String faltas = entrada.nextLine();
		while (verificacoes.verificarStringVazia(faltas)){
			System.out.println("Quantidade de faltas nao aceita, digite novamente: ");
			faltas = entrada.nextLine();
		}
                System.out.println("Digite o CPF do aluno: ");
		String cpf = entrada.nextLine();
		while (verificacoes.verificarCpf(cpf) == false){
                    System.out.println("CPF invalido, digite o CPF novamente: ");
                    cpf = entrada.nextLine();
                }
    }
     public void listarFalta() {
		Iterator<Falta> it;
		ArrayList<Falta>listar = faltaDaoImp.getListaFaltas(); 
		if (listar.isEmpty() == true) return;
		it = listar.iterator();
		while (it.hasNext()) {  
			Falta aux = it.next();  
			System.out.println("Quantidade de faltas:"+aux.getQtd());
			System.out.println("CPF:"+aux.getCpf());
		}
		return;
    }


}
