/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outpatient;

/**
 *
 * @author Samir
 */
public class Admin extends Person implements login{

    public Admin(String name, String Number, String email, String Password) {
        super(name, Number, email, Password);
    }

    
    public void makeDoctorAccount(String name, String Number, String email, String Password,String Shift, String specilizationName) {
        Doctor x = new Doctor (name,  Number,  email,  Password, Shift);
        HospitalSystem.seachSpecilization(specilizationName).addDoctor(x);
    }

    public void MakeAdminAccount(String name, String Number, String email, String Password) {
        Admin x = new Admin( name,  Number, email,Password);
        HospitalSystem.addAdmin(x);
    }
    
      public void removeAdmin (String AdminName ) {
      HospitalSystem.removeAdmin(AdminName);
    } 

    public void removeDoctor(int Doctorid,String specilizationName ) {
    HospitalSystem.seachSpecilization(specilizationName).removeDoctor(Doctorid);
    }
    
      public void removeSpecilization(String Specilizationname){
      HospitalSystem.removeSpecilization(Specilizationname);
      }
    
    public void addSpecialization(String specname){
    Specialization x = new Specialization(specname);
    HospitalSystem.addSpecilization(x);
    }

    @Override
       public boolean login(String x, String y) {
        return HospitalSystem.adminlogin(x, y);
    }  
}