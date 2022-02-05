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
import javafx.stage.Stage;



public class PatientFXMLController implements Initializable {

    @FXML
    private ComboBox combobox_Specialization;
    @FXML
    private Button book_btn;
    @FXML
    private Label hidden;
    @FXML
    private Label labell;
    @FXML
    private Button show_btn;
    @FXML
    private DatePicker datee;
    @FXML
    private TextField doc_id;
    @FXML
    private Button submit_btn;
    @FXML
    private Button patient_apointments;
    @FXML
    private TextField timeslot_txt;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ObservableList<Specialization> list = FXCollections.observableArrayList(HospitalSystem.SpecializationList);
          combobox_Specialization.setItems(list);
    }    

    @FXML
    private void submit_click(ActionEvent event) {
                labell.setText(HospitalSystem.seachSpecilization(hidden.getText()).viewDoctorlist().toString());
    }

    @FXML
    private void Select(ActionEvent event) {
          String s = combobox_Specialization.getSelectionModel().getSelectedItem().toString();
            hidden.setText(s);
    }

    @FXML
    private void show_click(ActionEvent event) {
       labell.setText(HospitalSystem.seachSpecilization(hidden.getText()).Searchdoctorid(Integer.parseInt(doc_id.getText())).getShift()+'\n'+HospitalSystem.seachSpecilization(hidden.getText()).Searchdoctorid(Integer.parseInt(doc_id.getText())).getDayAppointments(datee.getValue()).toString());
    }
    
    @FXML
    private void book_click(ActionEvent event) {
        Appointment z = new Appointment(timeslot_txt.getText(),datee.getValue()); 
        LoginFXMLController.y.addAppoinement(z,Integer.parseInt(doc_id.getText()));
    }
    
    @FXML
    private void patient_apointment(ActionEvent event) throws IOException {
        Parent MyAppointments = FXMLLoader.load(getClass().getResource("MyAppointmentsFXML.fxml"));
        Scene MyAppointmentsscene = new Scene(MyAppointments);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(MyAppointmentsscene);
        window.show();
   }

}
