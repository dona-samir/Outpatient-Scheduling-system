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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Samir
 */
public class DoctorController implements Initializable {

    @FXML
    private ImageView View_btn;
    @FXML
    private Label labell;
    @FXML
    private Button show_btn;
    @FXML
    private DatePicker datee;
    @FXML
    private Button cancel_btn;
    @FXML
    private Button logout_btn;
    @FXML
    private Button view_btn;

    @FXML
    private TextField canceledid1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void show_click(ActionEvent event) {
        if (LoginFXMLController.D.getDayAppointments(datee.getValue()).toString() == null) {
            labell.setText("you don't have  an appointment yet ");
        } else {
            labell.setText(LoginFXMLController.D.getDayAppointments(datee.getValue()).toString());
        }
    }

    @FXML
    private void cancel_click(ActionEvent event) {
        LoginFXMLController.D.DocancelAppoinement(Integer.parseInt(canceledid1.getText()));
    }

    @FXML
    private void logout_click(ActionEvent event) throws IOException {
        Parent patient = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        Scene patientscene = new Scene(patient);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(patientscene);
        window.show();
    }

    @FXML
    private void View_Click(ActionEvent event) {
        labell.setText(LoginFXMLController.D.getNotification());
    }

}
