/**
 * 
 */
package br.com.caelum.tarefa.exception;

/**
 * @author Matos
 *
 */
public class DAOException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DAOException() {
		super("Causa do erro desconhecida");
	}
	
	public DAOException(String message) {
		super(message);
	}
}
