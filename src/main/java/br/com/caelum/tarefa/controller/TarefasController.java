/**
 * 
 */
package br.com.caelum.tarefa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefa.dao.TarefaDAO;
import br.com.caelum.tarefa.modelo.Tarefa;

/**
 * Classe que fará o controle de acesso às páginas jsp e as chamadas para o banco de dados
 * 
 * @author Matos
 *
 */
@Controller
public class TarefasController {

	/**
	 * Metodo para chamar a pagina do formulario
	 * 
	 * @return
	 * 	Pagina JSP do Formulario
	 */
	@RequestMapping("novaTarefa")
	public String form(){
		return "tarefa/formulario";
	}
	
	/**
	 * Metodo para adicionar tarefas no banco de dados
	 * 
	 * @param tarefa
	 * 		Objeto do tipo Tarefa
	 * @return
	 * 		Pagina JSP de tarefa adicionada
	 */
	@RequestMapping("adicionaTarefa")
	public String adiciona(Tarefa tarefa){
		TarefaDAO dao = new TarefaDAO();
		dao.adicionaTarefa(tarefa);
		return "tarefa/adicionada";
	}
}
