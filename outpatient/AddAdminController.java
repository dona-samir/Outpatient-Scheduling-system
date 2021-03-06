/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outpatient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Samir
 */
public class AddAdminController implements Initializable {

    @FXML
    private TextField drname;
    @FXML
    private TextField drnuumber;
    @FXML
    private TextField dremail;
    @FXML
    private PasswordField drpassword;
    @FXML
    private Button add_btn;
    @FXML
    private Button back_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @FXML
        private void add_click(ActionEvent event) {
       LoginFXMLController.A.MakeAdminAccount(drname.getText(), drnuumber.getText(), dremail.getText(), drpassword.getText());
    }
      @FXML  
      private void back_click(ActionEvent event) throws IOException {
       Parent admin = FXMLLoader.load(getClass().getResource("AdminFXML.fxml"));
       Scene adminscene = new Scene(admin);
       Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
       window.setScene(adminscene);
       window.show();
    }
}
