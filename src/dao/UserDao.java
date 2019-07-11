package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.User;

public class UserDao implements IDao<User> {
	private Connection conn;
	private PreparedStatement query;
	private ResultSet rs;
	private String sql;
	private Alert alert;

	/**
	 * peocura o clinete pelo email
	 * 
	 * @param email
	 * @return
	 */
	public User procuraEmail(String email) {
		User user = null;

		conn = Conexao.abrirConexao();
		sql = "select * from user where email = ?";

		try {
	
			query = conn.prepareStatement(sql);
			query.setString(1, email.toString());
			rs = query.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setNome(rs.getString("nome"));
				user.setSobreNome(rs.getString("sobreNome"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			throw new RuntimeException("erro " + e);

		} finally {
			Conexao.fecharConexao(conn, query, rs);
		}
		return user;
	}

	@Override
	public boolean insert(User obj) {
		User user = procuraEmail(obj.getEmail());

		conn = Conexao.abrirConexao();

		sql = "INSERT INTO user (nome, sobreNome, email) value (?,?,?)";
		boolean resultado = false;

		if (user != null) {
			alert = new Alert(AlertType.ERROR, "Esse email já está cadastrado. tente outro");
			alert.setTitle("erro");
			alert.show();
			return resultado;
		}
		try {
			query = conn.prepareStatement(sql);
			query.setString(1, obj.getNome());
			query.setString(2, obj.getSobreNome());
			query.setString(3, obj.getEmail());
			
			int verifica = query.executeUpdate();
		
			if (verifica > 0) {
				alert = new Alert(AlertType.CONFIRMATION, "Usuario cadastrado com sucesso");
				alert.setTitle("Sucesso");
				alert.show();
				return true;
			
			}

		} catch (SQLException e) {

			throw new RuntimeException("erro");
		} finally {
			Conexao.fecharConexao(conn, query, rs);
		}

		return false;
	}

	@Override
	public boolean delete(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User valor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
