/**
 * 
 */
package br.com.caelum.tarefa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Matos
 *
 */
@Controller
public class OlaMundoController {

	@RequestMapping("/olaMundoSpring")
	public String execute() {
		System.out.println("Executando a l�gica com Spring MVC");
		return "ok";
	}
}
