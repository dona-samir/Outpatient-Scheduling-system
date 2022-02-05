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
public class Doctor extends Person implements login {

    private int Novotes = 0;
    private ArrayList<Appointment> drappointment = new ArrayList<Appointment>();
    private ArrayList<Integer> iy = new ArrayList<Integer>();
    private double Rate;
    private String Notification;
    private  int ID;
    private String shift;


    public Doctor(String name, String Number, String email, String Password,String Shift) {
        super(name, Number, email, Password);
        this.shift=Shift;
        this.ID=HospitalSystem.adddoctorid();
        this.Notification="you don't have any  notifications";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNovotes() {
        return Novotes;
    }

    public void setNovotes(int Novotes) {
        this.Novotes = Novotes;
    }

    public ArrayList<Appointment> getDrappointment() {
        return drappointment;
    }

    public void setDrappointment(ArrayList<Appointment> drappointment) {
        this.drappointment = drappointment;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double Rate) {
        this.Rate = Rate;
    }

    public String getNotification() {
        return Notification;
    }

    public void setNotification(String Notification) {
        this.Notification = Notification;
    }

    public String getShift() {
        return "Doctor's shift starts from "+shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public void addDrappoinement(Appointment x) {
        drappointment.add(x);
    }

    @Override
    public boolean login(String x, String y) {
        return HospitalSystem.doctorLogin(x, y);
    }
    
    public ArrayList<Integer> drappid() {
        for (Appointment x :drappointment ) {
            iy.add(x.getAppointmentId());
        }
        return iy;
    }
   /* public void Removeappointement(int appid1) {
          for(Appointment l :drappointment ){
          if(l.getAppointmentId()==appid1){
          drappointment.remove(l);
          }
    }
    }*/
       public Appointment DRSearchpointement(int appid) {
          for(Appointment l :drappointment ){
          if(l.getAppointmentId()==appid){
            drappointment.remove(l);
              return l;
          }
    }
          return null;
    }
    public void   DocancelAppoinement(int x ){
     HospitalSystem.searchappointement(x).removeappointement(x);
     HospitalSystem.searchappointement(x).setNotification("your appointment have been cancelled"+ DRSearchpointement(x).toString());
    } 
    
    public void rateDoctor(double rate) {
        double x = Rate * Novotes;
        this.Rate = (x + rate) / (++Novotes);
    }

    public ArrayList<Appointment> getDayAppointments(LocalDate day) {
        ArrayList<Appointment> dayappointment = new ArrayList<Appointment>();
        for (Appointment x : drappointment) {
            if (x.getDate().equals(day)) {
                dayappointment.add(x);
            }
        }
        return dayappointment;
    }
 
    @Override
    public String toString() {
        return "ID :" + ID + " ," + super.toString() + ", Rate = " + Rate + '\n';
    }

}
