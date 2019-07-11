package gui;

import dao.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import model.User;

public class CadastroUserController {

	@FXML
	public Button confirmar;
	@FXML
	public Button cancelar;
	@FXML
	public TextField nome;
	@FXML
	public TextField sobreNome;
	@FXML
	public TextField email;
	
	
	public void confirmar() {
		UserDao obj = new UserDao();
		
		User user = new User();
		user.setNome(nome.getText());
		user.setSobreNome(sobreNome.getText());
		user.setEmail(email.getText());
		
		obj.insert(user);
	}

}
