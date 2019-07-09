package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Cliente;

/**
 * classe respondavel pelas alterações do cliente no banco de dados
 */
public class CadastrarClienteDao implements IDao<Cliente> {
	private Connection conn;
	private PreparedStatement query;
	private ResultSet rs;
	private String sql;
	private Alert alert;

	/**
	 * procura o cliente no banco de dados pelo cpf informado
	 * 
	 * @param cpf
	 * @return
	 */
	public Cliente procurarCpf(String cpf) {
		Cliente cliente = null;

		conn = Conexao.abrirConexao();
		sql = "select * from cliente where cpf = ?";

		boolean resultado = false;

		try {
			query = conn.prepareStatement(sql);
			query.setString(1, cpf.toString());
			rs = query.executeQuery();

			if (rs.next()) {
				cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setSobreNome(rs.getString("sobreNome"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setCpf(rs.getString("cpf"));

			}
		} catch (SQLException e) {

			throw new RuntimeException("erro" + e);
		} finally {
			Conexao.fecharConexao(conn, query, rs);
		}
		return cliente;

	}

	/**
	 * salva o cliente no banco de dados Mas, antes verifica se eles esta
	 * cadastrado, usando o cpf como busca.
	 * 
	 * @param obj
	 * @return
	 */
	@Override
	public boolean insert(Cliente obj) {

		Cliente cliente = procurarCpf(obj.getCpf());
		ValidarCpf validarCpf = new ValidarCpf();
		conn = Conexao.abrirConexao();

		sql = "INSERT INTO cliente (nome, sobreNome, cpf,sexo ) values (?,?,?,?)";
		boolean resultado = false;

		if (validarCpf.isValid(obj))return true;

		if (cliente != null) {
			alert = new Alert(AlertType.ERROR,
					"O CPF informado e do cliente: : " + cliente.getNome() + " " + cliente.getSobreNome());
			alert.setTitle(" CLIENTE JÁ ESTÁ CADASTRADO NO SISTEMA!!!");
			alert.setTitle("Erro");
			alert.setHeaderText("CLIENTE JÁ ESTA CADASTRADO NO SISTEMA!!!");
			alert.show();
			return resultado;
		}
		try {

			query = conn.prepareStatement(sql);
			query.setString(1, obj.getNome());
			query.setString(2, obj.getSobreNome());
			query.setString(3, obj.getCpf());
			query.setString(4, obj.getSexo());

			int verifica = query.executeUpdate();

			if (verifica > 0) {
				alert = new Alert(AlertType.CONFIRMATION, "cliente cadastrado com sucesso");
				alert.setTitle("Sucesso");
				alert.setHeaderText("cliente cadastrado com sucesso");
				alert.show();
				resultado = true;

			}

		} catch (SQLException e) {

			throw new RuntimeException("erro");
		} finally {
			Conexao.fecharConexao(conn, query, rs);
		}
		return resultado;
	}

	@Override
	public boolean delete(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cliente> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Cliente valor) {
		// TODO Auto-generated method stub
		return false;
	}

}
