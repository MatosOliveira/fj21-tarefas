/**
 * 
 */
package br.com.caelum.tarefa.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.tarefa.factory.ConnectionFactory;

/**
 * @author Matos
 *
 */
public class TesteConexao {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException{
		
		Connection con = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta!");
		con.close();

	}

}
