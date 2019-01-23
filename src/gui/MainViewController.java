package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemCliente;
	
	@FXML 
	private MenuItem menuItemPedido;
	
	
	@FXML
	public void menuItemClienteAction() {
		System.out.println("menuItemClienteAction");
	}
	
	@FXML
	public void menuItemPedido() {
		System.out.println("menuItemPedido");
	}
	
	
	
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
