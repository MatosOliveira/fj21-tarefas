/**
 * 
 */
package br.com.caelum.tarefa.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Matos
 *
 */
public class ConnectionFactory {

public Connection getConnection () {
		
		System.out.println("Conectando ao banco...");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "Matuska@@35");
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
