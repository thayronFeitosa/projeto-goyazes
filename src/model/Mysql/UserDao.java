package model.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.AlertBox;
import model.IUser;
import model.User;

public class UserDao  extends Conexao implements IUser {
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
				user.setEmail(rs.getString("email"));
				user.setSenha(rs.getString("senha"));
			}
		} catch (SQLException e) {
			throw new RuntimeException("erro " + e);

		} finally {
			Conexao.fecharConexao(conn, query, rs);
		}
		return user;
	}

	
	public boolean insert(User obj) {
		User user = procuraEmail(obj.getEmail());

		conn = Conexao.abrirConexao();

		sql = "INSERT INTO user (nome, email, senha, acesso) value (?,?,?,?)";
		boolean resultado = false;
 
		if (isEmpty(obj) == true) {
			return false;
		}
		
		if (user != null) {
			alert = new Alert(AlertType.ERROR, "Esse email já está cadastrado. tente outro");
			alert.setTitle("erro");
			alert.show();
			return resultado;
		}
		try {
			query = conn.prepareStatement(sql);
			query.setString(1, obj.getNome());
			query.setString(2, obj.getEmail());
			query.setString(3, obj.getSenha());
			query.setInt(4, obj.getAcesso());
			
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
	public void create(User user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<User> all() {
		// TODO Auto-generated method stub
		return null;
	}


	public User buscarUsuario(String mail,String senha) {
		User u = null;
		sql = "SELECT * FROM user WHERE email = ? and senha = ?";
		conn = Conexao.abrirConexao();
		
		try {
			query = conn.prepareStatement(sql);
			query.setString(1, mail);
			query.setString(2, senha);
			rs = query.executeQuery();
			if(rs.next()) {
				u = new User();
				u.setId_user(rs.getInt("id_user"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
				u.setAcesso(rs.getInt("acesso"));
			}
		} catch (SQLException e) {
			e.getMessage();
			throw new RuntimeException(e);
		}
		return u;
	}
    @Override
    public User login(String email, String senha) {
        User user = null;
        abrirConexao();
        try {
            ResultSet rs;
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM user WHERE email = ? AND senha = ?");
            stm.setString(1, email);
            stm.setString(2, senha);
            rs = stm.executeQuery();
            while (rs.next()) {
            	String nome = rs.getString("nome");
            	String Email = rs.getString("email");
                String Senha = rs.getString("senha");
                int acesso = rs.getInt("acesso");
                user = new User(nome, Email, Senha, acesso);
                user.setId_user(rs.getInt("id_cliente"));
            }
        } catch (SQLException e) {
            System.err.println("Usuario Invalido!! " + e.getMessage());
        } finally {
            fecharConexao(conn, query, rs);
        }
        return user;
    }


	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean verifyCpf(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isEmpty(User user) {
		if (user.getNome().equals("")) {
			AlertBox.campoObrigatorio("NOME");
			return true;
		}
		if (user.getEmail().equals("")) {
			AlertBox.campoObrigatorio("E-MAIL");
			return true;
		}if (user.getSenha().equals("")) {
			AlertBox.campoObrigatorio("SENNHA");
			return true;
		}if (user.getAcesso() == 0 ) {
			AlertBox.campoObrigatorio("ACESSO");
		}
		return false;
	}


	}


