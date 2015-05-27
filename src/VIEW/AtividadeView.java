/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.DAO.AtividadeDaoImp;
import MODEL.DAO.VerificacaoDaoImp;
import MODEL.POJO.Atividade;
import MODEL.POJO.Disciplina;
import MODEL.POJO.Turma;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author thamires
 */
public class AtividadeView {
    private static Scanner entrada = new Scanner(System.in);
	public AtividadeView (){
            //construtor vazio
	}
	public Scanner getEntrada() {
		return entrada;
	}
	public void setEntrada(Scanner entrada) {
		AtividadeView.entrada = entrada;
	}
        public void cadastrarAtividade(ArrayList<Turma> turmas){
            VerificacaoDaoImp verificacao = new VerificacaoDaoImp();
            System.out.println("Cadastro de atividades");
            System.out.print("Informe o ano da turma que quer inserir a atividade: ");
            Integer anoTurma = Integer.parseInt(entrada.nextLine());
            while (anoTurma < 0 || anoTurma == null || anoTurma.toString().equals("")){
                    System.out.println("Ano da turma nao aceito, digite novamente: ");
                    anoTurma = Integer.parseInt(entrada.nextLine());
            }

            System.out.print("Informe o periodo da turma que quer inserir a atividade: ");
            Integer periodoTurma = Integer.parseInt(entrada.nextLine());
            while (periodoTurma < 0 || periodoTurma == null || periodoTurma.toString().equals("")){
                    System.out.println("Periodo da turma nao aceito, digite novamente: ");
                    periodoTurma = Integer.parseInt(entrada.nextLine());
            }
            
            Turma turmaAtividade = null;
            turmaAtividade = this.verificarTurma(anoTurma, periodoTurma, turmas);
            
            if(turmaAtividade != null){
                ArrayList<Disciplina> disciplinasTurma = turmaAtividade.getDisciplina();
                if(disciplinasTurma != null && disciplinasTurma.size() > 0){
                    System.out.println("Esta turma tem as seguinte disciplinas: ");
                    for(int b = 0; b < disciplinasTurma.size(); b++){
                        System.out.println("Cod: "+disciplinasTurma.get(b).getCodigo()+" - Nome: "+disciplinasTurma.get(b).getNome());
                    }
                    System.out.print("Informe o Codigo da disciplina para adicionar a Atividade: ");
                    String codDisciplina = entrada.nextLine();
                    Disciplina auxDisciplina = this.verificaDisciplina(codDisciplina, disciplinasTurma);
                    
                    while (codDisciplina == null || codDisciplina.equals("") || auxDisciplina == null){
                            System.out.println("Codigo da disciplina nao aceito, digite novamente: ");
                            codDisciplina = entrada.nextLine();
                            auxDisciplina = this.verificaDisciplina(codDisciplina, disciplinasTurma);
                    }
                    
                    System.out.print("Informe o nome da Atividade: ");
                    String nome = entrada.nextLine();
                    while (verificacao.verificarStringVazia(nome) || verificacao.verificarStringSoNumeros(nome)){
                            System.out.println("Nome de atividade nao aceito, digite o nome da atividade novamente: ");
                            nome = entrada.nextLine();
                    }
                    System.out.print("Informe o tipo: "); 
                    String tipo = entrada.nextLine();
                    while (verificacao.verificarStringVazia(tipo)|| verificacao.verificarStringSoNumeros(tipo)){
                            System.out.println("Tipo de atividade nao aceito, digite o tipo da atividade novamente: ");
                            tipo = entrada.nextLine();
                    }
                    System.out.print("Informe a data: "); 
                    String data = entrada.nextLine();
                    while (verificacao.verificarStringVazia(data)){
                            System.out.println("Data não aceita, digite novamente ");
                            data = entrada.nextLine();
                    }
                    System.out.print("Informe o valor: "); 
                    Float valor = Float.parseFloat(entrada.nextLine());
                    Atividade novaAtividade = new Atividade(nome, tipo, data, valor);
                    auxDisciplina.insereAtividade(novaAtividade);
                    System.out.println("Atividade cadastrado com sucesso!");
                }else{
                    System.out.print("Essa turma não possui disciplinas, cadastre disciplinas nesta turma para prosseguir.");
                }
            }else{
                System.out.println("Turma nao encontrada!");
            }
                        
            return;	
   
    }
    
    public void listarAtividades() {
//		Iterator<Atividade> it;
//		ArrayList<Atividade>listar = atividadeDaoImp.getListaAtividades(); 
//		if (listar.isEmpty() == true) return;
//		it = listar.iterator();
//		while (it.hasNext()) {  
//			Atividade aux = it.next();  
//			System.out.println("Nome:"+aux.getNome());
//			System.out.println("Tipo:"+aux.getTipo());
//                        System.out.println("Data:"+aux.getData());
//                        System.out.println("Valor:"+aux.getValor());
//		}
//		return;
    }
    
    public void pesquisar(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o tipo:");
        
    }
    
    public Turma verificarTurma(int ano, int periodo, ArrayList<Turma> listaTurmas) {
        Iterator<Turma> it;
        if (listaTurmas.isEmpty() == true) return null;
        it = listaTurmas.iterator(); 
	while (it.hasNext()) {  
            Turma aux = it.next();  
            if (aux.getAno() == ano && aux.getPeriodo() == periodo){  
                return aux;
            }  
	}
	return null;
    }
    
    public Disciplina verificaDisciplina(String codigo, ArrayList<Disciplina> disciplinas){
        Iterator<Disciplina> it;
        if (disciplinas.isEmpty() == true) return null;
        it = disciplinas.iterator(); 
	while (it.hasNext()) {  
            Disciplina aux = it.next();  
            if (aux.getCodigo().equals(codigo)){  
                return aux;
            }  
	}
	return null;
    }
   
}

