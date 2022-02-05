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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginFXMLController implements Initializable {

    @FXML
    private Text Signup_txt;
    @FXML
    private Button login_btn;
    @FXML
    private ComboBox comboBox_combo;
    //@FXML
    //private Text s;
    @FXML
    private Label hidden;
    @FXML
    private Label errormsg;
    @FXML
    private TextField email_lb;
    @FXML
    private PasswordField password_lb;
    @FXML
    private Text s;
    public static Patient y;
    public static Admin A;
    public static Doctor D;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> list = FXCollections.observableArrayList("Doctor", "Patient", "Admin");
        comboBox_combo.setItems(list);
    }


    @FXML
    private void login_clicked(ActionEvent event) throws IOException {

        if (hidden.getText().equals("Patient")) {
            if (HospitalSystem.palogin(email_lb.getText(), password_lb.getText())) {
                Parent patient = FXMLLoader.load(getClass().getResource("PatientFXML.fxml"));
                Scene patientscene = new Scene(patient);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(patientscene);
                window.show();
                y = HospitalSystem.pasearch(email_lb.getText(), password_lb.getText());
            } else {
                errormsg.setText("please enter a valid email and password");
            }
        } else if (hidden.getText().equals("Doctor")) {
            if (HospitalSystem.doctorLogin(email_lb.getText(), password_lb.getText())) {
                Parent doctor = FXMLLoader.load(getClass().getResource("Doctor.fxml"));
                Scene drscene = new Scene(doctor);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(drscene);
                window.show();
                D = HospitalSystem.doctorsearch(email_lb.getText(), password_lb.getText());
            } else {
                errormsg.setText("please enter a valid email and password");
            }
        } else if (hidden.getText().equals("Admin")) {
            if (HospitalSystem.adminlogin(email_lb.getText(), password_lb.getText())) {
                Parent admin = FXMLLoader.load(getClass().getResource("AdminFXML.fxml"));
                Scene adminscene = new Scene(admin);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(adminscene);
                window.show();
                A = HospitalSystem.adminsearch(email_lb.getText(), password_lb.getText());
            } else {
                errormsg.setText("please enter a valid email and password");
            }
        } else {
            errormsg.setText("Please,choose if you are a Patient ,doctor or admin ");
        }
    }

    @FXML
    private void Select(ActionEvent event) {

        String s = comboBox_combo.getSelectionModel().getSelectedItem().toString();
        hidden.setText(s);
    }


    @FXML
    private void sign_up(MouseEvent event) throws IOException {
        Parent admin = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        Scene adminscene = new Scene(admin);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(adminscene);
        window.show();
    }

}
