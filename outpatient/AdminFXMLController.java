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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Samir
 */
public class AdminFXMLController implements Initializable {

    @FXML
    private ComboBox<Specialization> combobox_Specialization;
    @FXML
    private Button submit1_btn;
    @FXML
    private Label hidden;
    @FXML
    private TextField doc_id;
    @FXML
    private Button remove_btn;
    @FXML
    private TextField admin_name;
    @FXML
    private Button adddoctor_btn;
    @FXML
    private Button addadmin_btn;
    @FXML
    private Button view_btn;
    @FXML
    private Button remove_btn2;
    @FXML
    private TextField sep_name;
    @FXML
    private Button add_btn;
    @FXML
    private Button logout_btn;
    @FXML
    private Label label1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Specialization> list = FXCollections.observableArrayList(HospitalSystem.SpecializationList);
        combobox_Specialization.setItems(list);
    }

    private void inisilize() {
        ObservableList<Specialization> list = FXCollections.observableArrayList(HospitalSystem.SpecializationList);
        combobox_Specialization.setItems(list);
    }

    @FXML
    private void Select_combo(ActionEvent event) {
        String s = combobox_Specialization.getSelectionModel().getSelectedItem().toString();
        hidden.setText(s);
    }

    @FXML
    private void submit1_click(ActionEvent event) {
        label1.setText(HospitalSystem.seachSpecilization(hidden.getText()).viewDoctorlist().toString());
    }

    @FXML
    private void Select(ActionEvent event) {
        LoginFXMLController.A.removeDoctor(Integer.parseInt(doc_id.getText()), hidden.getText());
    }

    @FXML
    private void addsp_click(ActionEvent event) {
        LoginFXMLController.A.addSpecialization(sep_name.getText());
        inisilize();
    }

    @FXML
    private void remove2_click(ActionEvent event) {
        LoginFXMLController.A.removeAdmin(admin_name.getText());
    }

    @FXML
    private void view_click(ActionEvent event) {
        label1.setText(HospitalSystem.AdminList.toString());
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
    private void adddr_click(ActionEvent event) throws IOException {
        Parent patient = FXMLLoader.load(getClass().getResource("MakeDocctorAccount.fxml"));
        Scene patientscene = new Scene(patient);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(patientscene);
        window.show();
    }

    @FXML
    private void addadmin_click(ActionEvent event) throws IOException {
        Parent patient = FXMLLoader.load(getClass().getResource("Add Admin.fxml"));
        Scene patientscene = new Scene(patient);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(patientscene);
        window.show();
    }
}
