package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Paths;
import model.SoftwareSpecifications;


public class Programa extends Application {

	@Override
	public void start(Stage stage) {
		try {
			
		      Parent root = FXMLLoader.load(getClass().getResource(Paths.loginPath));
		        Scene scene = new Scene(root);
		        stage.setScene(scene); // cansela e não deixa modificar o tamanho da pagina
		        stage.setResizable(false);
		        stage.setTitle(SoftwareSpecifications.getName());
		        stage.centerOnScreen();
		        stage.show();
		
	        
	        	
		}
		catch (IOException e) {
			e.getMessage();
			System.err.println("deu ruim");
			e.printStackTrace();
		}
		}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
