/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.DAO.DisciplinaDaoImp;
import MODEL.DAO.VerificacaoDaoImp;
import MODEL.POJO.Disciplina;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author thamires
 */
public class DisciplinaView {
    private static  Scanner entrada = new Scanner(System.in);
    private DisciplinaDaoImp disciplinaDaoImp;
    public DisciplinaView (DisciplinaDaoImp disciplinaDaoImp){
	this.disciplinaDaoImp = disciplinaDaoImp;
    }
    public Scanner getEntrada() {
           return entrada;
    }
    public void setEntrada(Scanner entrada) {
	DisciplinaView.entrada = entrada;
    }
    public void cadastrarDisciplina() throws IOException{
		//Verificacoes
		VerificacaoDaoImp verificacoes = new VerificacaoDaoImp();
		System.out.print("Digite o nome da Disciplina: ");
		String nome = entrada.nextLine();
		while (verificacoes.verificarStringVazia(nome)){
			System.out.println("Nome da disciplina nao aceita, digite novamente o nome da Disciplina: ");
			nome = entrada.nextLine();
		}	
                if (disciplinaDaoImp.verificar(nome) != null){
			System.out.println("Disciplina ja esta cadastrada!");
			return;
		}else{
                    System.out.print("Digite a ementa da Disciplina: ");
                    String ementa = entrada.nextLine();
                    while (verificacoes.verificarStringVazia(ementa)){
                            System.out.println("Ementa nao aceita, digite novamente: ");
                            ementa = entrada.nextLine();
                    }

                    System.out.print("Digite o codigo da Disciplina: ");
                    String codigo = entrada.nextLine();
                    while (verificacoes.verificarStringVazia(codigo)){
                            System.out.println("Codigo nao aceita, digite novamente: ");
                            ementa = entrada.nextLine();
                    }

                    System.out.print("Digite a carga horária da Disciplina: ");
                    String cargaHoraria = entrada.nextLine();
                    while (verificacoes.verificarStringVazia(cargaHoraria)){
                            System.out.println("Carga horaria nao aceita, digite novamente: ");
                            cargaHoraria = entrada.nextLine();
                    }
                    disciplinaDaoImp.inserir(nome, ementa, codigo, cargaHoraria);
                    disciplinaDaoImp.salvar(disciplinaDaoImp.getListaDisciplinas()); //salva todas as disciplinas do sistema
                    System.out.println("Disciplina cadastrada com sucesso!");
                }
                return;
    }
     /*public boolean cosultarDisciplina(Disciplina disciplina){
        Disciplina disciplinaPes = disciplinaDaoImp.pesquisarDisciplina(new Disciplina (null, null, disciplina.getCodigo(), null));
        if(disciplinaPes.getNome() == null)
        {
            return false;
        }
       return true;
        
    }*/

}

