package outpatient;

import java.time.LocalDate;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Admin admin = new Admin("Dona", "012074008", "donasamir_admin@gmail.com", "123456");
        admin.MakeAdminAccount("Dona", "012074008", "donasamir_admin@gmail.com", "123456");
        admin.addSpecialization("dentist");
        admin.addSpecialization("dermatologist");
        admin.makeDoctorAccount("ali", "01284747", "2", "2", "thursdaty to monday from 3:00 to 7:00 PM", "dentist");
        admin.makeDoctorAccount("Dona", "012874747", "donasamir_doctor@gmail.com", "123456", "Thursday to Monday from 3:00 to 7:00 PM", "dentist");
        admin.makeDoctorAccount("hania", "01184756", "jj", "kk", " thursdaty to monday from 9:00 to 11:00 AM", "dentist");
        admin.makeDoctorAccount("alia", "01288876", "D", "f", "thursdaty to monday from 3:00 to 7:00 PM","dermatologist");
        admin.makeDoctorAccount("Ahmed", "01286785", "ahmed@gmail.com", "ahmed03874", "thursdaty to monday from 9:00 to 11:00 AM", "dermatologist");
        Patient a = new Patient("Alia", "01234408745", "alia@yahoo.com", "0298746djcb");
        Patient x = new Patient("Dona", "01567889904", "donasamir_patient@gmail.com", "123456");
         //x.rateDoctor(1, 5);
        
        Patient y = new Patient("a", "01207400885", "alia@yahoo.com", "0298746djcb");
        HospitalSystem.addPatient(y);
        x.login("uvjc","guifviviu");
        Admin l = new Admin("alia", "as", "sdad", "efcsdf");
        admin.MakeAdminAccount("alia", "as", "sdad", "efcsdf");
        System.out.print(HospitalSystem.seachSpecilization("dentist").viewDoctorlist());
        System.out.print(HospitalSystem.seachSpecilization("dermatologist").viewDoctorlist());
        Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        System.out.println(x.getPaappoinement());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
