/**
 * 
 */
package br.com.caelum.tarefa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.tarefa.exception.DAOException;
import br.com.caelum.tarefa.factory.ConnectionFactory;
import br.com.caelum.tarefa.modelo.Tarefa;

/**
 * DAO da classe Tarefa
 * 
 * @author Matos
 *
 */
public class TarefaDAO {

	private Connection connection;
	
	/**
	* Construtor da classe
	*/
	public TarefaDAO() {
		connection = new ConnectionFactory().getConnection();
	}
	
	/**
	 * Construtor da classe que recebe e armazena o atributo connection
	 */
	public TarefaDAO(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * Inclue um tarefa no banco de dados
	 * 
	 * @param tarefa
	 * 		Objeto da classe Tarefa
	 */
	public void adicionaTarefa(Tarefa tarefa) {
		
		//String sql = "insert into Tarefas (descricao, finalizado, dataFinalizacao) values (?,?,?)";
		
		String sql = "insert into Tarefas (descricao) values (?)";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, tarefa.getDescricao());
			//stmt.setBoolean(2, tarefa.isFinalizado());
			//stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * Obtem a lista de tarefas cadastradas no banco de dados
	 * 
	 * @return
	 * 		Lista de tarefas
	 */
	public List<Tarefa> getLista() {
		
		try {
			
			List<Tarefa> lista = new ArrayList<Tarefa>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from Tarefas");
			
			//Pesquisa refinada com a utilização de where
			//PreparedStatement stmt = this.connection.prepareStatement("select * from Tarefass where nome like 'P%'");
			
			ResultSet rs = stmt.executeQuery();
			
			//Cursor
			while(rs.next()) {
				
				Tarefa tarefa = new Tarefa();
				//montagem do objeto
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
				
				//monta data
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataFinalizacao"));
				tarefa.setDataFinalizacao(data);
				
				//adicionando o objeto a lista
				lista.add(tarefa);
			}
			
			rs.close();
			stmt.close();
			
			return lista;
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage()) ;
		}
	}
	
	/**
	 * Obtem a lista de tarefas cadastrados no banco de dados
	 * 
	 * @return
	 * 		Lista de tarefas
	 */
	public Tarefa getTarefa(int id) {
		
		try {
			
			Tarefa tarefa = new Tarefa();
			PreparedStatement stmt = this.connection.prepareStatement("select * from Tarefas where id=5");
			ResultSet rs = stmt.executeQuery();
			
			//Cursor
			while(rs.next()) { 
				
				//montagem do objeto
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
				
				//monta data
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				tarefa.setDataFinalizacao(data);
			
			}
			
			rs.close();
			stmt.close();
			
			return tarefa;
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage()) ;
		}
	}
	
	/**
	 * Altera os dados da tarefa
	 * 
	 * @param tarefa
	 * 			Objeto da classe Tarefa
	 */
	public void altera(Tarefa tarefa) {
		
		String sql = "update tarefas set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			stmt.setLong(4, tarefa.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * Remove uma tarefa
	 * 
	 * @param tarefa
	 * 		Objeto da classe tarefa
	 */
	public void remove(Tarefa tarefa){
		
		String sql = "delete from tarefas where id=?";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, tarefa.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}
}
