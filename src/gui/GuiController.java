package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class GuiController {

	@FXML
	public Button botao;
	
	@FXML
	public Label lable;
	
	@FXML
	public TextField textoNome;
	
	@FXML
	public PasswordField senha;
	
	@FXML 
	public CheckBox checkBox;
	
	public void onBotao() {
		System.out.println("nome: "+textoNome.getText()+" senha: "+senha.getText());
	}
	
	public void onHelp() {
		String help = "Digite o nome do usuário e a senha para entrar no sistema";
		lable.setText(help);
	}
	
	

}
