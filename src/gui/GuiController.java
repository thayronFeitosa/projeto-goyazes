package gui;

import dao.CadastrarClienteDao;
import dao.ValidarCpf;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Cliente;

public class GuiController {

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
	public TextField textoSexo;

	@FXML
	public PasswordField senha;

	@FXML
	public CheckBox checkBox;

	public void onBotao() {
		
		CadastrarClienteDao obj = new CadastrarClienteDao();
		Cliente cliente = new Cliente(textoNome.getText(), textoSobreNome.getText(), textoCpf.getText(),
				textoSexo.getText());

		obj.insert(cliente);

	}

	public void onHelp() {
		String help = "Digite o nome do usuário e a senha para entrar no sistema";
		lable.setText(help);
	}

}
