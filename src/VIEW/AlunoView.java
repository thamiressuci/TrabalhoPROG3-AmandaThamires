/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.DAO.AlunoDaoImp;
import MODEL.DAO.VerificacaoDaoImp;
import MODEL.POJO.Aluno;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author thamires
 */
public class AlunoView {
        private static Scanner entrada;
	private AlunoDaoImp alunoDaoImp;
        
	public AlunoView (AlunoDaoImp alunoDaoImp){
		this.alunoDaoImp = alunoDaoImp;
                entrada = new Scanner(System.in);
	}
	public Scanner getEntrada() {
		return entrada;
        }
	public  void setEntrada(Scanner entrada) {
		AlunoView.entrada = entrada;
	}
        
        public void cadastrarAluno() throws IOException{
        VerificacaoDaoImp verificacao = new VerificacaoDaoImp();
        System.out.println("Cadastro de alunos");
        System.out.print("Informe o nome: ");
        String nome = entrada.nextLine();
	while (verificacao.verificarStringVazia(nome)|| verificacao.verificarStringSoNumeros(nome)){
		System.out.println("Nome do aluno nao aceito, digite o nome o alunos novamente: ");
		nome = entrada.nextLine();
	}
        System.out.print("Digite o CPF: ");
	String cpf = entrada.nextLine();
	while (verificacao.verificarCpf(cpf) == false){
            System.out.println("CPF invalido, digite o CPF novamente: ");
		cpf = entrada.nextLine();
	}
        
	if (alunoDaoImp.verificar(cpf) != null){
		System.out.println("Aluno ja cadastrado!");
		return;
	}
        alunoDaoImp.inserir(nome, cpf);
        alunoDaoImp.salvar(alunoDaoImp.getListaAlunos());
        System.out.println("Aluno cadastrado com sucesso!");
   
     return;
    }
    
    public void listarAluno() {
        Iterator<Aluno> it;
        ArrayList<Aluno>listar = alunoDaoImp.getListaAlunos(); 
        if (listar.isEmpty() == true) return;
        it = listar.iterator();
        while (it.hasNext()) {  
                Aluno aux = it.next();  
                System.out.println("Nome:"+aux.getNome());
                System.out.println("CPF:"+aux.getCpf());
        }
        return;
    }
    
   /* public boolean cosultarAluno(Aluno aluno){
        Aluno alunoPes = alunoDaoImp.pesquisarAluno(new Aluno (null, aluno.getCpf()));
        if(alunoPes.getNome() == null)
        {
            return false;
        }
       return true;
        
    }
   */ 
    
   
}

