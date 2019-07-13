package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import model.User;
import model.Mysql.UserDao;

public class CadastroUserController {

	@FXML
	public Button confirmar;
	@FXML
	public Button cancelar;
	@FXML
	public TextField nome;
	@FXML
	public PasswordField senha;
	@FXML
	public TextField acesso;
	@FXML
	public TextField email;

	public void confirmar() {
		UserDao obj = new UserDao();

		User user = new User();
		user.setNome(nome.getText());
		user.setEmail(email.getText());
		user.setSenha(senha.getText());
		obj.insert(user);
	}

}
