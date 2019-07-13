package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Paths;
import model.SoftwareSpecifications;

public class HomeController {

	@FXML
	private Menu userMenu;
	// @FXML private TableView<Order> ordersPanel;
	@FXML
	private MenuBar userMenuBar;
	@FXML
	private AnchorPane window;
	@FXML
	private Menu adm;
	@FXML
	private Menu manager;
	@FXML
	private Label version;

	private void showWindow(String Camilho) throws IOException {
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource(Camilho));
		Scene scene = new Scene(root);
		stage.setScene(scene); // cansela e não deixa modificar o tamanho da pagina
		stage.setResizable(false);
		stage.setMaximized(false);
		stage.setTitle(SoftwareSpecifications.getName());
		stage.centerOnScreen();
		stage.show();
	}

	@FXML
	public void cadastrarCliente(ActionEvent event) throws IOException {
		showWindow(Paths.cadastroClientePath);
	}

	@FXML
	public void cadastrarUsuario(ActionEvent event) throws IOException {
		showWindow(Paths.GuiCadastroUser);
	}

}
