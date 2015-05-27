/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.DAO.ProfessorDaoImp;
import MODEL.DAO.VerificacaoDaoImp;
import MODEL.POJO.Professor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author thamires
 */
public class ProfessorView {
    private static Scanner entrada = new Scanner(System.in);
    private ProfessorDaoImp professorDaoImp;
    public ProfessorView (ProfessorDaoImp professorDaoImp){
        this.professorDaoImp = professorDaoImp;
    }
    public Scanner getEntrada() {
        return entrada;
    }
    public void setEntrada(Scanner entrada) {
	ProfessorView.entrada = entrada;
    }

    public String cadastrarProfessor() throws IOException{
        VerificacaoDaoImp verificacao = new VerificacaoDaoImp();
        System.out.println("Cadastro de professores");
        System.out.print("Informe o nome: ");
        String nome = entrada.nextLine();
	while (verificacao.verificarStringVazia(nome) || verificacao.verificarStringSoNumeros(nome)){
		System.out.println("Nome do professor nao aceito, digite o nome do professor novamente: ");
		nome = entrada.nextLine();
	}
        System.out.print("Digite o CPF: ");
	String cpf = entrada.nextLine();
	while (verificacao.verificarCpf(cpf) == false){
            System.out.println("CPF invalido, digite o CPF novamente: ");
		cpf = entrada.nextLine();
	}
	if (professorDaoImp.verificar(cpf) != null){
            System.out.println("Professor ja cadastrado!");
	}else{
            System.out.print("Digite o departamento do professor: ");
            String departamento = entrada.nextLine();
            while (verificacao.verificarStringVazia(departamento)){
                System.out.println("Departamento não aceito, digite novamente.");
                departamento = entrada.nextLine();
            }   
            professorDaoImp.inserir(nome, cpf, departamento);
            professorDaoImp.salvar();
            System.out.println("Professor cadastrado com sucesso!");
        }
        
        return null;

    }
       
    public void listarProfessor() {
            Iterator<Professor> it;
            ArrayList<Professor>listar = professorDaoImp.getListaProfessores(); 
            if (listar.isEmpty() == true) return;
            it = listar.iterator();
            while (it.hasNext()) {  
                    Professor aux = it.next();  
                    System.out.println("Nome:"+aux.getNome());
                    System.out.println("CPF:"+aux.getCpf());
            }
            return;
    }
//    public boolean cosultarProfessor(Professor professor){
//        Professor professorPes = professorDaoImp.pesquisarProfessor(new Professor (null, professor.getCpf(), null));
//        if(professorPes.getNome() == null)
//        {
//            return false;
//        }
//       return true;
//        
//    }

} 

