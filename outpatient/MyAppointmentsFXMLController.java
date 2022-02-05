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
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Samir
 */
public class MyAppointmentsFXMLController implements Initializable {

    @FXML
    private Label view_app;
    @FXML
    private Button view_btn;
    @FXML
    private Button cancel_btn;
    @FXML
    private ComboBox<String> choosedr_combox;
    @FXML
    private ComboBox<Integer> canceledid_combobox;
    @FXML
    private ImageView rate;
    @FXML
    private Slider rating;
    @FXML
    private Button rate_btn;
    @FXML
    private Button previouspage_btn;
    @FXML
    private Button logout_btn;
    @FXML
    private Button notView;

    /**
     *
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //inisilization();
        ObservableList<Integer> list = FXCollections.observableArrayList(LoginFXMLController.y.paappid());
        canceledid_combobox.setItems(list);

        ObservableList<String> listt = FXCollections.observableArrayList(LoginFXMLController.y.paappdrnaame());
        choosedr_combox.setItems(listt);
    }

    @FXML
    private void view_click(ActionEvent event) {
        if (LoginFXMLController.y.getPaappoinement().toString().equals(null)) {
            view_app.setText("you have not make an appointment yet ");
        } else {
            view_app.setText(LoginFXMLController.y.getPaappoinementString().toString());
        }
    }

    private void inisilization() {
        ObservableList<Integer> list = FXCollections.observableArrayList(LoginFXMLController.y.paappid());
        canceledid_combobox.setItems(list);
    }

    @FXML
    private void cancel_click(ActionEvent event) {
        int x=canceledid_combobox.getSelectionModel().getSelectedIndex();
        x++;
        LoginFXMLController.y.PacancelAppoinement((x));
        if(!(LoginFXMLController.y.paappid().size()==1)){
        inisilization();
    }
    }

    @FXML
    private void rate_drag(ActionEvent event) {
        LoginFXMLController.y.rateDoctor(choosedr_combox.getSelectionModel().getSelectedItem(), rating.getValue());
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
    private void back_click(ActionEvent event) throws IOException {
        Parent patient = FXMLLoader.load(getClass().getResource("PatientFXML.fxml"));
        Scene patientscene = new Scene(patient);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(patientscene);
        window.show();
    }

    @FXML
    private void notView_click(ActionEvent event) {
        view_app.setText(LoginFXMLController.y.getNotification());
    }
}
