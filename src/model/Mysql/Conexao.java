package model.Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
	private static final String url = "jdbc:mysql://localhost:3306/bancodedados?useSSL=false";
	private static final String user = "root";
	private static final String password = "1234561";

	public static Connection abrirConexao() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.getMessage();
			throw new RuntimeException(e);
		}
	}

	public static void fecharConexao(Connection conn, PreparedStatement query, ResultSet rs) {
		try {
			if (conn != null)
				conn.close();
			if (query != null)
				query.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}