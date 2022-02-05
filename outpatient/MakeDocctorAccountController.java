/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outpatient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Samir
 */
public class MakeDocctorAccountController implements Initializable {

    @FXML
    private TextField drname;
    @FXML
    private TextField drnuumber;
    @FXML
    private TextField dremail;
    @FXML
    private TextField shift;
    @FXML
    private PasswordField drpassword;
    @FXML
    private Button add_btn;
    @FXML
    private ComboBox<Specialization> drspec;
    @FXML
    private Button back_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Specialization> list = FXCollections.observableArrayList(HospitalSystem.SpecializationList);
        drspec.setItems(list);
    }

    @FXML
    private void add_click(ActionEvent event) {
       LoginFXMLController.A.makeDoctorAccount(drname.getText(), drnuumber.getText(), dremail.getText(), drpassword.getText(), shift.getText(), drspec.getSelectionModel().getSelectedItem().toString());
    }
    @FXML
    private void back1_click(ActionEvent event) throws IOException {
        Parent admin = FXMLLoader.load(getClass().getResource("AdminFXML.fxml"));
        Scene adminscene = new Scene(admin);
       Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(adminscene);
        window.show();
    }
}
