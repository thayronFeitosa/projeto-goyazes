package controller;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.AlertBox;
import model.Paths;
import model.SoftwareSpecifications;
import model.User;
import model.Mysql.UserDao;

/**
 * Classe responsavel por fazer o login 
 * @author thayron
 *
 */

public class LoginController {
	

	@FXML
	private TextField email;
	@FXML
	private Text version;
	@FXML
	private Label logoName;
	@FXML
	private PasswordField senha;


	@FXML
	void onLoginClicked(ActionEvent event) throws IOException {
		UserDao udao = new UserDao();
		User user = udao.buscarUsuario(email.getText(), senha.getText());
		if (user != null) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.GuiHomePath));
			Parent home_page_parent = loader.load();

			

			Scene home_page_scene = new Scene(home_page_parent);
			Stage main_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			main_stage.close();
			main_stage.setScene(home_page_scene);
			main_stage.setTitle(SoftwareSpecifications.getName());
			main_stage.setResizable(true);
			main_stage.setMaximized(true);
			main_stage.show();
		} else {
			AlertBox.erroLogin();
		}
	}}

