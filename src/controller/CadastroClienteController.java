package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Cliente;
import model.ValidarCpf;
import model.Mysql.ClienteDao;

public class CadastroClienteController {

	@FXML
	public Button botao;

	@FXML
	public Label lable;

	@FXML
	public TextField textoNome;
	@FXML
	public TextField textoSobreNome;
	@FXML
	public TextField textoCpf;
	
	@FXML
	public TextField email;


	public void onBotao() {
		
		ClienteDao obj = new ClienteDao();
		Cliente cliente = new Cliente();
		cliente.setCpf(textoCpf.getText());
		cliente.setEmail(email.getText());
		cliente.setNome(textoNome.getText());
		cliente.setSobreNome(textoSobreNome.getText());

		obj.insert(cliente);

	}



}
