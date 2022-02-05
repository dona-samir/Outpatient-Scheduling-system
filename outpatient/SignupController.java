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
public class SignupController implements Initializable {

    @FXML
    private TextField paname;
    @FXML
    private Button add_btn;
    @FXML
    private Button back_btn;
    @FXML
    private TextField panumber;
    @FXML
    private TextField paemail;
    @FXML
    private PasswordField papassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add_click(ActionEvent event) {
         Patient y = new Patient(paname.getText(),panumber.getText(),paemail.getText(),papassword.getText());
    HospitalSystem.addPatient(y);
    }

    @FXML
    private void back_click(ActionEvent event) throws IOException {
       Parent patient = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        Scene patientscene = new Scene(patient);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(patientscene);
        window.show();
    }
    
}
