/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outpatient;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Samir
 */
public class Patient extends Person implements login {

    private ArrayList<Appointment> paappoinement = new ArrayList<Appointment>();

    private String Notification;

    private ArrayList<String> drnames = new ArrayList<String>();
    
           

    public Patient() {

    }

    public Patient(String name, String Number, String email, String Password) {
        super(name, Number, email, Password);
        this.Notification="you don't have any  notifications";
    }


    public ArrayList<Appointment> getPaappoinement() {
        return paappoinement;
    }
    

    public void setNotification(String Notification) {
        this.Notification = Notification;
    }

    public String getNotification() {
        return Notification;
    }
    
    @Override
    public boolean login(String x, String y) {
        return HospitalSystem.palogin(x, y);
    }
    public ArrayList<String> getPaappoinementString() {
        if (paappoinement.isEmpty()) {
            return null;
        }
        ArrayList<String> x = new ArrayList<String>();
        for (Appointment v : paappoinement) {
            x.add(v.patoString());
        }
        return x;
    }
    public void addAppoinement(Appointment x, int drid) {

        HospitalSystem.searchforadoctor(drid).Searchdoctorid(drid).addDrappoinement(x);
        drnames.add(HospitalSystem.searchforadoctor(drid).Searchdoctorid(drid).getName());
        paappoinement.add(x);
    }

    public void removeappointement(int appid) {
        for (Appointment l : paappoinement) {
            if (l.getAppointmentId() == appid) {
                this.paappoinement.remove(l);
            }
        }
    }


    public void PacancelAppoinement(int appid) {
        HospitalSystem.searchforappintment(appid).setNotification(HospitalSystem.searchforappintment(appid).DRSearchpointement(appid).toString());//+ " has been cancaled");
       // HospitalSystem.searchforappintment(appid).DRSearchpointement(appid);
        removeappointement(appid);
    }



    public ArrayList<Specialization> viewSpecialization() {
        return HospitalSystem.SpecializationList;
    }

    public ArrayList<Doctor> chooseSpecilization(String choosedSpecializationName) {
        return HospitalSystem.seachSpecilization(choosedSpecializationName).viewDoctorlist();
    }

    public ArrayList<Appointment> viewSchuel(int doctorid, LocalDate day) {
       return HospitalSystem.searchforadoctor(doctorid).Searchdoctorid(doctorid).getDayAppointments(day);
    }

    public void rateDoctor(String name, double rate) {
        HospitalSystem.searchDoctorname(name).rateDoctor(rate);
    }

    public ArrayList<Integer> paappid() {
        ArrayList<Integer> iy = new ArrayList<Integer>();
        for (Appointment x : paappoinement) {
            iy.add(x.getAppointmentId());
        }
        return iy;
    }

    public ArrayList<String> paappdrnaame() {
        return drnames;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
