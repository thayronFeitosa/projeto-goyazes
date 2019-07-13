package controller;

import model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.User;

import java.io.IOException;
import java.util.Dictionary;

/**
 * Created by Nadin on 09/11/15.
 */
public class InitialController{
    private User user;

    @FXML private Menu userMenu;
    @FXML private MenuBar userMenuBar;
    @FXML private AnchorPane window;
    @FXML private Menu adm;
    @FXML private Menu manager;
    @FXML private Label version;

 

    public void setUser(User user) {
        this.user = user;
        userMenu.setText(user.getNome());
       
    
        
    }
    
}
