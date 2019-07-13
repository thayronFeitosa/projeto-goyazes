package model;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class AlertBox {
	
	public static void erroLogin() {
		Alert alert = new Alert(AlertType.WARNING,"");
		alert.setTitle("Erro.");
		alert.setHeaderText("E-Mail ou senha invalido.\nTende novamente");

		alert.show();
	return;
		
	}
	
	public static void campoObrigatorio(String msg) {
		Alert alert = new Alert(Alert.AlertType.WARNING,"");
		alert.setTitle("Erro");
		alert.setHeaderText("O campo "+msg+" é obrigatório");
		alert.show();
		
		
		
	}

}
